package com.company.cli.menu;

import com.company.cli.menu.util.InputUtil;
import com.company.encryptionService.AsymmetricEncryption;
import com.company.encryptionService.KeyGeneration;

import java.security.KeyPair;
import java.util.Map;

import static com.company.cli.menu.util.Values.*;

public class AsymmetricEncryptionMenu extends Menu {

    public AsymmetricEncryptionMenu(Map action) {
        super(action);
    }

    @Override
    public void showMenu() throws Exception {
        super.showMenu();
        System.out.println("The algorithms: " +
                "\n1 - RSA");
        System.out.print(">>> Enter the number of algorithm: ");
        int number = new InputUtil().inputInt();
        switch (number){
            case 1:
                algorithmName = RSA;
                break;
            default:
                break;
        }
        showActionMenu();
    }

    @Override
    public void doActionFromInput() throws Exception {
        super.doActionFromInput();
        String data = new InputUtil().inputString();
        KeyPair key = new KeyGeneration(algorithmName).generateKeyPair();
        AsymmetricEncryption asymmetricEncryption = new AsymmetricEncryption(algorithmName, key);
        if (action.equals(ENCRYPT)){
            System.out.println(asymmetricEncryption.encrypt(data));
        }
        else {
            System.out.println(asymmetricEncryption.decrypt(data));
        }
        showActionMenu();
    }
}
