
import java.util.*;
import javax.crypto.*;

class DESTwoThree {
    Cipher eCipher;
    Cipher dCipher;

    // "DESede is also known as triple DES in java.crypto package"
    // "DES-Encrypt-Decrypt-Encrypt = Triple DES"

    DESTwoThree(SecretKey sk) throws Exception {
        eCipher = Cipher.getInstance("DESede");
        dCipher = Cipher.getInstance("DESede");

        eCipher.init(Cipher.ENCRYPT_MODE, sk);
        dCipher.init(Cipher.DECRYPT_MODE, sk);
    }

    public String encrypt(String str) throws Exception {
        byte[] byteData = str.getBytes("UTF8");
        // doFinal expects type of byte[] and returns byte[]
        byte[] enc = eCipher.doFinal(byteData);

        // Encode bytes to base64 to get a string
        return Base64.getEncoder().encodeToString(enc);
    }

    public String decrypt(String str) throws Exception {
        byte[] dec = Base64.getDecoder().decode(str);
        // doFinal expects type of byte[] and returns byte[]
        byte[] byteData = dCipher.doFinal(dec);

        return new String(byteData, "UTF8");
    }
}

public class Task6 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text to ecrypt: ");
        String secretText = sc.next();
        System.out.println("SecretText: " + secretText);

        SecretKey key = KeyGenerator.getInstance("DESede").generateKey();
        DESTwoThree dtt = new DESTwoThree(key);
        String enc = dtt.encrypt(secretText);
        System.out.println(enc);

        String dec = dtt.decrypt(enc);
        System.out.println(dec);

        sc.close();
    }
}