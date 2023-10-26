package org.example;

public class main {

    public interface Account {
        double getAmount();

        void put(double amount);

        void take(double amount);
    }

    public abstract static class AbstractAccount implements Account {
        protected double balance;

        public AbstractAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public double getAmount() {
            return balance;
        }

        public void put(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        public final void take(double amount) {
            if (amount >= 0) {
                doTake(amount);
            } else {
                throw new IllegalArgumentException("Сумма снятия должна быть положительной");
            }
        }

        protected abstract void doTake(double amount);
    }

    public static class FixedAmountAccount extends AbstractAccount {
        public FixedAmountAccount(double initialBalance) {
            super(initialBalance);
        }

        protected void doTake(double amount) {
            // Ничего не делаем, баланс не изменяется
        }
    }

    public static class Homework {
        public void main (String[] args) {
            Account account = new FixedAmountAccount(1000);
            System.out.println("Текущий баланс: " + account.getAmount());
            account.put(500);
            System.out.println("Текущий баланс после пополнения: " + account.getAmount());
            account.take(200);
            System.out.println("Текущий баланс после снятия: " + account.getAmount());
        }
    }
}