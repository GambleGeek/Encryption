package com.company.cli.menu;

import com.company.cli.menu.util.InputUtil;
import com.company.cli.menu.util.Values;

import java.util.Map;

import static com.company.cli.menu.util.Values.*;

public class MainMenu {

    public MainMenu(){
        new Values();
    }

    public void greet() throws Exception {
        System.out.println("Hello, dear user!" +
                        "\nThe encryption system welcomes you." +
                        "\nIn this program you can encrypt your message and decrypt it.");

        showOptions();
    }

    public void showOptions() throws Exception {
        Map<String, String> action = null;
        System.out.println("1 - encrypt" +
                            "\n2 - decrypt");
        System.out.print(">>> Enter the number of function you need: ");
        int num = new InputUtil().inputInt();
        switch (num){
            case 1:
                action = ENCRYPT;
                break;
            case 2:
                action = DECRYPT;
                break;
        }
        System.out.println();
        System.out.println("1 - symmetric algorithm" +
                "\n2 - asymmetric algorithm");
        System.out.print(">>> Enter the number of algorithm you need: ");
        int num2 = new InputUtil().inputInt();
        switch (num2){
            case 1:
                new SymmetricEncryptionMenu(action).showMenu();
                break;
            case 2:
                new AsymmetricEncryptionMenu(action).showMenu();
                break;
        }
    }
}
