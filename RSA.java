import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {

    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger modulus;

    // Key generation
    public void generateKeys(int bitLength) {
        SecureRandom random = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(bitLength, random);
        BigInteger q = BigInteger.probablePrime(bitLength, random);

        modulus = p.multiply(q);

        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        publicKey = new BigInteger("65537"); // Commonly used public exponent
        privateKey = publicKey.modInverse(phi);
    }

    // Encryption
    public BigInteger encrypt(BigInteger message) {
        return message.modPow(publicKey, modulus);
    }

    // Decryption
    public BigInteger decrypt(BigInteger ciphertext) {
        return ciphertext.modPow(privateKey, modulus);
    }

    public static void main(String[] args) {
        RSA rsa = new RSA();
        rsa.generateKeys(2048);

        BigInteger originalMessage = new BigInteger("42"); // Your message here

        System.out.println("Original Message: " + originalMessage);

        BigInteger encryptedMessage = rsa.encrypt(originalMessage);
        System.out.println("Encrypted Message: " + encryptedMessage);

        BigInteger decryptedMessage = rsa.decrypt(encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}
