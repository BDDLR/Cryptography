package rsa;

import java.io.*;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;


public class Rsa {
    private static Cipher rsaa;

    public static void main(String[] args) throws Exception {
        /***********************************
         la linea numero 31 se le quita el comentario para guardar la llave en un txt despues se comenta XD para que no genere otra 
         **********************************/
        
        //crea las llaves
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        
        //saveKey(publicKey,"publicKey.txt"); //guarda la llave en un txt
        publicKey = loadPublicKey("publickey.txt");
        
        //saveKey(privateKey,"privateKey.txt");
        privateKey= loadPrivateKey("privateKey.txt");
        
        rsaa= Cipher.getInstance("RSA/ECB/PKCS1Padding");
        File archivo= new File("archivo.txt");
        FileReader fr = new FileReader(archivo);   
        BufferedReader br = new BufferedReader(fr);
        
        String text;
        text=br.readLine();
        br.close();
        fr.close();
        
        rsaa.init(Cipher.ENCRYPT_MODE,publicKey);
        byte[] cifrado = rsaa.doFinal(text.getBytes());
        FileOutputStream fos = new FileOutputStream("c.txt");
        fos.write(cifrado);
        fos.close();
        
        for(byte b : cifrado ){
            System.out.print(Integer.toHexString(0xFF & b));
            
        }
        System.out.println();
        
        rsaa.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] descifrar = rsaa.doFinal(cifrado);
        String desciftext = new String(descifrar);
        FileWriter w = new FileWriter("d.txt");
        PrintWriter wr = new PrintWriter(w); 
        wr.write(desciftext);
        w.close();
        
        System.out.println(desciftext);
               
    }

    private static void saveKey (Key key, String nombrearchivo) throws Exception{
        byte[] keyBytes = key.getEncoded();
        FileOutputStream fos = new FileOutputStream(nombrearchivo);
        fos.write(keyBytes);
        fos.close();
    }

    private static PublicKey loadPublicKey(String nombrearchivo) throws Exception{
       FileInputStream fis = new FileInputStream(nombrearchivo);
       int numBytes = fis.available();
       byte[] bytes = new byte[numBytes];
       fis.read(bytes);
       fis.close();
       
       KeyFactory keyFactory = KeyFactory.getInstance("RSA");
       KeySpec keySpec = new X509EncodedKeySpec(bytes);
       PublicKey keyFromBytes = keyFactory.generatePublic(keySpec);
       return keyFromBytes;
    }

    private static PrivateKey loadPrivateKey(String nombrearchivo)throws Exception {
       FileInputStream fis = new FileInputStream(nombrearchivo);
       int numBytes = fis.available();
       byte[] bytes = new byte[numBytes];
       fis.read(bytes);
       fis.close();
       
       KeyFactory keyFactory = KeyFactory.getInstance("RSA");
       KeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
       PrivateKey keyFromBytes = keyFactory.generatePrivate(keySpec);
       return keyFromBytes;
    }
    
}
