package ru.Y_LAB.bazan.view;

import ru.Y_LAB.bazan.model.User.User;
import ru.Y_LAB.bazan.view.Commands.MainMenu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleUI implements View{

    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;
    private User currentUser = null;
    private static final String ADMIN_LOGIN = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private boolean adminMode = false;
    private final Map<String, User> userMap = new HashMap<>(); // Хранение пользователей (email -> User)



    public ConsoleUI() {

        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this, isLoggedIn(), adminMode);

    }

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

    public void registerUser() {
        System.out.println("Введите email:");
        String email = scanner.nextLine();
        if (userMap.containsKey(email)) {
            System.out.println("Этот email уже зарегистрирован.");
            return;
        }

        System.out.println("Введите пароль:");
        String password = scanner.nextLine();
        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        User newUser = new User(email, password, name);
        userMap.put(email, newUser);
        System.out.println("Регистрация успешна!");
    }

    public void loginUser() {
        System.out.println("Введите email:");
        String email = scanner.nextLine();
        System.out.println("Введите пароль:");
        String password = scanner.nextLine();

        User user = userMap.get(email);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            System.out.println("Вход выполнен, " + currentUser.getName() + "!");
        } else {
            System.out.println("Неверный email или пароль.");
        }
    }

    public void showAllUsers() {
        System.out.println(userMap.keySet());
    }


    public boolean isLoggedIn() {

        return currentUser != null;
    }

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
            System.out.println("Пожалуйста, войдите в систему, чтобы редактировать профиль.");
            return;
        }

        System.out.println("Введите новое имя (или оставьте пустым, чтобы не менять):");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            currentUser.setName(newName);
        }

        System.out.println("Введите новый email (или оставьте пустым, чтобы не менять):");
        String newEmail = scanner.nextLine();
        if (!newEmail.isEmpty()) {
            if (userMap.containsKey(newEmail)) {
                System.out.println("Этот email уже зарегистрирован.");
                return;
            }
            userMap.remove(currentUser.getEmail());
            currentUser.setEmail(newEmail);
            userMap.put(newEmail, currentUser);
        }

        System.out.println("Введите новый пароль (или оставьте пустым, чтобы не менять):");
        String newPassword = scanner.nextLine();
        if (!newPassword.isEmpty()) {
            currentUser.setPassword(newPassword);
        }

        System.out.println("Профиль обновлен!");
    }

    /**
     * Позволяет пользователю удалить свой аккаунт.
     * Запрашивает подтверждение удаления аккаунта. Если пользователь подтверждает удаление,
     * то аккаунт удаляется из хранилища `users`, а текущий пользователь (`currentUser`) становится `null`.
     */
    public void deleteAccount() {
        if (currentUser == null) {
            System.out.println("Пожалуйста, войдите в систему, чтобы удалить аккаунт.");
            return;
        }

        System.out.println("Вы уверены, что хотите удалить аккаунт? (да/нет)");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("да")) {
            userMap.remove(currentUser.getEmail());
            currentUser = null;
            System.out.println("Аккаунт удален.");
        } else {
            System.out.println("Удаление отменено.");
        }
    }

    /**
     * Позволяет пользователю удалить свой аккаунт.
     * Запрашивает подтверждение удаления аккаунта. Если пользователь подтверждает удаление,
     * то аккаунт удаляется из хранилища `users`, а текущий пользователь (`currentUser`) становится `null`.
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
        if (currentUser != null) {
            System.out.println("Добро пожаловать, " + currentUser.getName() + "!");

        } else {
            System.out.println("Пожалуйста, войдите или зарегистрируйтесь.");
        }
    }


    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
