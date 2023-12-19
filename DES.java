import javax.crypto.*;
import java.util.Base64;
import java.util.Scanner;

public class DES {

    private Cipher eCipher;
    private Cipher dCipher;

    public DES(SecretKey key) throws Exception {
        eCipher = Cipher.getInstance("DES");
        dCipher = Cipher.getInstance("DES");
        eCipher.init(Cipher.ENCRYPT_MODE, key);
        dCipher.init(Cipher.DECRYPT_MODE, key);
    }

    public String encrypt(String str) throws Exception {
        byte[] enc = eCipher.doFinal(str.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(enc);
    }

    public String decrypt(String str) throws Exception {
        byte[] dec = Base64.getDecoder().decode(str);
        byte[] byteData = dCipher.doFinal(dec);
        return new String(byteData, "UTF-8");
    }

    public static void main(String[] argv) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text to encrypt:");
        final String secretText = sc.next();
        System.out.println("SecretText: " + secretText);

        // Generation of Secret key
        SecretKey key = KeyGenerator.getInstance("DES").generateKey();

        DES des = new DES(key);

        String encrypted = des.encrypt(secretText);
        System.out.println("Encrypted Value: " + encrypted);

        String decrypted = des.decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);

        sc.close();
    }
}
