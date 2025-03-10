package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

/**
 * Команда для удаления аккаунта администратором.
 *
 * Этот класс наследует базовый класс Commands и предоставляет реализацию
 * для удаления аккаунта пользователем с привилегиями администратора
 * через пользовательский интерфейс консоли.
 */
public class DeleteAccountByAdmin extends Commands {

    /**
     * Конструктор класса DeleteAccountByAdmin.
     *
     * @param consoleUI экземпляр ConsoleUI, используемый для взаимодействия
     *                  с пользовательским интерфейсом.
     */
    public DeleteAccountByAdmin(ConsoleUI consoleUI) {
        super(consoleUI, "Delete Account");
    }

    /**
     * Выполняет команду удаления аккаунта администратором.
     * Этот метод вызывает метод deleteAccountByAdmin() у экземпляра ConsoleUI,
     * чтобы произвести удаление аккаунта под контролем администратора.
     */
    @Override
    void execute() {
        getUserService().deleteAccountByAdmin();
    }
}
