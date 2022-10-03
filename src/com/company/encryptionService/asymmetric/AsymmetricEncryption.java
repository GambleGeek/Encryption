package com.company.encryptionService.asymmetric;

import com.company.encryptionService.Encryption;

abstract class AsymmetricEncryption implements Encryption {
    private String privateKey;
    private String publicKey;
}
