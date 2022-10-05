package com.company.encryptionService;

import com.company.encryptionService.Encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class AsymmetricEncryption implements Encryption {
    private PublicKey publicKey;
    private PrivateKey privateKey;
    private String algorithmName;

    public AsymmetricEncryption(String algorithmName, KeyPair keyPair){
        this.algorithmName = algorithmName;
        this.privateKey = keyPair.getPrivate();
        this.publicKey = keyPair.getPublic();
    }

    @Override
    public String encrypt(String data) throws Exception {
        byte[] secretMessageBytes = data.getBytes();
        Cipher encryptionCipher = Cipher.getInstance(algorithmName);
        encryptionCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = encryptionCipher.doFinal(secretMessageBytes);
        System.out.println("The encryption has been done successfully!");
        return encode(encryptedBytes);
    }

    @Override
    public String decrypt(String encryptedData) throws Exception{
        byte[] dataInBytes = decode(encryptedData);
        Cipher decryptionCipher = Cipher.getInstance(algorithmName);
        decryptionCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = decryptionCipher.doFinal(dataInBytes);
        System.out.println("The decryption has been done successfully!");
        return new String(decryptedBytes);
    }
}
