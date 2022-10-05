package com.company.cli.menu;

import com.company.cli.menu.util.InputUtil;

import java.util.Map;

public abstract class Menu {

    protected String algorithmName;
    protected Map action;

    public Menu(Map action) {
        this.action = action;
    }

    public void showMenu() throws Exception {
        System.out.println("======================");
        System.out.println(action.get("noun") + " Menu");
    }

    public void showActionMenu() throws Exception {
        System.out.println("======================");
        System.out.printf("How do you want to %s your data with %s algorithm?" +
                "\n1 - from input" +
                "\n2 - from file\n", action.get("verb"), algorithmName);
        System.out.print(">>> Enter the number of way you need: ");
        int num = new InputUtil().inputInt();
        switch (num){
            case 1:
                doActionFromInput();
                break;
            case 2:
                doActionFromFile();
                break;
        }
//        if (num==1 && action.equals(ENCRYPT)) doActionFromInput();
//        else if (num==1 && action.equals(DECRYPT)) decryptFromInput();
//        else if(num==2 && action.equals(ENCRYPT)) encryptFromFile();
//        else if(num==2 && action.equals(DECRYPT)) decryptFromFile();
//        else System.out.println("No such option");
    }

    public void doActionFromInput() throws Exception {
        System.out.println("======================");
        System.out.printf("%s with %s from input\n", action.get("noun"), algorithmName);
        System.out.printf("Input the data you want to %s: ", action.get("verb"));
    }

    public void doActionFromFile(){
        System.out.println("In process ...");
    }

//    public void decryptFromInput() throws Exception {
//        System.out.println("======================");
//        System.out.printf("Decryption with %s from input\n", algorithmName);
//        System.out.println("Input the data you want to decrypt: ");
//    }
//
//    public void encryptFromFile(){
//        System.out.println("======================");
//        System.out.printf("Encryption with %s from file\n", algorithmName);
//    }
//
//    public void decryptFromFile(){
//        System.out.println("======================");
//        System.out.printf("Decryption with %s from file\n", algorithmName);
//    }
}
