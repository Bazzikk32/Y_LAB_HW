package ru.Y_LAB.bazan.model.Service;

import ru.Y_LAB.bazan.model.User.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserService {

    private Scanner sc;
    private User currentUser = null;
    private final Map<String, User> userMap = new HashMap<>(); // Хранение пользователей (email -> User)


    public void registerUser() {
        System.out.println("Введите email:");
        String email = sc.nextLine();
        if (userMap.containsKey(email)) {
            System.out.println("Этот email уже зарегистрирован.");
            return;
        }

        System.out.println("Введите пароль:");
        String password = sc.nextLine();
        System.out.println("Введите имя:");
        String name = sc.nextLine();

        User newUser = new User(email, password, name);
        userMap.put(email, newUser);
        System.out.println("Регистрация успешна!");
    }

    public void loginUser() {
        System.out.println("Введите email:");
        String email = sc.nextLine();
        System.out.println("Введите пароль:");
        String password = sc.nextLine();

        User user = userMap.get(email);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            System.out.println("Вход выполнен, " + currentUser.getName() + "!");
        } else {
            System.out.println("Неверный email или пароль.");
        }
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }
}
