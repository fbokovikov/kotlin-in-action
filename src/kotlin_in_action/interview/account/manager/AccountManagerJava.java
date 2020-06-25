package kotlin_in_action.interview.account.manager;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountManagerJava {

    class Account {
        private int id;
        private int amount;

        public int getId() {
            return id;
        }

        public int getAmount() {
            return amount;
        }
    }

    static class NotEnoughMoneyException extends RuntimeException {
        public NotEnoughMoneyException(String message) {
            super(message);
        }
    }

    /**
     * Transfer {@code amount} from {@code from} account to {@code to} account.
     * @param from
     * @param to
     * @param amount
     * @throws NotEnoughMoneyException
     */
    public static void transfer(Account from, Account to, int amount) throws NotEnoughMoneyException{
        List<Account> sortedAccounts = Stream.of(from, to)
                .sorted(Comparator.comparing(Account::getId))
                .collect(Collectors.toList());
        synchronized (sortedAccounts.get(0)) {
            synchronized (sortedAccounts.get(1)) {
                if (from.getAmount() < amount) {
                    throw new NotEnoughMoneyException("Required: " + amount + ", available: " + from.getAmount());
                }
                from.amount -= amount;
                to.amount += amount;
            }
        }
    }
}
