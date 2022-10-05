package com.company;

import com.company.cli.menu.MainMenu;
import com.company.encryptionService.KeyGeneration;

import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws Exception {
        MainMenu mainMenu = new MainMenu();
        mainMenu.greet();
    }
}
