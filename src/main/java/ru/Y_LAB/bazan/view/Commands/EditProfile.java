package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

/**
 * Команда для редактирования профиля пользователя.
 *
 * Этот класс наследует базовый класс Commands и предоставляет реализацию
 * для изменения данных профиля текущего пользователя через пользовательский интерфейс консоли.
 */
public class EditProfile extends Commands {

    /**
     * Конструктор класса EditProfile.
     *
     * @param consoleUI экземпляр ConsoleUI, используемый для взаимодействия
     *                  с пользовательским интерфейсом.
     */
    public EditProfile(ConsoleUI consoleUI) {
        super(consoleUI, "Edit Profile");
    }

    /**
     * Выполняет команду редактирования профиля пользователя.
     * Этот метод вызывает метод editProfile() у экземпляра ConsoleUI,
     * чтобы произвести изменение данных профиля текущего пользователя.
     */
    @Override
    void execute() {
        getUserService().editProfile();
    }
}
