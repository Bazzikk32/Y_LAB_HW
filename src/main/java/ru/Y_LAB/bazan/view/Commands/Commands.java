package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.model.Budget.BudgetService;
import ru.Y_LAB.bazan.model.Transaction.TransactionService;
import ru.Y_LAB.bazan.view.ConsoleUI;

/**
 * Абстрактный класс Commands - объединяет команды основного меню единой бизнес логикой;
 */
public abstract class Commands {
    private ConsoleUI consoleUI;
    private String description;
    private TransactionService transactionService;
    private BudgetService budgetService;

    public Commands(ConsoleUI consoleUI, String description) {
        this.consoleUI = consoleUI;
        this.description = description;
        this.transactionService = new TransactionService();
        this.budgetService = new BudgetService();
    }

    abstract void execute();

    public String getDescription() {
        return description;
    }

    public ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public TransactionService getTransactionService() {
        return transactionService;
    }
    public BudgetService getBudgetService() {
        return budgetService;
    }
}