package com.it_academy;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputReader {

    public static int getMainMenuItem() {
        Scanner scanner = new Scanner(System.in);
        int menuItem;

        while (true) {
            System.out.println("Input menu item: ");
            String inputtedLine = scanner.nextLine();

            if (!inputtedLine.equals("1") && !inputtedLine.equals("2") && !inputtedLine.equals("3")) {
                System.out.println("Incorrect menu item. Try again.");
            } else {
                try {
                    menuItem = Integer.parseInt(inputtedLine);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Input Error. Try again.");
                }
            }
        }
        return menuItem;
    }

    public static int getMenuLogInItem() {
        Scanner scanner = new Scanner(System.in);
        int menuItem;

        while (true) {
            System.out.println("Input menu item: ");
            String inputtedLine = scanner.nextLine();

            if (!inputtedLine.equals("1") && !inputtedLine.equals("2") && !inputtedLine.equals("3") &&
                    !inputtedLine.equals("4")) {
                System.out.println("Incorrect menu item. Try again.");
            } else {
                try {
                    menuItem = Integer.parseInt(inputtedLine);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Input Error. Try again.");
                }
            }
        }
        return menuItem;
    }

    public static int getId(String kindOfId) {
        Scanner scanner = new Scanner(System.in);
        int number;

        while (true) {
            System.out.println("Input your " + kindOfId + " or \"exit\" for close application:");
            String inputtedLine = scanner.nextLine();
            if (inputtedLine.equals("exit")) {
                System.exit(0);
            } else {
                try {
                    number = Integer.parseInt(inputtedLine);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect id format. Try again.");
                }
            }
        }
        return number;
    }

    public static BigDecimal getMoney() {
        Scanner scanner = new Scanner(System.in);
        BigDecimal money;

        while (true) {
            System.out.println("Input amount or \"exit\" for close application:");
            String inputtedLine = scanner.nextLine();
            if (inputtedLine.equals("exit")) {
                System.exit(0);
            } else {
                try {
                    money = new BigDecimal(inputtedLine);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect id format. Try again.");
                }
            }
        }
        return money;
    }

    public static User inputUser() {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Input your name: ");
                user.setName(scanner.nextLine());
                System.out.println("Input your address: ");
                user.setAddress(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid data. Try again");
            }
        }
        return user;
    }

    public static Account inputAccount(int userId) {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                account.setUserId(userId);
                account.setBalance(BigDecimal.valueOf(0));
                System.out.println("Input currency: ");
                account.setCurrency(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid data. Try again");
            }
        }
        return account;
    }

    public static Transaction setTransaction(int accountId, BigDecimal amount) {
        Transaction transaction = new Transaction();
        while (true) {
            try {
                transaction.setAccountId(accountId);
                transaction.setAmount(amount);
                break;
            } catch (Exception e) {
                System.out.println("Invalid data. Try again");
            }
        }
        return transaction;
    }
}
