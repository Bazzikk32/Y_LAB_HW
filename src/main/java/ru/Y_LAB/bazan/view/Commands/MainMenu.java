package ru.Y_LAB.bazan.view.Commands;

import ru.Y_LAB.bazan.view.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    List<Commands> commandsList;

    public MainMenu(ConsoleUI consoleUI, boolean isLoggedIn, boolean adminMode) {
        commandsList = new ArrayList<>();


        if (!isLoggedIn && adminMode==false) {
            commandsList.add(new RegisterUser(consoleUI));
            commandsList.add(new LoginUser(consoleUI));
            commandsList.add(new AdminLogin(consoleUI));

        } else if (adminMode==true) {
            commandsList.add(new ShowAllUsers(consoleUI));
            commandsList.add(new DeleteAccountByAdmin(consoleUI));
        } else {
            //commandsList.add(new AddTransactionCommand(consoleUI));
            //commandsList.add(new ViewTransactionsCommand(consoleUI));
            commandsList.add(new EditProfile(consoleUI));
            commandsList.add(new DeleteAccount(consoleUI));
            //commandsList.add(new ShowStatisticsCommand(consoleUI));
            //commandsList.add(new UpdateTransaction(consoleUI));

            //commandsList.add(new SetBudgetCommand(consoleUI));


        }
        commandsList.add(new End(consoleUI));
    }

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

    public void execute(int choice) {
        if (choice > 0 && choice <= commandsList.size()) {
            Commands commands = commandsList.get(choice - 1);
            commands.execute();
        } else {
            System.out.println("incorrect choice");
        }
    }

    public int size() {
        return commandsList.size();
    }

    public Commands getCommand(int index) {
        return commandsList.get(index);
    }

    public List<Commands> getCommandsList() {
        return commandsList;
    }
}
