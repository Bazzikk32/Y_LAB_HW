package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

public class AddBudgetLimit extends Commands {
    public AddBudgetLimit(ConsoleUI consoleUI) {
        super(consoleUI, "Add budget limit");
    }

    @Override
    void execute() {
        getConsoleUI().addBudgetLimit();

    }
}
