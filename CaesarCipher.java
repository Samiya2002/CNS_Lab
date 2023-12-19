import java.util.*;
 
public class CaesarCipher{
    public static String encrypt(String plainText, int K){
        plainText = plainText.toLowerCase();
        String cipherText = "";
        for (int i = 0; i < plainText.length(); i++){
            int P = plainText.charAt(i) - 'a';
            int keyVal = (P+K) % 26;
            char replaceVal = (char)('a' + keyVal);
            cipherText += replaceVal;
        }
        return cipherText;
    }
 
    public static String decrypt(String cipherText, int K){
        cipherText = cipherText.toLowerCase();
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++){
            int P = cipherText.charAt(i) - 'a';
            int keyVal = (P - K) % 26;
            if (keyVal < 0){
                keyVal = 26 + keyVal;
            }
            char replaceVal = (char)('a' + keyVal);
            plainText += replaceVal;
        }
        return plainText;
    }
 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String for Encryption: ");
        String message = sc.next();
        System.out.println("Enter K Value: ");
        int k = sc.nextInt();

        String encrypted = encrypt(message, k);
        String decrypted = decrypt(encrypted, k);
        System.out.println("The Encrypted Message is: "+ encrypted);
        System.out.println("The Decrypted Message is: " + decrypted);
        sc.close();
    }
}
