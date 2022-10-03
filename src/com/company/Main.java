package com.company;

import com.company.encryptionService.asymmetric.AlgorithmDes;

public class Main {

    public static void main(String[] args) {
	// write your code here
        AlgorithmDes algorithmDes = new AlgorithmDes();
        try {
            algorithmDes.initKey();

            String encryptedData = algorithmDes.encrypt("Hello, welcome to the encryption world!");
            System.out.println("Encrypted Data : " + encryptedData);

            String decryptedData = algorithmDes.decrypt(encryptedData);
            System.out.println("Decrypted Data : " + decryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
