package com.it_academy;

import java.sql.SQLException;

public class MainMenu {
    private boolean isException = false;
    int userId;
    boolean isExistUserId;
    DatabaseQuery databaseQuery = new DatabaseQuery();

    protected void chooseMainMenuItem(int mainMenuItem) {
        switch (mainMenuItem) {
            case 1:
                userId = InputReader.getId("your id");
                try {
                    isExistUserId = databaseQuery.isUserIdExists(userId);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

                if (isExistUserId)
                    Navigation.goToMenuLogIn(userId);
                else {
                    System.out.println("Inputted id didn't register. You need Register.");
                    Navigation.goToMainMenu();
                }
                break;

            case 2:
                User user = InputReader.inputUser();

                try {
                    databaseQuery.addUser(user);
                } catch (SQLException e) {
                    isException = true;
                    System.out.println(e.getMessage());
                }

                if (!isException) {
                    System.out.println();
                    System.out.println("Registration is successful.");
                    try {
                        userId = databaseQuery.getLastUserId();
                    } catch (SQLException e) {
                        isException = true;
                        System.out.println(e.getMessage());
                    }
                }

                if (!isException) {
                    System.out.println("Your id is " + userId + ".");
                    System.out.println("Remember your id for log in this application.");
                    System.out.println();
                }
                Navigation.goToMainMenu();
                break;

            case 3:
                System.exit(0);
                break;
        }
    }
}
