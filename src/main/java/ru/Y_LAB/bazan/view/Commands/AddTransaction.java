package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

public class AddTransaction extends Commands {
    public AddTransaction(ConsoleUI consoleUI) {
        super(consoleUI, "Add Transaction");
    }

    @Override
    void execute() {
        getConsoleUI().addTransaction();

    }
}
