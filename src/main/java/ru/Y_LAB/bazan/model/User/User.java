package ru.Y_LAB.bazan.model.User;

/**
 * Класс описывающий сущность Пользователь;
 */
public class User {
    /**
     * Переменные класса User;
     */
    private String name;
    private String email;
    private String password;


    /**
     * Конструктор класса User
     * @param name - имя пользователя;
     * @param password - пароль пользователя;
     * @param email - email пользователя;
     */
    public User(String name, String password, String email) {
        this.name = name;
        this.email = email;
        this.password = password;

    }

    /**
     * Геттеры и сеттеры для приватных переменных;
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
