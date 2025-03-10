package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

/**
 * Команда для отображения всех пользователей в приложении.
 *
 * Этот класс наследует базовый класс Commands и предоставляет реализацию
 * для показа списка всех пользователей, зарегистрированных в системе.
 */
public class ShowAllUsers extends Commands {

    /**
     * Конструктор класса ShowAllUsers.
     *
     * @param consoleUI экземпляр ConsoleUI, используемый для взаимодействия
     *                  с пользовательским интерфейсом.
     */
    public ShowAllUsers(ConsoleUI consoleUI) {
        super(consoleUI, "Show all users");
    }

    /**
     * Выполняет команду отображения всех пользователей в приложении.
     * Этот метод вызывает метод showAllUsers() у экземпляра ConsoleUI,
     * чтобы отобразить список всех зарегистрированных пользователей.
     */
    @Override
    void execute() {
        getUserService().showAllUsers();
    }
}