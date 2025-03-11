package ru.Y_LAB.bazan.model.Budget;

public class Budget {

    int month;
    String description;
    double budgetLimit;
    private String userEmail;


    public Budget(double budgetLimit, String description, int month, String userEmail) {
        this.budgetLimit = budgetLimit;
        this.description = description;
        this.month = month;
        this.userEmail = userEmail;

    }
}
