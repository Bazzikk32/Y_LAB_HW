package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

/**
 * Абстрактный класс Commands - объединяет команды основного меню единой бизнес логикой;
 */
public abstract class Commands {
    private ConsoleUI consoleUI;
    private String description;

    public Commands(ConsoleUI consoleUI, String description) {
        this.consoleUI = consoleUI;
        this.description = description;
    }

    abstract void execute();

    public String getDescription() {
        return description;
    }

    public ConsoleUI getConsoleUI() {
        return consoleUI;
    }
}