package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

public class End extends Commands {

    private ConsoleUI consoleUI;

        public End(ConsoleUI consoleUI) {
            super(consoleUI,"Завершить работу");// description устанавливаем тут
        }
    @Override
    void execute() {
        getConsoleUI().end();
    }
}
