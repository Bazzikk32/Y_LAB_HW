package ru.Y_LAB.bazan;

import ru.Y_LAB.bazan.view.ConsoleUI;
import ru.Y_LAB.bazan.view.View;

public class Main {
    public static void main(String[] args) {
        View view=new ConsoleUI();
        view.start();
    }
}
