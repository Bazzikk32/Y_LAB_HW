package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

public class BackToMainMenu extends Commands {
    public BackToMainMenu(ConsoleUI consoleUI) {
        super(consoleUI, "Back to Main Menu");
    }

    @Override
    void execute() {
        getConsoleUI().backToMainMenu();
    }
}
