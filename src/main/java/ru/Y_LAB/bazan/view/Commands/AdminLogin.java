package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

public class AdminLogin extends Commands {

    public AdminLogin(ConsoleUI consoleUI) {
        super(consoleUI, "Login as Admin");
    }
    @Override
    void execute() {
        getConsoleUI().loginAdmin();
    }
}
