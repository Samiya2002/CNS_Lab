import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Example {

    public static void main(String[] args) {
        String inputText = "Hello, MD5!";

        try {
            String md5Digest = calculateMD5(inputText);
            System.out.println("Original Text: " + inputText);
            System.out.println("MD5 Digest: " + md5Digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String calculateMD5(String text) throws NoSuchAlgorithmException {
        MessageDigest md5Digest = MessageDigest.getInstance("MD5");
        byte[] hashBytes = md5Digest.digest(text.getBytes());

        // Convert the byte array to a hexadecimal string
        StringBuilder hexStringBuilder = new StringBuilder();
        for (byte hashByte : hashBytes) {
            hexStringBuilder.append(String.format("%02x", hashByte));
        }

        return hexStringBuilder.toString();
    }
}
