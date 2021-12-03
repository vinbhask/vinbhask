package library;

import org.testng.annotations.Test;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import sun.misc.*;

public class AESencrp {      
       private static final String ALGO = "AES";
       private static final byte[] keyValue = new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };

  public static String encrypt(String Data) throws Exception {      
          Key key = generateKey();
          Cipher c = Cipher.getInstance(ALGO);
          c.init(Cipher.ENCRYPT_MODE, key);
          byte[] encVal = c.doFinal(Data.getBytes());
          String encryptedValue = new BASE64Encoder().encode(encVal);
          return encryptedValue;
      }

      public static String decrypt(String encryptedData) throws Exception {
          Key key = generateKey();
          Cipher c = Cipher.getInstance(ALGO);
          c.init(Cipher.DECRYPT_MODE, key);
          byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
          byte[] decValue = c.doFinal(decordedValue);
          String decryptedValue = new String(decValue);
          return decryptedValue;
      }
      private static Key generateKey() throws Exception {
          Key key = new SecretKeySpec(keyValue, ALGO);
          return key;
  }

      @Test
      public static void mainEncryptDecrypt() throws Exception 
      {
    	  JLabel label = new JLabel("Enter the password you want to encrypt : ");
    	  JPasswordField jpf = new JPasswordField();
    	  JOptionPane.showConfirmDialog(null,new Object[]{label, jpf}, "Password", JOptionPane.OK_CANCEL_OPTION);
    	  //System.out.println(new String(jpf.getPassword()));
          String passwordEnc = AESencrp.encrypt(new String(jpf.getPassword()));
          String passwordDec = AESencrp.decrypt(passwordEnc);
          System.out.println("Encrypted Text : " + passwordEnc);
          //System.out.println("Decrypted Text : " + passwordDec);         
      }           
  }
