package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

public class ShowMainMenu extends Commands {
    public ShowMainMenu(ConsoleUI consoleUI) {
        super(consoleUI, "Show Main Menu");
    }

    @Override
    void execute() {
        getConsoleUI().showMainMenu();
    }
}
