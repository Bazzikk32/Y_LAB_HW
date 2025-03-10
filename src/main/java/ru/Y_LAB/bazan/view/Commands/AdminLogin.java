package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

/**
 * Команда для выполнения процесса входа как администратор.
 * Этот класс расширяет базовый класс Commands и отвечает за вызов метода
 * для входа администратора в пользовательский интерфейс консоли.
 */
public class AdminLogin extends Commands {

    /**
     * Конструктор класса AdminLogin.
     *
     * @param consoleUI экземпляр ConsoleUI, который используется для взаимодействия
     *                  с пользовательским интерфейсом.
     */
    public AdminLogin(ConsoleUI consoleUI) {
        super(consoleUI, "Login as Admin");
    }

    /**
     * Выполняет команду входа администратора.
     *
     * Этот метод вызывает метод loginAdmin() у экземпляра ConsoleUI,
     * обеспечивая процесс входа для администратора.
     */
    @Override
    void execute() {
        getConsoleUI().loginAdmin();
    }
}
