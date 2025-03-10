package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

/**
 * Команда для регистрации нового пользователя в приложении.
 *
 * Этот класс наследует базовый класс Commands и предоставляет реализацию
 * для регистрации нового пользователя в системе.
 */
public class RegisterUser extends Commands {

    /**
     * Конструктор класса RegisterUser.
     *
     * @param consoleUI экземпляр ConsoleUI, используемый для взаимодействия
     *                  с пользовательским интерфейсом.
     */
    public RegisterUser(ConsoleUI consoleUI) {
        super(consoleUI, "Register User");
    }

    /**
     * Выполняет команду регистрации нового пользователя в приложении.
     * Этот метод вызывает метод registerUser() у экземпляра ConsoleUI,
     * чтобы инициировать процесс регистрации пользователя.
     */
    @Override
    void execute() {
        getUserService().registerUser();
    }
}