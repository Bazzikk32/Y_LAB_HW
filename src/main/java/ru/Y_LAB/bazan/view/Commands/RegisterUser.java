package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

public class RegisterUser extends Commands {
    public RegisterUser(ConsoleUI consoleUI) {
        super(consoleUI, "Register User");
    }

    @Override
    void execute() {
        getConsoleUI().registerUser();
    }
}
