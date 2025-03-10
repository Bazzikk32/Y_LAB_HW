package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

/**
 * Команда для удаления аккаунта.
 *
 * Этот класс наследует базовый класс Commands и предоставляет реализацию
 * для удаления аккаунта через пользовательский интерфейс консоли.
 */
public class DeleteAccount extends Commands {

    /**
     * Конструктор класса DeleteAccount.
     *
     * @param consoleUI экземпляр ConsoleUI, используемый для взаимодействия
     *                  с пользовательским интерфейсом.
     */
    public DeleteAccount(ConsoleUI consoleUI) {
        super(consoleUI, "Delete Account");
    }

    /**
     * Выполняет команду удаления аккаунта.
     * Этот метод вызывает метод deleteAccount() у экземпляра ConsoleUI,
     * чтобы произвести удаление аккаунта.
     */
    @Override
    void execute() {
        getUserService().deleteAccount();
    }
}
