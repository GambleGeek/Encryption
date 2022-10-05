package com.company.cli.menu.util;

import java.util.HashMap;
import java.util.Map;

public final class Values {
    public static final String CAESAR = "CAESAR";
    public static final String AES = "AES";
    public static final String DES = "DES";
    public static final String RSA = "RSA";

    public static final Map<String, String> ENCRYPT = new HashMap<>();
    public static final Map<String, String> DECRYPT = new HashMap<>();

    public Values(){
        ENCRYPT.put("noun", "Encryption");
        ENCRYPT.put("verb", "encrypt");
        DECRYPT.put("noun", "Decryption");
        DECRYPT.put("verb", "decrypt");
    }
}
