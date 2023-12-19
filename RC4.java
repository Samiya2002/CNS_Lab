public class RC4 {

    private byte[] key;
    private int[] S;

    public RC4(byte[] key) {
        this.key = key;
        initialize();
    }

    private void initialize() {
        S = new int[256];
        for (int i = 0; i < 256; i++) {
            S[i] = i;
        }

        int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (j + S[i] + key[i % key.length]) & 0xFF;
            swap(i, j);
        }
    }

    public byte[] encrypt(byte[] plaintext) {
        int i = 0, j = 0;
        byte[] cipher = new byte[plaintext.length];

        for (int k = 0; k < plaintext.length; k++) {
            i = (i + 1) & 0xFF;
            j = (j + S[i]) & 0xFF;

            swap(i, j);

            int t = (S[i] + S[j]) & 0xFF;
            cipher[k] = (byte) (plaintext[k] ^ S[t]);
        }

        return cipher;
    }

    public byte[] decrypt(byte[] ciphertext) {
        return encrypt(ciphertext);
    }

    private void swap(int i, int j) {
        int temp = S[i];
        S[i] = S[j];
        S[j] = temp;
    }

    public static void main(String[] args) {
        // Example usage
        byte[] key = "SecretKey".getBytes();
        RC4 rc4 = new RC4(key);

        String plaintext = "Hello, RC4!";
        byte[] encrypted = rc4.encrypt(plaintext.getBytes());
        byte[] decrypted = rc4.decrypt(encrypted);

        System.out.println("Original Text: " + plaintext);
        System.out.println("Encrypted Text: " + new String(encrypted));
        System.out.println("Decrypted Text: " + new String(decrypted));
    }
}
