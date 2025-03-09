package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

public class BlockAccountByAdmin extends Commands {

    public BlockAccountByAdmin(ConsoleUI consoleUI) {
        super(consoleUI, "Block Account");
    }
    @Override
    void execute() {
        getConsoleUI().blockAccountByAdmin();
    }
}
