package com.it_academy;

public class Navigation {
    public static void goToMainMenu() {
        System.out.println();
        InformationPrinting.printMainMenu();
        System.out.println();
        int mainMenuItem = InputReader.getMainMenuItem();
        MainMenu mainMenu = new MainMenu();
        mainMenu.chooseMainMenuItem(mainMenuItem);
    }

    public static void goToMenuLogIn(int userId) {
        System.out.println();
        InformationPrinting.printMenuLogIn();
        System.out.println();
        int menuLogInItem = InputReader.getMenuLogInItem();
        MenuLogIn menuLogIn = new MenuLogIn();
        menuLogIn.chooseMenuLogInItem(menuLogInItem, userId);
    }
}
