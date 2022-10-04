package com.company.encryptionService.asymmetric;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class AlgorithmRsa extends AsymmetricEncryption {
    PublicKey publicKey;
    PrivateKey privateKey;

    public AlgorithmRsa(KeyPair keyPair){
        this.privateKey = keyPair.getPrivate();
        this.publicKey = keyPair.getPublic();
    }

    @Override
    public String encrypt(String data) {
        String encryptedString = null;
        try {
            byte[] secretMessageBytes = data.getBytes();
            Cipher encryptionCipher = Cipher.getInstance("RSA");
            encryptionCipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedBytes = encryptionCipher.doFinal(secretMessageBytes);
            encryptedString = encode(encryptedBytes);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return encryptedString;
    }

    @Override
    public String decrypt(String encryptedData) {
        byte[] dataInBytes = decode(encryptedData);
        String decodedString = null;
        try {
            Cipher decryptionCipher = Cipher.getInstance("RSA");
            decryptionCipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedBytes = decryptionCipher.doFinal(dataInBytes);
            decodedString = new String(decryptedBytes);
        } catch (InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return decodedString;
    }
}
