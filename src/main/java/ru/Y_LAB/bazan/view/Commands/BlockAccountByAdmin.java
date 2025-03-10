package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

/**
 * Команда для блокировки аккаунта администратором.
 * Этот класс расширяет базовый класс Commands и отвечает за вызов метода
 * блокировки аккаунта в интерфейсе консоли по запросу администратора.
 */
public class BlockAccountByAdmin extends Commands {

    /**
     * Конструктор класса BlockAccountByAdmin.
     *
     * @param consoleUI экземпляр ConsoleUI, используемый для взаимодействия
     *                  с пользовательским интерфейсом.
     */
    public BlockAccountByAdmin(ConsoleUI consoleUI) {
        super(consoleUI, "Block Account");
    }

    /**
     * Выполняет команду блокировки аккаунта администратором.
     *
     * Этот метод вызывает метод blockAccountByAdmin() у экземпляра ConsoleUI,
     * обеспечивая выполнение блокации аккаунта.
     */
    @Override
    void execute() {
        getUserService().blockAccountByAdmin();
    }
}

