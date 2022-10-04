package com.company.encryptionService;

import java.util.Base64;

public interface Encryption {
    public String encrypt(String data) throws Exception;
    public String decrypt(String encryptedData) throws Exception;
    default String encode(byte[] data) { return Base64.getEncoder().encodeToString(data); }
    default byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }
}
