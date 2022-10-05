package com.company.encryptionService;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class KeyGeneration {

    private int length;
    private String algorithmName;

    public KeyGeneration(String algorithmName) {
        this.length = 1024;
        this.algorithmName = algorithmName;
    }

    public KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance(algorithmName);
        generator.initialize(2048);
        return generator.generateKeyPair();
    }

    public SecretKey generateKey() throws NoSuchAlgorithmException{
        KeyGenerator generator = KeyGenerator.getInstance(algorithmName);
        generator.init(256);
        return generator.generateKey();
    }
}
