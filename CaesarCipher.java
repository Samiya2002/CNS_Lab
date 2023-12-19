public class CaesarCipher {
    public static String encrypt(String plainText, int shift) {
        StringBuilder cipherText = new StringBuilder();

        for (char ch : plainText.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                cipherText.append((char) ((ch - base + shift) % 26 + base));
            } else {
                cipherText.append(ch);
            }
        }

        return cipherText.toString();
    }

    public static String decrypt(String cipherText, int shift) {
        return encrypt(cipherText, 26 - shift);
    }

    public static void main(String[] args) {
        String plaintext = "Hello, World!";
        int shift = 3;

        String encryptedText = encrypt(plaintext, shift);
        String decryptedText = decrypt(encryptedText, shift);

        System.out.println("Original Text: " + plaintext);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
