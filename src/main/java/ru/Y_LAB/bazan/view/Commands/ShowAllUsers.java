package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

public class ShowAllUsers extends Commands {

    public ShowAllUsers(ConsoleUI consoleUI) {
        super(consoleUI, "Show all users");
    }
    @Override
    void execute() {
        getConsoleUI().ShowAllUsers();
    }
}
