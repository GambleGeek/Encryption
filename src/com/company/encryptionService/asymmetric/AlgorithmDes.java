package com.company.encryptionService.asymmetric;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

public class AlgorithmDes extends AsymmetricEncryption
{
    //creating an instance of the Cipher class for encryption
    private static Cipher encrypt;
    //creating an instance of the Cipher class for decryption
    private static Cipher decrypt;

    private final byte[] initialization_vector = { 22, 33, 11, 44, 55, 99, 66, 77 };

    //generating keys by using the KeyGenerator class
    SecretKey scrtkey;
    AlgorithmParameterSpec aps;

    public void initKey() throws Exception {
        scrtkey = KeyGenerator.getInstance("DES").generateKey();
        aps = new IvParameterSpec(initialization_vector);
    }

    @Override
    public String encrypt(String data) throws Exception {
        byte[] dataInBytes = data.getBytes();

        //setting encryption mode
        encrypt = Cipher.getInstance("DES/CBC/PKCS5Padding");
        encrypt.init(Cipher.ENCRYPT_MODE, scrtkey, aps);
        byte[] encryptedBytes = encrypt.doFinal(dataInBytes);

        System.out.println("The encryption has been done successfully!");
        return encode(encryptedBytes);
    }

    @Override
    public String decrypt(String encryptedData) throws Exception {
        byte[] dataInBytes = decode(encryptedData);

        //setting decryption mode
        decrypt = Cipher.getInstance("DES/CBC/PKCS5Padding");
        decrypt.init(Cipher.DECRYPT_MODE, scrtkey, aps);
        byte[] decryptedBytes = decrypt.doFinal(dataInBytes);

        System.out.println("The decryption has been done successfully!");
        return new String(decryptedBytes);
    }

    private String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }
}
