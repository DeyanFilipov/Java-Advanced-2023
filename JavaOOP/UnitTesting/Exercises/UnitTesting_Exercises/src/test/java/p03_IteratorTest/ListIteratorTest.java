package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private static final String[] ELEMENTS = new String[]{"A", "B", "C", "D", "E"};
    private ListIterator listIterator;

    @Before
    public void SetUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithNullParameters() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testHasNextReturnsCorrectBoolean() {
        for (int i = 0; i < ELEMENTS.length; i++) {
            if (i == ELEMENTS.length - 1) {
                assertFalse(listIterator.hasNext());
                assertFalse(listIterator.move());
                break;
            }
            assertTrue(listIterator.hasNext());
            assertTrue(listIterator.move());
        }
    }


    @Test(expected = IllegalStateException.class)
    public void testPrintThrowsWithZeroElements() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintCorrectElements() {
        int index = 0;
        for (; listIterator.hasNext(); listIterator.move()) {
            assertEquals(ELEMENTS[index++], listIterator.print());
        }
    }
}