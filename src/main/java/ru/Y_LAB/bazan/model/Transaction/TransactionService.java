package ru.Y_LAB.bazan.model.Transaction;

import ru.Y_LAB.bazan.model.User.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Класс `TransactionService` предоставляет методы для управления списком транзакций.
 * Включает функциональность добавления новых транзакций для определенного пользователя.
 */
public class TransactionService {
    /**
     * Список для хранения транзакций.
     */
    private List<Transaction> transactions = new ArrayList<>();

    /**
     * Сканер для чтения ввода пользователя с консоли.
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * Возвращает список всех транзакций.
     *
     * @return Список транзакций.
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * Добавляет новую транзакцию в список транзакций для указанного пользователя.
     * Запрашивает у пользователя сумму, категорию, дату и описание транзакции.
     *
     * @param user Пользователь, которому принадлежит транзакция.
     */



    public void addTransaction(User user) {
        System.out.println("Insert a new transaction:");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Incorrect amount");
            return;
        }

        System.out.println("Input of category (INCOME, FOOD, TRANSPORT, ENTERTAINMENT, OTHER):");
        Category category;
        try {
            category = Category.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect category.");
            return;
        }

        System.out.println("Input date of transaction (YYYY-MM-DD):");
        LocalDate date;
        try {
            date = LocalDate.parse(scanner.nextLine());
        } catch (java.time.format.DateTimeParseException e) {
            System.out.println("Incorrect date format.");
            return;
        }

        System.out.println("Add transaction description:");
        String description = scanner.nextLine();

        Transaction newTransaction = new Transaction(user.getEmail(), amount, description, category, date);
        transactions.add(newTransaction);
        System.out.println("Transaction added!");
    }

    /**
     * Обновляет существующую транзакцию в списке транзакций.
     * Запрашивает у пользователя ID транзакции, а затем новые значения
     * для суммы, категории, даты и описания.
     *
     * @param user Пользователь, которому принадлежит транзакция.
     */
    public void updateTransaction(User user) {
        System.out.println("Input ID of the transaction:");
        int id = Integer.parseInt(scanner.nextLine());
        for (Transaction transaction : transactions) {
            if (transaction.getId() == id) {
                System.out.println("Input amount of the transaction:");
                double amount;
                try {
                    amount = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect format of amount");
                    return;
                }
                System.out.println("Input new category (INCOME, FOOD, TRANSPORT, ENTERTAINMENT, OTHER) :");
                Category category;
                try {
                    category = Category.valueOf(scanner.nextLine().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Incorrect format of category.");
                    return;
                }
                System.out.println("Input new date (YYYY-MM-DD):");
                LocalDate date;
                try {
                    date = LocalDate.parse(scanner.nextLine());
                } catch (java.time.format.DateTimeParseException e) {
                    System.out.println("Incorrect date.");
                    return;
                }

                System.out.println("Please input new description:");
                String description = scanner.nextLine();
                Transaction newTransaction = new Transaction(user.getEmail(), amount, description, category, date);
                transactions.set(id - 1, newTransaction);
            }
        }
    }
    /**
     * Удаляет транзакцию из списка по указанному номеру.
     */
    public void deleteTransaction() {
        System.out.println("Please input transaction id for deletion:");
        int id = Integer.parseInt(scanner.nextLine());
        for (Transaction transaction : transactions) {
            if (transaction.getId() == id) {
                transactions.remove(transaction);
                return;
            }
        }
    }
    /**
     * Выводит список транзакций для указанного пользователя.
     *
     * @param currentUser Пользователь, транзакции которого нужно отобразить.
     */
    public void viewTransactions(User currentUser) {
        if (transactions.isEmpty()) {
            System.out.println("No existing transactions");
            return;
        }

        System.out.printf("%-10s %-10s %-15s %-10s %s%n", "ID", "Amount", "Category", "Date", "Description");
        System.out.println("-------------------------------------------------------");

        for (Transaction transaction : transactions) {
            if (transaction.getUserEmail().equals(currentUser.getEmail())) {
                System.out.printf("%-10d %-10.2f %-15s %-10s %s%n",
                        transaction.getId(),
                        transaction.getAmount(),
                        transaction.getCategory(),
                        transaction.getDate(),
                        transaction.getDescription());
            }
        }
    }


}
