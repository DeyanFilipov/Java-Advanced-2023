package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    private CustomLinkedList list;

    @Before
    public void setUp() {
        list = new CustomLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

    }

    //add
    @Test
    public void testAddShouldWork() {
        list = new CustomLinkedList();
        list.add(5);
        assertTrue(list.contains(5));
    }

    //get
    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowWithEmptyList() {
        list = new CustomLinkedList();
        list.get(0);
    }
    //get
    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowIfIndexLessThanZero() {
        list.get(-1);
    }

    //get
    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowIfIndexHigherThanListLength() {
        list.get(5);
    }

    //get
    @Test
    public void testGetShouldReturnCorrectElement() {
        list.get(2);
    }

    //set
    @Test(expected = IllegalArgumentException.class)
    public void testSetShouldThrowIfIndexLessThanZero() {
        list.set(-1, 5);
    }

    //set
    @Test(expected = IllegalArgumentException.class)
    public void testSetShouldThrowIfIndexHigherThanListLength() {
        list.set(4, 7);
    }

    //set
    @Test
    public void testSetShouldPutCorrectElementAtGivenIndex() {
        list.set(3, 8);
        assertEquals(8, list.get(3));
    }

    //removeAt
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtShouldThrowIfIndexLessThanZero() {
        list.removeAt(-1);
    }

    //removeAt
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtShouldThrowIfIndexHigherThanListLength() {
        list.removeAt(4);
    }

    //removeAt
    @Test
    public void testRemoveAtShouldReturnTheCorrectRemovedElement() {
        assertEquals(list.get(2), list.removeAt(2));
    }

    //remove
    @Test
    public void testRemoveShouldReturnMinusOneIfElementNotInList() {
        assertEquals(-1, list.remove(10));
    }

    //remove
    @Test
    public void testRemoveShouldIndexIfElementIsInList() {
        assertEquals(2, list.remove(3));
    }

    //indexOf
    @Test
    public void testIndexOfShouldReturnMinusOneIfElementNotInList() {
        assertEquals(-1, list.indexOf(10));
    }

    //indexOf
    @Test
    public void testIndexOfShouldReturnFirstOccurrenceOfElement() {
        list.add(2);
        assertEquals(1, list.indexOf(2));
    }

    //indexOf
    @Test
    public void testIfListContainsElement() {
       assertTrue(list.contains(3));
    }
    //indexOf
    @Test
    public void testIfListDoesNotContainElement() {
        assertFalse(list.contains(10));
    }

}