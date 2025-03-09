package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

/**
 * Команда для завершения работы приложения.
 *
 * Этот класс наследует базовый класс Commands и предоставляет реализацию
 * для завершения сеанса работы пользователя с приложением.
 */
public class End extends Commands {

    private ConsoleUI consoleUI;

    /**
     * Конструктор класса End.
     *
     * @param consoleUI экземпляр ConsoleUI, используемый для взаимодействия
     *                  с пользовательским интерфейсом.
     */
    public End(ConsoleUI consoleUI) {
        super(consoleUI,"Finish");
    }

    /**
     * Выполняет команду завершения работы приложения.
     * Этот метод вызывает метод end() у экземпляра ConsoleUI,
     * чтобы завершить текущий сеанс работы приложения.
     */
    @Override
    void execute() {
        getConsoleUI().end();
    }
}