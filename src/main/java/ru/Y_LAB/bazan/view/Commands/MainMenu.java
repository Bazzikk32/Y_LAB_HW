package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс MainMenu представляет главное меню приложения.
 * В зависимости от состояния пользователя (вошел в систему или нет, админ или нет)
 * формирует список доступных команд.
 */
public class MainMenu {
    List<Commands> commandsList;

    /**
     * Конструктор класса MainMenu.
     * Инициализирует список команд в зависимости от статуса входа пользователя
     * и режима администратора.
     *
     * @param consoleUI Объект для взаимодействия с консолью.
     * @param isLoggedIn Флаг, указывающий, вошел ли пользователь в систему.
     * @param adminMode Флаг, указывающий, находится ли пользователь в административном режиме.
     */
    public MainMenu(ConsoleUI consoleUI, boolean isLoggedIn, boolean adminMode) {
        commandsList = new ArrayList<>();

        if (!isLoggedIn && adminMode == false) {
            commandsList.add(new RegisterUser(consoleUI));
            commandsList.add(new LoginUser(consoleUI));
            commandsList.add(new AdminLogin(consoleUI));
        } else if (adminMode == true) {
            commandsList.add(new ShowAllUsers(consoleUI));
            commandsList.add(new DeleteAccountByAdmin(consoleUI));
            commandsList.add(new BlockAccountByAdmin(consoleUI));
            commandsList.add(new UnblockAccountByAdmin(consoleUI));
            commandsList.add(new BackToMainMenu(consoleUI));
        } else {
            commandsList.add(new EditProfile(consoleUI));
            commandsList.add(new DeleteAccount(consoleUI));
            commandsList.add(new ShowMainMenu(consoleUI));
            commandsList.add(new AddTransaction(consoleUI));
            commandsList.add(new ViewTransaction(consoleUI));

        }
        commandsList.add(new End(consoleUI));
    }

    /**
     * Формирует строку с доступными действиями для выбора.
     *
     * @return Строка с перечислением доступных команд.
     */
    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Choose action:\n");
        for (int i = 0; i < commandsList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandsList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    /**
     * Выполняет команду на основе выбранного пользователем действия.
     *
     * @param choice Индекс команды, которую нужно выполнить.
     */
    public void execute(int choice) {
        if (choice > 0 && choice <= commandsList.size()) {
            Commands commands = commandsList.get(choice - 1);
            commands.execute();
        } else {
            System.out.println("incorrect choice");
        }
    }

    /**
     * Возвращает количество команд в меню.
     *
     * @return Количество доступных команд.
     */
    public int size() {
        return commandsList.size();
    }

    /**
     * Получает команду по индексу.
     *
     * @param index Индекс команды в списке.
     * @return Команда, соответствующая указанному индексу.
     */
    public Commands getCommand(int index) {
        return commandsList.get(index);
    }

    /**
     * Возвращает список команд в меню.
     *
     * @return Список доступных команд.
     */
    public List<Commands> getCommandsList() {
        return commandsList;
    }
}