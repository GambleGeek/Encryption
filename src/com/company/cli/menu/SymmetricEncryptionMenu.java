package com.company.cli.menu;

import com.company.cli.menu.util.InputUtil;
import com.company.encryptionService.AlgorithmCaesar;
import com.company.encryptionService.KeyGeneration;
import com.company.encryptionService.SymmetricEncryption;

import javax.crypto.SecretKey;
import java.util.Map;

import static com.company.cli.menu.util.Values.*;

public class SymmetricEncryptionMenu extends Menu{

    public SymmetricEncryptionMenu(Map action) {
        super(action);
    }

    @Override
    public void showMenu() throws Exception {
        super.showMenu();
        System.out.println("The algorithms: " +
                "\n1 - Caesar" +
                "\n2 - AES" +
                "\n3 - DES");
        System.out.print(">>> Enter the number of algorithm: ");
        int number = new InputUtil().inputInt();
        switch (number){
            case 1:
                algorithmName = CAESAR;
                break;
            case 2:
                algorithmName = AES;
                break;
            case 3:
                algorithmName = DES;
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
        if(algorithmName.equals(CAESAR)){
            System.out.print(">>> Enter the padding number: ");
            int padding = new InputUtil().inputInt();
            AlgorithmCaesar algorithmCaesar = new AlgorithmCaesar(padding);
            if(action.equals(ENCRYPT)){
                System.out.println(algorithmCaesar.encrypt(data));
            }
            else {
                System.out.println(algorithmCaesar.decrypt(data));
            }
        }
        else{
            SecretKey key = new KeyGeneration(algorithmName).generateKey();
            SymmetricEncryption symmetricEncryption = new SymmetricEncryption(algorithmName, key);
            if (action.equals(ENCRYPT)){
                System.out.println(symmetricEncryption.encrypt(data));
            }
            else {
                System.out.println(symmetricEncryption.decrypt(data));
            }
        }
        showActionMenu();
    }


//    @Override
//    public void decryptFromInput() throws Exception {
//        super.decryptFromInput();
//        String data = new InputUtil().inputString();
//        SecretKey key = new KeyGeneration(algorithmName).generateKey();
//        SymmetricEncryption symmetricEncryption = new SymmetricEncryption(algorithmName, key);
//        symmetricEncryption.decrypt(data);
//    }
//
//    @Override
//    public void encryptFromFile() {
//        super.encryptFromFile();
//    }
//
//    @Override
//    public void decryptFromFile() {
//        super.decryptFromFile();
//    }
}
