package ru.Y_LAB.bazan.model.User;

import ru.Y_LAB.bazan.view.Commands.MainMenu;
import ru.Y_LAB.bazan.view.ConsoleUI;

import java.util.*;

public class UserService {

    private Scanner scanner;
    private User currentUser = null;
    private static final String ADMIN_LOGIN = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private boolean adminMode;
    private final Map<String, User> userMap = new HashMap<>(); // Хранение пользователей (email -> User)
    private List<String> blockUserList = new ArrayList<String>();


    public UserService() {
        scanner = new Scanner(System.in);
        this.adminMode = false;

    }

    public boolean isAdminMode() {
        return this.adminMode; // Возвращаем текущее состояние adminMode
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

        if (!isEmailValid(email)) {
            System.out.println("Invalid email!");
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
     * Проверяет, является ли заданный email адрес валидным.
     *
     * Метод использует регулярное выражение для проверки формата email.
     * Формат правильного email следующи:
     * - Содержит символы word (`a-z`, `A-Z`, `0-9`, `_`, `-`, `.`) до символа `@`.
     * - Затем следует символ `@`.
     * - Далее должны быть символы word, возможно содержащие `-`.
     * - После этого может следовать один или несколько поддоменов, разделенных `.`.
     * - В конце должен быть домен верхнего уровня, состоящий только из букв и длиной не менее 2 символов.
     *
     * @param email строка, представляющая email адрес, который необходимо проверить.
     * @return true, если email валиден, false в противном случае.
     */

    public static boolean isEmailValid(String email) {
        return email.matches("^[\\w-\\.]+@[\\w-]+(\\.[\\w-]+)*\\.[a-z]{2,}$");
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
