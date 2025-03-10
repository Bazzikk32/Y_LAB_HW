package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

public class DeleteTransaction extends Commands {
    public DeleteTransaction(ConsoleUI consoleUI) {
        super(consoleUI, "Add Transaction");
    }

    @Override
    void execute() {
        getConsoleUI().deleteTransaction();

    }
}
