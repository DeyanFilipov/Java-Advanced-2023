import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionImplTest {


    public static final int DEF_ID = 1;
    public static final String DEF_SENDER = "Pesho";
    private static final TransactionStatus DEF_STATUS = TransactionStatus.SUCCESSFUL;
    public static final String DEF_RECEIVER = "Gosho";
    public static final double DEF_AMOUNT = 100;
    private Transaction defTransaction;


    @Before
    public void setUp() {
        this.defTransaction = new TransactionImpl(DEF_ID, DEF_STATUS, DEF_SENDER, DEF_RECEIVER, DEF_AMOUNT);
    }

    @Test
    public void testEqualsShouldReturnTrueWithTransactionsWithSameParameters() {
        Transaction second = new TransactionImpl(DEF_ID, DEF_STATUS, DEF_SENDER, DEF_RECEIVER, DEF_AMOUNT);
        assertEquals(defTransaction, second);
    }

    @Test
    public void testEqualsShouldReturnFalseWithTransactionsWithDifferentStatuses() {
        Transaction second = new TransactionImpl(DEF_ID, TransactionStatus.ABORTED, DEF_SENDER, DEF_RECEIVER, DEF_AMOUNT);
        assertNotEquals(defTransaction, second);
    }

    @Test
    public void testEqualsShouldReturnFalseWithTransactionsWithDifferentId() {
        Transaction second = new TransactionImpl(DEF_ID + 1, DEF_STATUS, DEF_SENDER, DEF_RECEIVER, DEF_AMOUNT);
        assertNotEquals(defTransaction, second);
    }

    @Test
    public void testEqualsShouldReturnFalseWithTransactionsWithDifferentSender() {
        Transaction second = new TransactionImpl(DEF_ID + 1, DEF_STATUS, "Sasho", DEF_RECEIVER, DEF_AMOUNT);
        assertNotEquals(defTransaction, second);
    }

    @Test
    public void testEqualsShouldReturnFalseWithTransactionsWithDifferentReceiver() {
        Transaction second = new TransactionImpl(DEF_ID, DEF_STATUS, DEF_SENDER, "Kircho", DEF_AMOUNT);
        assertNotEquals(defTransaction, second);
    }

    @Test
    public void testEqualsShouldReturnFalseWithTransactionsWithDifferentAmount() {
        Transaction second = new TransactionImpl(DEF_ID, DEF_STATUS, DEF_SENDER, DEF_RECEIVER, 100.20);
        assertNotEquals(defTransaction, second);
    }

    @Test
    public void testHashCodeShouldReturnSameCodeForEqualTransactions() {
        Transaction second = new TransactionImpl(DEF_ID, DEF_STATUS, DEF_SENDER, DEF_RECEIVER, DEF_AMOUNT);
        assertEquals(defTransaction.hashCode(), second.hashCode());
    }

    @Test
    public void testHashCodeShouldReturnDifferentCodeForNotEqualTransactions() {
        Transaction second = new TransactionImpl(DEF_ID, TransactionStatus.FAILED, DEF_SENDER, DEF_RECEIVER, DEF_AMOUNT);
        assertNotEquals(defTransaction.hashCode(), second.hashCode());
    }

    @Test
    public void testCompareShouldReturnZeroForEqualIds() {
        TransactionImpl first = new TransactionImpl(DEF_ID, DEF_STATUS, DEF_SENDER, DEF_RECEIVER, DEF_AMOUNT);
        TransactionImpl second = new TransactionImpl(DEF_ID, TransactionStatus.FAILED, "Sasho", "Kiro", 120.50);
        assertEquals(0, first.compareTo(second));
    }

    @Test
    public void testCompareShouldReturnNegativeForEqualFirstIdBiggerThanTheSecondId() {
        TransactionImpl first = new TransactionImpl(DEF_ID + 1, DEF_STATUS, DEF_SENDER, DEF_RECEIVER, DEF_AMOUNT);
        TransactionImpl second = new TransactionImpl(DEF_ID, TransactionStatus.FAILED, "Sasho", "Kiro", 120.50);
        assertTrue(first.compareTo(second) > 0);
    }

    @Test
    public void testCompareShouldReturnPositiveForEqualFirstIdLowerThanTheSecondId() {
        TransactionImpl first = new TransactionImpl(DEF_ID, DEF_STATUS, DEF_SENDER, DEF_RECEIVER, DEF_AMOUNT);
        TransactionImpl second = new TransactionImpl(DEF_ID+1, TransactionStatus.FAILED, "Sasho", "Kiro", 120.50);
        assertTrue(first.compareTo(second) < 0);
    }
}