package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

/**
 * Команда для возврата в главное меню.
 * Этот класс расширяет базовый класс Commands и отвечает за вызов метода
 * для возвращения пользователя в главное меню в интерфейсе консоли.
 */
public class BackToMainMenu extends Commands {

    /**
     * Конструктор класса BackToMainMenu.
     *
     * @param consoleUI экземпляр ConsoleUI, используемый для взаимодействия
     *                  с пользовательским интерфейсом.
     */
    public BackToMainMenu(ConsoleUI consoleUI) {
        super(consoleUI, "Back to Main Menu");
    }

    /**
     * Выполняет команду возврата в главное меню.
     *
     * Этот метод вызывает метод backToMainMenu() у экземпляра ConsoleUI,
     * обеспечивая возврат пользователя в главное меню.
     */
    @Override
    void execute() {
        getUserService().backToMainMenu();
    }
}
