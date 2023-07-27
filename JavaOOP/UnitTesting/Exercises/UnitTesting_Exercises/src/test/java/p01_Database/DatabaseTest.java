package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    private static final Integer[] NUMBERS = {5, 8, 20, 67, 98};
    private Database database;
    private static Integer[] elementsInDatabase;

    @Before
    public void SetUp() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
        elementsInDatabase = database.getElements();
    }

    //Constructor
    @Test
    public void testConstructorCreatesValidObject() {
        assertEquals("Count of elements is not correct", NUMBERS.length, elementsInDatabase.length);
        for (int i = 0; i < elementsInDatabase.length; i++) {
            assertEquals("Arrays are not the same", NUMBERS[i], elementsInDatabase[i]);
        }
    }

    //Constructor
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionWhenArrayHasMoreThanSixteenElements() throws OperationNotSupportedException {
        new Database(new Integer[17]);
    }

    //Constructor
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionWhenArrayHasLessThanOneElements() throws OperationNotSupportedException {
        new Database();
    }

    @Test
    public void testGetElementsShouldReturnCorrectArray() {
        for (int i = 0; i < elementsInDatabase.length; i++) {
            assertEquals(NUMBERS[i], elementsInDatabase[i]);
        }
    }

    //Add
    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowWhenParamNull() throws OperationNotSupportedException {
        database.add(null);
    }

    //Add
    @Test
    public void testAddShouldAddElementAtTheEnd() throws OperationNotSupportedException {
        Integer element = 13;
        database.add(element);
        elementsInDatabase=database.getElements();
        assertEquals(NUMBERS.length + 1, elementsInDatabase.length);
        assertEquals(element, elementsInDatabase[elementsInDatabase.length - 1]);
    }

    //If you try to remove element from empty Database throw OperationNotSupportedException
    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowIfDataBaseIsEmpty() throws OperationNotSupportedException {
        database = new Database(new Integer[1]);
        database.remove();
        database.remove();
    }

    //Remove operation, should support only removing an element at the last index. (just like a stack)
    @Test
    public void testRemoveShouldRemoveTheLastElementWhenNotEmpty() throws OperationNotSupportedException {
        database.remove();
        elementsInDatabase=database.getElements();
        assertEquals(NUMBERS.length - 1, elementsInDatabase.length);
        for (int i = 0; i < elementsInDatabase.length; i++) {
            assertEquals(NUMBERS[i], elementsInDatabase[i]);
        }
    }
}