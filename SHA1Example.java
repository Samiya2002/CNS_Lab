import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1Example {

    public static void main(String[] args) {
        String inputText = "Hello, SHA-1!";

        try {
            String sha1Digest = calculateSHA1(inputText);
            System.out.println("Original Text: " + inputText);
            System.out.println("SHA-1 Digest: " + sha1Digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String calculateSHA1(String text) throws NoSuchAlgorithmException {
        MessageDigest sha1Digest = MessageDigest.getInstance("SHA-1");
        byte[] hashBytes = sha1Digest.digest(text.getBytes());

        // Convert the byte array to a hexadecimal string
        StringBuilder hexStringBuilder = new StringBuilder();
        for (byte hashByte : hashBytes) {
            hexStringBuilder.append(String.format("%02x", hashByte));
        }

        return hexStringBuilder.toString();
    }
}
