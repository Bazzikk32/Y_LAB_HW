package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class AdminMenu {
    List<Commands> commandsListOfAdmin;

    public AdminMenu(ConsoleUI consoleUI) {
        commandsListOfAdmin = new ArrayList<>();
        commandsListOfAdmin.add(new ShowAllUsers(consoleUI));
        commandsListOfAdmin.add(new End(consoleUI));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Choose action:\n");
        for (int i = 0; i < commandsListOfAdmin.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandsListOfAdmin.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        if (choice > 0 && choice <= commandsListOfAdmin.size()) {
            Commands commands = commandsListOfAdmin.get(choice - 1);
            commands.execute();
        } else {
            System.out.println("incorrect choice");
        }
    }

    public int size() {
        return commandsListOfAdmin.size();
    }

}
