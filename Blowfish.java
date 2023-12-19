import javax.crypto.*;
import java.util.Base64;
import java.util.Scanner;

public class Blowfish {

    private Cipher eCipher;
    private Cipher dCipher;

    public Blowfish(SecretKey key) throws Exception {
        eCipher = Cipher.getInstance("Blowfish");
        dCipher = Cipher.getInstance("Blowfish");

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

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text to encrypt: ");
        final String secretText = sc.next();
        System.out.println("SecretText: " + secretText);

        SecretKey key = KeyGenerator.getInstance("Blowfish").generateKey();
        Blowfish blowfish = new Blowfish(key);

        String encrypted = blowfish.encrypt(secretText);
        System.out.println("Encrypted Value: " + encrypted);

        String decrypted = blowfish.decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);

        sc.close();
    }
}
