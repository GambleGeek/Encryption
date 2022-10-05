package com.company.encryptionService;

public class AlgorithmCaesar {
    private int key;

    public AlgorithmCaesar(int key) {
        this.key = key;
    }

    public String encrypt(String text){
        char[] chars = text.toCharArray();
        StringBuilder encrypted = new StringBuilder();
        for (char c : chars) {
            c += key;
            encrypted.append(c);
        }
        return encrypted.toString();
    }

    public String decrypt(String text){
        char[] chars = text.toCharArray();
        StringBuilder decrypted = new StringBuilder();
        for (char c : chars) {
            c -= key;
            decrypted.append(c);
        }
        return decrypted.toString();
    }
}
