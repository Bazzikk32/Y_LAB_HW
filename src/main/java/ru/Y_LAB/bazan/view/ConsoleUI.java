package ru.Y_LAB.bazan.view;

import ru.Y_LAB.bazan.model.User.User;
import ru.Y_LAB.bazan.view.Commands.MainMenu;

import java.util.*;

/**
 * ConsoleUI выполняет интерфейс View и отвечает за взаимодействие с пользователем
 * в консольном приложении, позволяя выполнять операции, такие как регистрация,
 * вход в систему, и другие действия.
 */

public class ConsoleUI implements View{

    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;
    private User currentUser = null;
    private static final String ADMIN_LOGIN = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private boolean adminMode = false;
    private final Map<String, User> userMap = new HashMap<>(); // Хранение пользователей (email -> User)
    private List<String> blockUserList = new ArrayList<String>();

    /**
     * Конструктор класса ConsoleUI.
     * Инициализирует сканер, флаг работы и главное меню.
     */

    public ConsoleUI() {

        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this, isLoggedIn(), adminMode);

    }

    /**
     * Запускает основной цикл приложения, отображает меню и
     * обрабатывает выбор пользователя.
     */

    @Override
    public void start() {
        System.out.println("Hello!");
        while (work) {
            mainMenu = new MainMenu(this, isLoggedIn(), adminMode);
            System.out.println(mainMenu.menu());
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
     * Регистрация нового пользователя.
     * Запрашивает у пользователя email, пароль и имя.
     */

    public void registerUser() {
        System.out.println("Input an email:");
        String email = scanner.nextLine();
        if (userMap.containsKey(email)) {
            System.out.println("This email already exists!");
            return;
        }

        System.out.println("Input password:");
        String password = scanner.nextLine();
        System.out.println("Input username:");
        String name = scanner.nextLine();

        User newUser = new User(email, password, name);
        userMap.put(email, newUser);
        System.out.println("Registration is complete!");
    }

    /**
     * Вход пользователя в систему.
     * Запрашивает email и пароль, проверяет их корректность.
     */

    public void loginUser() {
        System.out.println("Input an email:");
        String email = scanner.nextLine();
        System.out.println("Input a password:");
        String password = scanner.nextLine();

        User user = userMap.get(email);
        if (user != null && user.getPassword().equals(password) && !blockUserList.contains(email)) {
            currentUser = user;
            System.out.println("Yuo have been login, " + currentUser.getName() + "!");
        } else if (user != null && user.getPassword().equals(password) && blockUserList.contains(email)) {
            System.out.println("Your account, have been blocked!");
        } else
        {
            System.out.println("Incorrect email or password.");
        }
    }

    /**
     * Отображает всех зарегистрированных пользователей.
     */

    public void showAllUsers() {
        System.out.println(userMap.keySet());
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
     * Вход администратора в систему.
     * Запрашивает логин и пароль администратора которые установлены как DEFAULT.
     */

    public void loginAdmin() {

        System.out.println("Input ADMIN login:");
        String loginAdmin = scanner.nextLine();
        System.out.println("Input ADMIN password:");
        String passwordAdmin = scanner.nextLine();

        if (loginAdmin.equals(ADMIN_LOGIN) && passwordAdmin.equals(ADMIN_PASSWORD)) {

            System.out.println("Welcome, ADMIN!");
            adminMode = true;
        } else {
            System.out.println("Incorrect LOGIN or PASSWORD!");
        }
        System.out.println("Привет");
    }

    /**
     * Позволяет пользователю редактировать свой профиль.
     * Запрашивает у пользователя новое имя, email и пароль. Если пользователь вводит значение,
     * то соответствующее поле профиля обновляется. Перед обновлением email проверяется,
     * не занят ли он другим пользователем.
     */
    public void editProfile() {
        if (currentUser == null) {
            System.out.println("Please login first!");
            return;
        }

        System.out.println("Please input new login):");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            currentUser.setName(newName);
        }

        System.out.println("Please input new email:");
        String newEmail = scanner.nextLine();
        if (!newEmail.isEmpty()) {
            if (userMap.containsKey(newEmail)) {
                System.out.println("This email already exists!");
                return;
            }
            userMap.remove(currentUser.getEmail());
            currentUser.setEmail(newEmail);
            userMap.put(newEmail, currentUser);
        }

        System.out.println("Input new password:):");
        String newPassword = scanner.nextLine();
        if (!newPassword.isEmpty()) {
            currentUser.setPassword(newPassword);
        }

        System.out.println("Account have been updated!");
    }

    /**
     * Позволяет пользователю удалить свой аккаунт.
     * Запрашивает подтверждение удаления аккаунта. Если пользователь подтверждает удаление,
     * то аккаунт удаляется из хранилища `users`, а текущий пользователь (`currentUser`) становится `null`.
     */
    public void deleteAccount() {
        if (currentUser == null) {
            System.out.println("Please login first!");
            return;
        }

        System.out.println("Are you sure you want to delete this account? (yes/no");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("yes")) {
            userMap.remove(currentUser.getEmail());
            currentUser = null;
            System.out.println("Account has been deleted!");
        } else {
            System.out.println("Canceled");
        }
    }

    /**
     * Позволяет пользователю удалить аккаунт под администратором.
     * Запрашивает подтверждение удаления аккаунта. Если пользователь подтверждает удаление,
     * то аккаунт удаляется из хранилища.
     */
    public void deleteAccountByAdmin() {
        System.out.println("Input USERname wich would like to DELETE");
        String userNameForDelete = scanner.nextLine();
        if (userMap.containsKey(userNameForDelete)) {
            System.out.println("Are you shure delete an account? (yes/no)");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("yes")) {
                userMap.remove(userNameForDelete);
                System.out.println("Account have been deleted.");
            } else {
                System.out.println("Canceled");
            }
        }


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
    /**
     * Блокирует аккаунт пользователя административным путем.
     * Запрашивает имя пользователя для блока.
     * После подтверждения блокирует аккаунт, добавляя его в список заблокированных
     * пользователей.
     */

    public void blockAccountByAdmin() {
        System.out.println("Input USERname wich would like to BAN");
        String userNameForBan = scanner.nextLine();
        if (userMap.containsKey(userNameForBan)) {
            System.out.println("Are you sure to block an account? (yes/no)");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("yes")) {
                blockUserList.add(userNameForBan);
                System.out.println("Account have been blocked.");
            } else {
                System.out.println("Canceled");
            }
        }
    }
    /**
     * Возвращает состояние администраторского режима на главное меню.
     *
     * @return true, если администраторский режим был выключен.
     */
    public boolean backToMainMenu() {
        return adminMode = false;
    }
}
