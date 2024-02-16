package lesson.lesson8.assignmentabstractandinterface.BankingSystemWithTransaction;

public interface BankAccount {
    void deposit(double amount);

    void withdraw(double amount);

    double getBalance();

    void transfer(BankAccount destination, double amount);

    String getTransactionHistory();
}