package ru.Y_LAB.bazan.view;

import ru.Y_LAB.bazan.model.User.User;
import ru.Y_LAB.bazan.model.User.UserService;
import ru.Y_LAB.bazan.view.Commands.MainMenu;

import java.util.*;

/**
 * ConsoleUI выполняет интерфейс View и отвечает за взаимодействие с пользователем
 * в консольном приложении, позволяя выполнять операции, такие как регистрация,
 * вход в систему, и другие действия.
 */

public class ConsoleUI implements View {

    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;
    private User currentUser = null;
    private List<String> blockUserList = new ArrayList<String>();
    UserService userService = new UserService();

    /**
     * Конструктор класса ConsoleUI.
     * Инициализирует сканер, флаг работы и главное меню.
     */

    public ConsoleUI() {

        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this, isLoggedIn(), userService.isAdminMode());

    }

    /**
     * Запускает основной цикл приложения, отображает меню и
     * обрабатывает выбор пользователя.
     */

    @Override
    public void start() {
        System.out.println("Hello!");
        while (work) {
            mainMenu = new MainMenu(this, isLoggedIn(), userService.isAdminMode());
            System.out.println(mainMenu.menu());
            System.out.println(userService.isAdminMode());
            String choiceStr = scanner.nextLine();
            if (checkChoice(choiceStr)) {
                int choice = Integer.parseInt(choiceStr);
                mainMenu.execute(choice);
            } else {
                System.out.println("Incorrect input. Please input a figure from 1 till " + mainMenu.size());
            }
        }
    }

    /**
     * Проверяет, является ли введенный выбор действительным номером
     * в пределах доступного меню.
     *
     * @param choiceStr Строка, содержащая выбор пользователя.
     * @return true, если выбор действителен, false в противном случае.
     */

    public boolean checkChoice(String choiceStr) {
        if (choiceStr.matches("[0-9]+")) { // Проверить, что это число
            int choice = Integer.parseInt(choiceStr);
            return choice > 0 && choice <= mainMenu.size();
        } else {
            return false;
        }
    }

    /**
     * Завершает работу приложения.
     */

    public void end() {
        work = false;
    }

    /**
     * Завершает сессию пользователя и отображает прощальное сообщение.
     */

    private void finish() {
        System.out.println("See you soon!");
        work = false;
    }

    /**
     * Проверяет, вошел ли пользователь в систему.
     *
     * @return true, если пользователь вошел в систему, false в противном случае.
     */
    public boolean isLoggedIn() {

        return currentUser != null;
    }


    /**
     * Отображает главное меню.
     * Выводит приветствие для залогиненного пользователя или предлагает войти/зарегистрироваться,
     * если пользователь не залогинен.
     */
    public void showMainMenu() {
        if (currentUser != null && !blockUserList.contains(currentUser.getEmail())) {
            System.out.println("Добро пожаловать, " + currentUser.getName() + "!");

        } else if (blockUserList.contains(currentUser.getEmail())) {
            System.out.println("User, " + currentUser.getEmail() + "Have been blocked!");
        } else {
            System.out.println("Пожалуйста, войдите или зарегистрируйтесь.");
        }
    }

    /**
     * Выводит ответ на экран.
     *
     * @param answer Строка, которая будет выведена в консоль.
     */

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}


