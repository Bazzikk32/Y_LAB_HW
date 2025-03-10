package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

/**
 * Команда для отображения главного меню приложения.
 *
 * Этот класс наследует базовый класс Commands и предоставляет реализацию
 * для показа главного меню пользователю.
 */
public class ShowMainMenu extends Commands {

    /**
     * Конструктор класса ShowMainMenu.
     *
     * @param consoleUI экземпляр ConsoleUI, используемый для взаимодействия
     *                  с пользовательским интерфейсом.
     */
    public ShowMainMenu(ConsoleUI consoleUI) {
        super(consoleUI, "Show Main Menu");
    }

    /**
     * Выполняет команду отображения главного меню приложения.
     * Этот метод вызывает метод showMainMenu() у экземпляра ConsoleUI,
     * чтобы отобразить главное меню пользователю.
     */
    @Override
    void execute() {
        getConsoleUI().showMainMenu();
    }
}