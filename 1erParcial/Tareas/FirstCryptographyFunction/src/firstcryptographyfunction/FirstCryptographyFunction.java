
package firstcryptographyfunction;

public class FirstCryptographyFunction {

    public static void main(String[] args) throws Exception {
        
        AESencryption aes = new AESencryption("SuperLlaveBryan1");
        
        String encData = aes.encryptData("Hola Mundo");
        System.out.println("ENCRYPTED: " + encData);
        
        String decData = aes.decryptData(encData);
        System.out.println("DECRYPTED: " + decData);
    }
    
}
