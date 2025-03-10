package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

/**
 * Команда для разблокировки аккаунта администратором.
 *
 * Этот класс наследуется от класса {@link Commands} и переопределяет метод
 * {@link #execute()}, чтобы выполнить логику разблокировки аккаунта
 * с помощью экземпляра {@link ConsoleUI}.
 */
public class UnblockAccountByAdmin extends Commands {

    /**
     * Конструктор для создания команды разблокировки аккаунта администратором.
     *
     * @param consoleUI экземпляр {@link ConsoleUI} для взаимодействия с пользовательским интерфейсом
     */
    public UnblockAccountByAdmin(ConsoleUI consoleUI) {
        super(consoleUI, "Unblock Account");
    }

    /**
     * Выполняет команду разблокировки аккаунта администратором.
     *
     * Этот метод вызывает соответствующий метод
     * {@link ConsoleUI#unblockAccountByAdmin()} для выполнения разблокировки.
     */
    @Override
    void execute() {
        getConsoleUI().unblockAccountByAdmin();
    }
}
