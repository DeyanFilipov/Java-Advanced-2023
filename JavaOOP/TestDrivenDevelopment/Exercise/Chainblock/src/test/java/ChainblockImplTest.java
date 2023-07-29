import org.junit.Before;
import org.junit.Test;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class ChainblockImplTest {


    public static final int DEF_ID = 1;
    public static final String DEF_SENDER = "Pesho";
    private static final TransactionStatus DEF_STATUS = TransactionStatus.SUCCESSFUL;
    public static final String DEF_RECEIVER = "Gosho";
    public static final double DEF_AMOUNT = 100;
    private Transaction defTransaction;
    private Chainblock chainblock;

    @Before
    public void setUp() {
        this.defTransaction = new TransactionImpl(DEF_ID, DEF_STATUS, DEF_SENDER, DEF_RECEIVER, DEF_AMOUNT);
        this.chainblock = new ChainblockImpl();
    }


    @Test
    public void testAddShouldIncreaseTheCountOfTransactions() {
        assertEquals(0, chainblock.getCount());
        chainblock.add(defTransaction);
        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void testAddShouldNotAddTheSameTransactionTwice() {
        chainblock.add(defTransaction);
        chainblock.add(defTransaction);
        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void testContainsTransactionShouldFalseWhenTransactionNotInChainblockAndTrueWhenInChainblock() {
        assertFalse(chainblock.contains(defTransaction));
        chainblock.add(defTransaction);
        assertTrue(chainblock.contains(defTransaction));
    }

    @Test
    public void testContainsIdShouldReturnCorrectBoolean() {
        assertFalse(chainblock.contains(DEF_ID));
        chainblock.add(defTransaction);
        assertTrue(chainblock.contains(DEF_ID));
    }

    @Test
    public void testContainsIdShouldReturnTrueWhenChainblockHasTransactionWithGivenId() {
        chainblock.add(defTransaction);
        assertTrue(chainblock.contains(defTransaction.getId()));
    }

    @Test
    public void testGetCountReturnsTheCorrectAmountOfTransactionsInChainblock() {
        List<Transaction> transactions = stubTransactions();
        assertEquals(transactions.size(), chainblock.getCount());
    }

    @Test
    public void testGetCountReturnsZeroWhenChainblockIsEmpty() {
        assertEquals(0, chainblock.getCount());
    }

    @Test
    public void testChangeTransactionStatusShouldAmendTheCorrectStatusWhenTransactionWithGivenIdIsPresent() {
        chainblock.add(defTransaction);
        chainblock.changeTransactionStatus(defTransaction.getId(), TransactionStatus.FAILED);
        assertEquals(TransactionStatus.FAILED, defTransaction.getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusShouldThrowWhenTransactionWithGivenIdNotInChainblock() {
        stubTransactions();
        chainblock.changeTransactionStatus(13, TransactionStatus.FAILED);
    }

    @Test
    public void testRemoveTransactionByIdShouldRemoveTheCorrectTransaction() {
        chainblock.add(defTransaction);
        chainblock.removeTransactionById(defTransaction.getId());
        assertFalse(chainblock.contains(defTransaction.getId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdShouldThrowIfThereIsNoTransactionWithTheGivenIdInChainblock() {
        stubTransactions();
        chainblock.removeTransactionById(12);
    }

    @Test
    public void testGetByIdShouldReturnTheTheCorrectTransaction() {
        List<Transaction> transactions = stubTransactions();
        Transaction expected = transactions.get(3);
        Transaction actual = chainblock.getById(expected.getId());
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdShouldThrowIfThereIsNoTransactionWithTheGivenIdInChainblock() {
        List<Transaction> transactions = stubTransactions();
        chainblock.getById(transactions.get(transactions.size() - 1).getId() + 1);
    }

    @Test
    public void testGetByTransactionStatusShouldReturnTheCorrectAmountOfTransactions() {
        List<Transaction> expected = stubTransactions().stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.ABORTED))
                .collect(Collectors.toList());
        List<Transaction> result = createListFromIterable(chainblock.getByTransactionStatus(TransactionStatus.ABORTED));
        assertEquals(expected.size(), result.size());
    }

    @Test
    public void testGetByTransactionStatusShouldReturnTheCorrectTransactions() {
        stubTransactions();
        List<Transaction> actual = createListFromIterable(chainblock.getByTransactionStatus(TransactionStatus.ABORTED));
        for (Transaction t : actual) {
            assertEquals(TransactionStatus.ABORTED, t.getStatus());
        }
    }

    @Test
    public void testGetByTransactionStatusShouldReturnTransactionsInCorrectOrder() {
        List<Transaction> expected = stubTransactions().stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.ABORTED))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
        List<Transaction> actual = createListFromIterable(chainblock.getByTransactionStatus(TransactionStatus.ABORTED));
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusShouldThrowIfNoTransactionsWithGivenStatus() {
        chainblock.add(defTransaction);
        chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetAllSendersWithTransactionStatusReturnsTheCorrectAmountOfSenders() {
        List<Transaction> transactions = stubTransactions();
        List<String> expected = transactions.stream()
                .filter(t -> t.getStatus() == TransactionStatus.ABORTED)
                .map(Transaction::getFrom)
                .collect(Collectors.toList());
        List<String> senders = new ArrayList<>();
        Iterable<String> iterable = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
        assertNotNull(iterable);
        iterable.forEach(senders::add);
        assertEquals(expected.size(), senders.size());
    }

    @Test
    public void testGetAllSendersWithTransactionStatusReturnsTheCorrectListOfSenders() {
        List<Transaction> transactions = stubTransactions();
        List<String> expected = transactions.stream()
                .filter(t -> t.getStatus() == TransactionStatus.ABORTED)
                .sorted(Comparator.comparing(Transaction::getAmount))
                .map(Transaction::getFrom)
                .collect(Collectors.toList());
        List<String> actual = new ArrayList<>();
        Iterable<String> senders = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
        assertNotNull(actual);
        senders.forEach(actual::add);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }


    @Test
    public void testGetAllSendersSendersWithTransactionStatusShouldReturnMultipleDuplicatedSenders() {
        List<Transaction> sendersDuplicated = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Transaction transaction = new TransactionImpl(2,
                    TransactionStatus.UNAUTHORIZED,
                    "from_10", "to",
                    10000 + i);
            sendersDuplicated.add(transaction);
            chainblock.add(transaction);
        }
        List<String> expected = new ArrayList<>();
        sendersDuplicated = sendersDuplicated.stream().sorted(Comparator.comparing(Transaction::getAmount))
                .collect(Collectors.toList());
        sendersDuplicated.forEach(s -> expected.add(s.getFrom()));
        Iterable<String> actual = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
        int index = 0;
        for (String s : actual) {
            assertEquals(expected.get(index++), s);
        }
    }


    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusRShouldThrowIfStatusNotInChainblock() {
        Iterable<String> iterable = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.FAILED);
    }

    @Test
    public void testGetAllReceiversWithTransactionStatusReturnsTheCorrectAmountOfReceivers() {
        List<Transaction> transactions = stubTransactions();
        List<String> expected = transactions.stream()
                .filter(t -> t.getStatus() == TransactionStatus.ABORTED)
                .map(Transaction::getTo)
                .collect(Collectors.toList());
        List<String> receivers = new ArrayList<>();
        Iterable<String> iterable = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
        assertNotNull(iterable);
        iterable.forEach(receivers::add);
        assertEquals(expected.size(), receivers.size());
    }

    @Test
    public void testGetAllReceiversWithTransactionStatusReturnsTheCorrectReceivers() {
        List<Transaction> transactions = stubTransactions();
        List<String> expected = transactions.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .sorted(Comparator.comparing(Transaction::getAmount))
                .map(Transaction::getTo)
                .collect(Collectors.toList());
        List<String> actual = new ArrayList<>();
        Iterable<String> receivers = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertNotNull(receivers);
        receivers.forEach(actual::add);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testGetAllReceiversWithTransactionStatusShouldReturnMultipleDuplicatedSenders() {
        List<Transaction> receiversDuplicated = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Transaction transaction = new TransactionImpl(2,
                    TransactionStatus.UNAUTHORIZED,
                    "from_10", "to_10",
                    10000 + i);
            receiversDuplicated.add(transaction);
            chainblock.add(transaction);
        }
        List<String> expected = new ArrayList<>();
        receiversDuplicated = receiversDuplicated.stream().sorted(Comparator.comparing(Transaction::getAmount))
                .collect(Collectors.toList());
        receiversDuplicated.forEach(s -> expected.add(s.getTo()));
        Iterable<String> actual = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
        int index = 0;
        for (String s : actual) {
            assertEquals(expected.get(index++), s);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatusRShouldThrowIfStatusNotInChainblock() {
        Iterable<String> iterable = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.FAILED);
    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenByIdReturnsTheTransactionInCorrectOrder() {
        List<Transaction> expected = stubTransactions().stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
        List<Transaction> actual = createListFromIterable(chainblock.getAllOrderedByAmountDescendingThenById());
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetBySenderOrderedByAmountDescendingReturnsTheCorrectAmountOfTransactions() {
        List<Transaction> expected = stubTransactions().stream()
                .filter(t -> t.getFrom().equals("from_2"))
                .collect(Collectors.toList());
        List<Transaction> actual = createListFromIterable(chainblock.getBySenderOrderedByAmountDescending("from_2"));
        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void testGetBySenderOrderedByAmountDescendingReturnsTheTransactionsInCorrectOrder() {
        List<Transaction> expected = stubTransactions().stream()
                .filter(t -> t.getFrom().equals("from_2"))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
        List<Transaction> actual = createListFromIterable(chainblock.getBySenderOrderedByAmountDescending("from_2"));
        int index = 0;
        for (Transaction transaction : actual) {
            assertEquals(expected.get(index++), transaction);
        }
    }


    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescendingShouldThrowWhenNoTransactionsFromGivenSender() {
        stubTransactions();
        chainblock.getBySenderOrderedByAmountDescending("from_10");
    }

    @Test
    public void testGetByReceiverOrderedByAmountThenByIdReturnsTheCorrectAmountOfTransactions() {
        List<Transaction> expected = stubTransactions().stream()
                .filter(t -> t.getTo().equals("to_3"))
                .collect(Collectors.toList());
        List<Transaction> actual = createListFromIterable(chainblock.getByReceiverOrderedByAmountThenById("to_3"));
        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void testGetByReceiverOrderedByAmountThenByIdReturnsTheTransactionsInCorrectOrder() {
        List<Transaction> expected = stubTransactions().stream()
                .filter(t -> t.getTo().equals("to_2"))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
        List<Transaction> actual = createListFromIterable(chainblock.getByReceiverOrderedByAmountThenById("to_2"));
        int index = 0;
        for (Transaction transaction : actual) {
            assertEquals(expected.get(index++), transaction);
        }
    }


    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverOrderedByAmountThenByIdShouldThrowWhenNoTransactionsFromGivenReceiver() {
        stubTransactions();
        chainblock.getByReceiverOrderedByAmountThenById("to_10");
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnTheCorrectAmountOfTransactions() {
        List<Transaction> expected = stubTransactions().stream()
                .filter(t -> t.getStatus() == TransactionStatus.ABORTED && t.getAmount() <= 1200)
                .collect(Collectors.toList());
        List<Transaction> actual = createListFromIterable(
                chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.ABORTED, 1200));
        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnTheTransactionsInCorrectOrder() {
        List<Transaction> expected = stubTransactions().stream()
                .filter(t -> t.getStatus() == TransactionStatus.ABORTED && t.getAmount() <= 1200)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
        List<Transaction> actual = createListFromIterable(
                chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.ABORTED, 1200));
        int index = 0;
        for (Transaction transaction : actual) {
            assertEquals(expected.get(index++), transaction);
        }
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnEmptyCollectionIfNoSuchStatus() {
        stubTransactions();
        List<Transaction> actual = createListFromIterable(
                chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.FAILED, 1200));
        assertEquals(new ArrayList<>(), actual);
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnEmptyCollectionIfNoAmountsLessOrEqualTheGiven() {
        stubTransactions();
        List<Transaction> actual = createListFromIterable(
                chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 220));
        assertEquals(new ArrayList<>(), actual);
    }


    @Test
    public void testGetBySenderAndMinimumAmountDescendingShouldReturnTheCorrectAmountOfTransactions() {
        List<Transaction> expected = stubTransactions().stream()
                .filter(t -> t.getFrom().equals("from_2") && t.getAmount() > 1250)
                .collect(Collectors.toList());
        List<Transaction> actual = createListFromIterable(
                chainblock.getBySenderAndMinimumAmountDescending("from_2", 1250));
        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void testGetBySenderAndMinimumAmountDescendingShouldReturnTheTransactionsInCorrectOrder() {
        List<Transaction> expected = stubTransactions().stream()
                .filter(t -> t.getFrom().equals("from_2") && t.getAmount() > 1000)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
        List<Transaction> actual = createListFromIterable(
                chainblock.getBySenderAndMinimumAmountDescending("from_2", 1000));
        int index = 0;
        for (Transaction transaction : actual) {
            assertEquals(expected.get(index++), transaction);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusAndMaximumAmountShouldThrowIfNoSuchSender() {
        stubTransactions();
        chainblock.getBySenderAndMinimumAmountDescending("from_15", 1500);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnEmptyCollectionIfNoAmountsMoreThanTheGiven() {
        stubTransactions();
        chainblock.getBySenderAndMinimumAmountDescending("from_2", 150000);
    }

    @Test
    public void testGetByReceiverAndAmountRangeShouldReturnTheCorrectAmountOfTransactions() {
        List<Transaction> expected = stubTransactions().stream()
                .filter(t -> t.getTo().equals("to_2") && t.getAmount() >= 800 && t.getAmount() < 1400)
                .collect(Collectors.toList());
        List<Transaction> actual = createListFromIterable(
                chainblock.getByReceiverAndAmountRange("to_2", 800, 1400));
        assertEquals(expected.size(), actual.size());
    }


    @Test
    public void testGetByReceiverAndAmountRangeShouldReturnTheTransactionsInCorrectOrder() {
        List<Transaction> expected = stubTransactions().stream()
                .filter(t -> t.getTo().equals("to_3") && t.getAmount() >= 800 && t.getAmount() < 1400)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
        List<Transaction> actual = createListFromIterable(
                chainblock.getByReceiverAndAmountRange("to_3", 800, 1400));
        int index = 0;
        for (Transaction transaction : actual) {
            assertEquals(expected.get(index++), transaction);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeShouldThrowIfNoSuchSender() {
        stubTransactions();
        chainblock.getByReceiverAndAmountRange("to_15", 1500, 2500);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeShouldReturnEmptyCollectionIfNoAmountsInRange() {
        stubTransactions();
        chainblock.getByReceiverAndAmountRange("to_3", 100, 200);
    }

    @Test
    public void testGetAllInAmountRangeShouldReturnTheCorrectAmountOfTransactions() {
        List<Transaction> expected = stubTransactions().stream()
                .filter(t -> t.getAmount() >= 1200 && t.getAmount() <= 1490)
                .collect(Collectors.toList());
        List<Transaction> actual = createListFromIterable(chainblock.getAllInAmountRange(1200, 1490));
        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void testGetAllInAmountRangeShouldReturnTheTransactionsInCorrectOrder() {
        List<Transaction> expected = stubTransactions().stream()
                .filter(t -> t.getAmount() >= 1200 && t.getAmount() <= 1490)
                .collect(Collectors.toList());
        List<Transaction> actual = createListFromIterable(chainblock.getAllInAmountRange(1200, 1490));
        int index = 0;
        for (Transaction transaction : actual) {
            assertEquals(expected.get(index++), transaction);
        }
    }

    @Test
    public void testGetAllInAmountRangeShouldReturnEmptyCollectionIfNoAmountsInRange() {
        List<Transaction> actual = createListFromIterable(chainblock.getAllInAmountRange(100, 200));
        assertEquals(new ArrayList<>(), actual);
    }

    @Test
    public void testIteratorShouldReturnAllTransactions() {
        List<Transaction> transactions = stubTransactions();

        Iterator<Transaction> iterator = chainblock.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            count++;
            iterator.next();
        }
        assertEquals(transactions.size(), count);
    }


    //Helpers:
    private List<Transaction> createListFromIterable(Iterable<Transaction> iterable) {
        assertNotNull(iterable);
        List<Transaction> transactions = new ArrayList<>();
        iterable.forEach(transactions::add);
        return transactions;
    }

    private List<Transaction> stubTransactions() {
        List<Transaction> transactions = Arrays.asList(
                new TransactionImpl(2, TransactionStatus.ABORTED, "from_1", "to_1", 1350.56),
                new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "from_2", "to_3", 1500),
                new TransactionImpl(4, TransactionStatus.ABORTED, "from_2", "to_3", 1220),
                new TransactionImpl(5, TransactionStatus.SUCCESSFUL, "from_4", "to_2", 1350.56),
                new TransactionImpl(6, TransactionStatus.ABORTED, "from_2", "to_5", 782),
                new TransactionImpl(7, TransactionStatus.UNAUTHORIZED, "from_6", "to_2", 12256.43),
                new TransactionImpl(8, TransactionStatus.ABORTED, "from_7", "to_7", 350.56),
        new TransactionImpl(9, TransactionStatus.UNAUTHORIZED, "from_6", "to_2", 12256.43));
        transactions.forEach(t -> chainblock.add(t));
        return transactions;
    }
}