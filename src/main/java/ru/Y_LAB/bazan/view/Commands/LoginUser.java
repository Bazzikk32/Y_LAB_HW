package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

public class LoginUser extends Commands {
    public LoginUser(ConsoleUI consoleUI) {
        super(consoleUI, "LogIn");
    }

    @Override
    void execute() {
        getConsoleUI().loginUser();
    }
}
