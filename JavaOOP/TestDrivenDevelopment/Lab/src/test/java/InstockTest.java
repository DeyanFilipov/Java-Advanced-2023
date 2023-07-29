import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest {

    private static final String LABEL = "test_label";
    private static final double PRICE = 9.99;
    private static final int QUANTITY = 1;
    private ProductStock stock;
    private Product defaultProduct;

    @Before
    public void setUp() {
        this.stock = new Instock();
        this.defaultProduct = new Product(LABEL, PRICE, QUANTITY);
    }

    @Test
    public void testContainsShouldReturnFalseWhenProductNotPresentAndThenTrueAfterAdded() {
        assertFalse(stock.contains(defaultProduct));
        stock.add(defaultProduct);
        assertTrue(stock.contains(defaultProduct));
    }


    @Test
    public void testAddProductShouldAddTheProductInsideTheStock() {
        stock.add(defaultProduct);
        assertEquals(1, stock.getCount());
    }


    @Test
    public void testAddProductShouldNotAddTheSameForASecondTime() {
        stock.add(defaultProduct);
        stock.add(defaultProduct);
        assertEquals(1, stock.getCount());
    }

    @Test
    public void testCountShouldReturnTheCorrectNumberOfProducts() {
        assertEquals(0, stock.getCount());
        stock.add(defaultProduct);
        assertEquals(1, stock.getCount());
    }

    @Test
    public void testFindByIndexShouldReturnTheCorrectProductWhenOnlyOnePresent() {
        stock.add(defaultProduct);
        Product product = stock.find(0);
        assertNotNull(product);
        assertEquals(defaultProduct.label, product.label);
    }

    @Test
    public void testFindByIndexShouldReturnTheCorrectProductWhenTheProductIsBetweenOtherProducts() {
        stubProducts();
        Product product = stock.find(4);
        assertNotNull(product);
        assertEquals("test_label_5", product.label);
    }

    @Test
    public void testFindByIndexShouldReturnTheCorrectProductWhenTheProductIsTheLastOne() {
        stubProducts();
        Product product = stock.find(9);
        assertNotNull(product);
        assertEquals("test_label_10", product.label);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexShouldThrowIfIndexMoreThanStockCountMinusOne() {
        stubProducts();
        Product product = stock.find(11);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexShouldThrowIfIndexLessThanZero() {
        stubProducts();
        Product product = stock.find(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexShouldThrowIfStockIsEmpty() {
        Product product = stock.find(0);
    }

    @Test
    public void testChangeQuantityShouldUpdateTheParameterWithTheCorrectAmount() {
        stubProducts();
        stock.add(defaultProduct);
        assertEquals(QUANTITY, defaultProduct.getQuantity());
        stock.changeQuantity(defaultProduct.label, 13);
        assertEquals(13, defaultProduct.quantity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityShouldThrowIfProductNotInStock() {
        stubProducts();
        stock.changeQuantity(defaultProduct.label, 13);
    }

    @Test
    public void testFindByLabelReturnsTheCorrectProductWithTheSameLabelWhenInStock() {
        stubProducts();
        stock.add(defaultProduct);
        Product product = stock.findByLabel(defaultProduct.label);
        assertNotNull(product);
        assertEquals(defaultProduct.label, product.label);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelThrowsIfProductWithThatLabelNotInStock() {
        stubProducts();
        Product product = stock.findByLabel("test_label_12");
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionWhenStockIsZero() {
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(0);
        List<Product> list = createListFromIterable(iterable);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionWhenParameterIsTooBig() {
        stubProducts();
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(12);
        List<Product> list = createListFromIterable(iterable);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnsTheCorrectNumberOfProducts() {
        stubProducts();
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(8);
        List<Product> list = createListFromIterable(iterable);
        assertEquals(8, list.size());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnsTheCorrectProductsSortedAlphabetically() {
        List<Product> expected = stubProducts().stream()
                .limit(8)
                .sorted(Comparator.comparing(Product::getLabel))
                .collect(Collectors.toList());
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(8);
        List<Product> list = createListFromIterable(iterable);
        for (int i = 0; i < list.size(); i++) {
            assertEquals(expected.get(i).getLabel(), list.get(i).getLabel());
        }
    }

    @Test
    public void testFindAllInPriceRangeShouldReturnEmptyCollectionWhenThereAreNotAnyProductsInRange() {
        List<Product> expected = stubProducts();
        List<Product> list = createListFromIterable(stock.findAllInRange(999, 1020));
        assertEquals(0, list.size());
    }

    @Test
    public void testFindAllInPriceRangeShouldReturnTheCorrectProductsInRange() {
        List<Product> products = stubProducts();
        List<Product> list = createListFromIterable(stock.findAllInRange(11, 20));//lo-exclusive.hi-inclusive
        assertEquals(6, list.size());
        for (Product product : list) {
            assertTrue(product.getPrice() > 11 && product.getPrice() <= 20);
        }
    }

    @Test
    public void testFindAllInPriceRangeShouldReturnTheProductsInDescendingOrderByPrice() {
        List<Product> expected = stubProducts().stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .filter(p -> p.getPrice() > 11 && p.getPrice() <= 20)
                .collect(Collectors.toList());
        ;
        List<Product> list = createListFromIterable(stock.findAllInRange(11, 20));//lo-exclusive.hi-inclusive
        assertEquals(expected, list);
    }

    @Test
    public void testFindAllByPriceShouldReturnEmptyCollectionWhenThereAreNotAnyProductsWithThatPrice() {
        List<Product> products = stubProducts();
        List<Product> list = createListFromIterable(stock.findAllByPrice(999.99));
        assertEquals(0, list.size());
    }

    @Test
    public void testFindAllByPriceShouldReturnTheCorrectAmountOfProductsWithTheGivenPrice() {
        List<Product> products = stubProducts();
        stock.add(defaultProduct);
        List<Product> list = createListFromIterable(stock.findAllByPrice(99));
        assertEquals(2, list.size());
    }

    @Test
    public void testFindAllByPriceShouldReturnTheCorrectProductsWithTheGivenPrice() {
        List<Product> products = stubProducts();
        stock.add(defaultProduct);
        List<Product> list = createListFromIterable(stock.findAllByPrice(99));
        for (Product product : list) {
            assertEquals(99, product.getPrice(), 0.00);
        }
    }

    @Test
    public void testFindFirstMostExpensiveProductsReturnsTheCorrectAmountOfProducts() {
        List<Product> expected = stubProducts().stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(5)
                .collect(Collectors.toList());
        List<Product> list = createListFromIterable(stock.findFirstMostExpensiveProducts(5));
        assertEquals(5, list.size());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(expected.get(i).getPrice(), list.get(i).getPrice(), 0.00);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsThrowsIfProductsAreLessThanTheGivenCount() {
        stubProducts();
        List<Product> list = createListFromIterable(stock.findFirstMostExpensiveProducts(stock.getCount() + 1));
    }

    @Test
    public void testFindAllByQuantityReturnsTheCorrectAmountOfProductsWithGivenQuantityInStock() {
        List<Product> expected = stubProducts().stream().filter(p -> p.getQuantity() == 5).collect(Collectors.toList());
        List<Product> list = createListFromIterable(stock.findAllByQuantity(5));
        assertEquals(expected.size(), list.size());
    }

    @Test
    public void testFindAllByQuantityReturnsTheCorrectProductsWithGivenQuantityInStock() {
        List<Product> expected = stubProducts().stream().filter(p -> p.getQuantity() == 5).collect(Collectors.toList());
        List<Product> list = createListFromIterable(stock.findAllByQuantity(5));
        assertEquals(expected, list);
    }

    @Test
    public void testIteratorShouldReturnAllProductsInStock() {
        List<Product> expected = stubProducts();
        Iterator<Product> iterator = stock.iterator();
        assertNotNull(iterator);
        int index = 0;
        while (iterator.hasNext()) {
            Product product = iterator.next();
            assertEquals(expected.get(index++), product);
        }
    }

    //Helpers:
    private List<Product> createListFromIterable(Iterable<Product> iterable) {
        assertNotNull(iterable);
        List<Product> products = new ArrayList<>();
        iterable.forEach(products::add);
        return products;
    }

    private List<Product> stubProducts() {
        List<Product> expected = Arrays.asList(
                new Product("test_label_1", 99.00, 2),
                new Product("test_label_2", 11.01, 5),
                new Product("test_label_3", 12.00, 8),
                new Product("test_label_4", 20.00, 5),
                new Product("test_label_5", 99.00, 5),
                new Product("test_label_6", 18.50, 16),
                new Product("test_label_7", 16.00, 12),
                new Product("test_label_8", 37.20, 7),
                new Product("test_label_9", 18.00, 3),
                new Product("test_label_10", 21.00, 8));
        for (Product product : expected) {
            stock.add(product);
        }
        return expected;
    }
}