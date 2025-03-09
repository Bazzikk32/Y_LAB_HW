package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

public class DeleteAccountByAdmin extends Commands {

    public DeleteAccountByAdmin(ConsoleUI consoleUI) {
        super(consoleUI, "Delete Account");
    }
    @Override
    void execute() {
        getConsoleUI().deleteAccountByAdmin();
    }
}
