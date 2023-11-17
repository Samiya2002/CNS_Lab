import java.security.*;
import java.util.*;

public class DigitalSignature {
    public static void main(String[] args) throws Exception {

        // Generating key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // data to be signed
        String data = "Hello, this is the text to be signed.";

        // Signing
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(keyPair.getPrivate());
        signature.update(data.getBytes());

        // Generate the digital signature
        byte[] digitalSignature = signature.sign();
        System.out.println("Digital Signature: " + Base64.getEncoder().encodeToString(digitalSignature));

        // Verification Signature
        Signature verificationSignature = Signature.getInstance("SHA256withRSA");
        verificationSignature.initVerify(keyPair.getPublic());
        verificationSignature.update(data.getBytes());

        // Verify the digital signature
        boolean isVerified = verificationSignature.verify(digitalSignature);
        System.out.println("Signature verified: " + isVerified);

    }
}

/*
 * OP:
 * Digital Signature : some rubbish
 * Signature verified : true
 */