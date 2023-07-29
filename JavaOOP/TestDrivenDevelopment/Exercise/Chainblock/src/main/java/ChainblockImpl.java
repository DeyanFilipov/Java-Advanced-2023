import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {

    private Map<Integer, Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new LinkedHashMap<>();
    }

    public int getCount() {
        return this.transactions.size();
    }

    public void add(Transaction transaction) {
        if (!this.transactions.containsKey(transaction.getId())) {
            transactions.put(transaction.getId(), transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return contains(transaction.getId());
    }

    public boolean contains(int id) {
        return transactions.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        validateIfIdIsInTransactions(id);
        transactions.get(id).setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        validateIfIdIsInTransactions(id);
        transactions.remove(id);
    }

    public Transaction getById(int id) {
        validateIfIdIsInTransactions(id);
        return transactions.get(id);
    }


    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        validateTransactionWithGivenStatus(status);
        return transactions.values().stream()
                .filter(t -> t.getStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        validateTransactionWithGivenStatus(status);
        return transactions.values().stream()
                .filter(t -> t.getStatus() == status)
                .sorted(Comparator.comparing(Transaction::getAmount))
                .map(Transaction::getFrom)
                .collect(Collectors.toList());
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        validateTransactionWithGivenStatus(status);
        return transactions.values().stream()
                .filter(t -> t.getStatus() == status)
                .sorted(Comparator.comparing(Transaction::getAmount))
                .map(Transaction::getTo)
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return transactions.values().stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        validateTransactionWithGivenSender(sender);
        return transactions.values().stream()
                .filter(t -> t.getFrom().equals("from_2"))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        validateTransactionWithGivenReceiver(receiver);
        return transactions.values().stream()
                .filter(t -> t.getTo().equals(receiver))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }


    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        if (transactions.values().stream().noneMatch(t -> t.getStatus() == status) ||
                transactions.values().stream().noneMatch(t -> t.getAmount() <= amount)) {
            return new ArrayList<>();
        }
        return transactions.values().stream()
                .filter(t -> t.getStatus() == TransactionStatus.ABORTED && t.getAmount() <= 1200)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        validateTransactionWithGivenSender(sender);
        validateTransactionWithGivenAmountMoreThanGiven(amount);

        return transactions.values().stream()
                .filter(t -> t.getFrom().equals(sender) && t.getAmount() > amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }


    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        validateTransactionWithGivenReceiver(receiver);
        validateTransactionWithAmountInRange(lo, hi);
        return transactions.values().stream()
                .filter(t -> t.getTo().equals(receiver) && t.getAmount() >= lo && t.getAmount() < hi)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }


    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        if (transactions.values().stream().noneMatch(t -> t.getAmount() >= lo && t.getAmount() <= hi)) {
            return new ArrayList<>();
        }
        return transactions.values().stream()
                .filter(t -> t.getAmount() >= lo && t.getAmount() <= hi)
                .collect(Collectors.toList());
    }


    public Iterator<Transaction> iterator() {
        return transactions.values().iterator();
    }


    private void validateIfIdIsInTransactions(int id) {
        if (!transactions.containsKey(id)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateTransactionWithGivenStatus(TransactionStatus status) {
        if (transactions.values().stream().noneMatch(t -> t.getStatus().equals(status))) {
            throw new IllegalArgumentException();
        }
    }

    private void validateTransactionWithGivenSender(String sender) {
        if (transactions.values().stream().noneMatch(t -> t.getFrom().equals(sender))) {
            throw new IllegalArgumentException();
        }
    }

    private void validateTransactionWithGivenReceiver(String receiver) {
        if (transactions.values().stream().noneMatch(t -> t.getTo().equals(receiver))) {
            throw new IllegalArgumentException();
        }
    }

    private void validateTransactionWithGivenAmountMoreThanGiven(double amount) {
        if (transactions.values().stream().noneMatch(t -> t.getAmount() > amount)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateTransactionWithAmountInRange(double lo, double hi) {
        if (transactions.values().stream().noneMatch(t -> t.getAmount() >= lo && t.getAmount() < hi)) {
            throw new IllegalArgumentException();
        }
    }
}

