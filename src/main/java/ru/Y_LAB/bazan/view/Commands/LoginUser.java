package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

/**
 * Команда для входа пользователя в приложение.
 *
 * Этот класс наследует базовый класс Commands и предоставляет реализацию
 * для аутентификации пользователя в системе.
 */
public class LoginUser extends Commands {

    /**
     * Конструктор класса LoginUser.
     *
     * @param consoleUI экземпляр ConsoleUI, используемый для взаимодействия
     *                  с пользовательским интерфейсом.
     */
    public LoginUser(ConsoleUI consoleUI) {
        super(consoleUI, "LogIn");
    }

    /**
     * Выполняет команду входа пользователя в приложение.
     * Этот метод вызывает метод loginUser() у экземпляра ConsoleUI,
     * чтобы инициировать процесс аутентификации пользователя.
     */
    @Override
    void execute() {
        getConsoleUI().loginUser();
    }
}