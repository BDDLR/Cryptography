package com.test;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

public class AESencryption {
    private static final String ALGORITHM = "AES";      //Algorithm to use
    private byte[] keyValue;                         //Secret key to use

    //Constructor that receives the key to use
    public AESencryption(String key) {
        keyValue = key.getBytes();
    }
    
    public String encryptData(String data) throws Exception{
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }
    
    public String decryptData(String encryptedData) throws Exception{
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        
        return decryptedValue;
    }
    
    private Key generateKey() throws Exception{
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    }
    
}
