package com.company;

import com.company.encryptionService.asymmetric.AlgorithmRsa;
import com.company.encryptionService.key.KeyGeneration;

import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
	// write your code here
        KeyGeneration keyGeneration = new KeyGeneration();
        AlgorithmRsa algorithmRsa = new AlgorithmRsa(keyGeneration.generateKeyPair());
        System.out.println(algorithmRsa.decrypt(algorithmRsa.encrypt("Hello")));
    }
}
