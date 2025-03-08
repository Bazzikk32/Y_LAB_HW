package ru.Y_LAB.bazan.model.Transaction;

import java.time.LocalDate;

public class Transaction {
    private static int nextId = 1;
    private int id;
    private String userEmail;
    private double amount;
    private String description;
    private ListOfExpenses expenses;
    private LocalDate date;
}
