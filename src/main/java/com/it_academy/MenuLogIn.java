package com.it_academy;

import java.math.BigDecimal;
import java.sql.SQLException;

public class MenuLogIn {
    private boolean isException = false;
    int accountId;
    boolean isExistAccountId;
    DatabaseQuery databaseQuery = new DatabaseQuery();

    protected void chooseMenuLogInItem(int menuLogInItem, int userId) {
        switch (menuLogInItem) {
            case 1:
                Account account = InputReader.inputAccount(userId);
                try {
                    databaseQuery.addAccount(account);
                } catch (SQLException e) {
                    isException = true;
                    System.out.println(e.getMessage());
                }

                if (!isException) {
                    System.out.println();
                    System.out.println("Account was added successfully.");
                }

                Navigation.goToMenuLogIn(userId);
                break;

            case 2:
                accountId = InputReader.getId("your account id");
                try {
                    isExistAccountId = databaseQuery.isAccountIdExists(userId, accountId);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

                if (isExistAccountId) {
                    BigDecimal amount;
                    amount = InputReader.getMoney();
                    Transaction transaction = InputReader.setTransaction(accountId, amount);

                    try {
                        databaseQuery.addTransaction(transaction);
                    } catch (SQLException e) {
                        isException = true;
                        System.out.println(e.getMessage());
                    }

                    if (!isException) {
                        System.out.println();
                        System.out.println("Transaction was made successfully.");
                        Navigation.goToMenuLogIn(userId);
                    }
                }
                //Navigation.goToMenuLogIn(userId);
                else {
                    System.out.println("Inputted account id didn't register. Incorrect account id.");
                    Navigation.goToMenuLogIn(userId);
                }


                Navigation.goToMenuLogIn(userId);
                break;


            case 3:
                accountId = InputReader.getId("your account id");
                try {
                    isExistAccountId = databaseQuery.isAccountIdExists(userId, accountId);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

                if (isExistAccountId) {
                    BigDecimal amount;
                    amount = InputReader.getMoney();
                    Transaction transaction = InputReader.setTransaction(accountId, amount.multiply(BigDecimal.valueOf(-1)));

                    try {
                        databaseQuery.addTransaction(transaction);
                    } catch (SQLException e) {
                        isException = true;
                        System.out.println(e.getMessage());
                    }

                    if (!isException) {
                        System.out.println();
                        System.out.println("Transaction was made successfully.");
                        Navigation.goToMenuLogIn(userId);
                    }
                }
                //Navigation.goToMenuLogIn(userId);
                else {
                    System.out.println("Inputted account id didn't register. Incorrect account id.");
                    Navigation.goToMenuLogIn(userId);
                }


                Navigation.goToMenuLogIn(userId);

                break;

            case 4:
                Navigation.goToMainMenu();
                break;
        }


    }
}
