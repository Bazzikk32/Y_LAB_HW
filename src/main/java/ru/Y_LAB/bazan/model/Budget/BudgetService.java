package ru.Y_LAB.bazan.model.Budget;

import ru.Y_LAB.bazan.model.User.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BudgetService {

    List<Budget> budgetServiceList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
//
//    public void setMonthlyBudget(User user) {
//        System.out.println("Please insert Monthly Budget");
//        double budgetLimit;
//        try {
//            budgetLimit = Double.parseDouble(scanner.nextLine());
//        } catch (NumberFormatException e) {
//            System.out.println("Incorrect Monthly Budget");
//            return;
//        }
//
//        System.out.println("Add Monthly target description:");
//        String description = scanner.nextLine();
//
//        System.out.println("Input number of month (1-12): ");
//        int monthNumber = scanner.nextInt();
//
//        if (monthNumber < 1 || monthNumber > 12) {
//            System.out.println("Incorrect data please input since 1 till 12.");
//        } else {
//            Budget budget = new Budget(budgetLimit, description, monthNumber, user.getEmail());
//            budgetServiceList.add(budget);
//            System.out.println("Budget added successfully.");
//        }
//    }
//}

public void setMonthlyBudget(User user) {
    System.out.println("====================================");
    System.out.println("         Установить Бюджет          ");
    System.out.println("====================================");

    System.out.print("Введите ежемесячный бюджет: ");

    double budgetLimit;
    try {
        budgetLimit = Double.parseDouble(scanner.nextLine());
    } catch (NumberFormatException e) {
        System.out.println("❌ Неверный формат ежемесячного бюджета. Пожалуйста, попробуйте снова.");
        return;
    }

    System.out.print("Добавьте описание цели на месяц: ");
    String description = scanner.nextLine();

    System.out.print("Введите номер месяца (1-12): ");
    int monthNumber = scanner.nextInt();

    if (monthNumber < 1 || monthNumber > 12) {
        System.out.println("❌ Неверные данные. Пожалуйста, введите номер месяца от 1 до 12.");
    } else {
        Budget budget = new Budget(budgetLimit, description, monthNumber, user.getEmail());
        budgetServiceList.add(budget);
        System.out.println("✅ Бюджет успешно добавлен.");
        System.out.println("====================================");
        System.out.printf("🤝 Пользователь: %s%n", user.getEmail());
        System.out.printf("💰 Бюджет: %.2f%n", budgetLimit);
        System.out.printf("📝 Описание: %s%n", description);
        System.out.printf("📅 Месяц: %d%n", monthNumber);
        System.out.println("====================================");
    }
}

}
