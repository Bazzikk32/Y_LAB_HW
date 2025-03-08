package ru.Y_LAB.bazan.view;

import ru.Y_LAB.bazan.view.Commands.MainMenu;

import java.security.Provider;
import java.util.Scanner;

public class ConsoleUI implements View{

    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;
    private Provider.Service service;
    private Object currentUser;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;

    }

    @Override
    public void start() {
        System.out.println("Hello!");
        while (work) {
            mainMenu = new MainMenu(this, isLoggedIn());
            System.out.println(mainMenu.menu());
            String choiceStr = scanner.nextLine();
            if (checkChoice(choiceStr)) {
                int choice = Integer.parseInt(choiceStr);
                mainMenu.execute(choice);
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите число от 1 до " + mainMenu.size());
            }
        }
    }

    public boolean checkChoice(String choiceStr) {
        if (choiceStr.matches("[0-9]+")) { // Проверить, что это число
            int choice = Integer.parseInt(choiceStr);
            return choice > 0 && choice <= mainMenu.size();
        } else {
            return false;
        }
    }

    public void end() {
        work = false;
    }

    private void finish() {
        System.out.println("До новых встреч!!!");
        work = false;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
