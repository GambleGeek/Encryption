package com.company.encryptionService;

import com.company.encryptionService.Encryption;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class SymmetricEncryption implements Encryption {

    private SecretKey key;
    private String algorithmName;
    //path of the file that we want to encrypt
    private String textFile;
    //path of the encrypted file that we get as output
    private String encryptedData;
    //path of the decrypted file that we get as output
    private String decryptedData;

    public SymmetricEncryption(String algorithmName, SecretKey key) {
        this.algorithmName = algorithmName;
        this.key = key;
    }

    @Override
    public String encrypt(String data) throws Exception {
        byte[] dataInBytes = data.getBytes();

        //setting encryption mode
        Cipher encrypt = Cipher.getInstance(algorithmName);
        encrypt.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = encrypt.doFinal(dataInBytes);

        System.out.println("The encryption has been done successfully!");
        return encode(encryptedBytes);
    }

    @Override
    public String decrypt(String encryptedData) throws Exception {
        byte[] dataInBytes = decode(encryptedData);

        //setting decryption mode
        Cipher decrypt = Cipher.getInstance(algorithmName);
        decrypt.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = decrypt.doFinal(dataInBytes);

        System.out.println("The decryption has been done successfully!");
        return new String(decryptedBytes);
    }
}
