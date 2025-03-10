package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

public class ViewTransaction extends Commands {

    public ViewTransaction(ConsoleUI consoleUI) {
        super(consoleUI, "Show Transaction");
    }
    @Override
    void execute() {
        getConsoleUI().viewTransactions();
    }
}
