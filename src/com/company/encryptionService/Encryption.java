package com.company.encryptionService;

public interface Encryption {
    String encrypt(String data) throws Exception;
    String decrypt(String encryptedData) throws Exception;
}
