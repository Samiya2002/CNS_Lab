import java.io.*;
import java.math.BigInteger;

public class DiffieHellman {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //pub key
        System.out.println("Enter prime number:");
        BigInteger p = new BigInteger(br.readLine());
        //pub key
        System.out.print("Enter primitive root of " + p + ":");
        BigInteger g = new BigInteger(br.readLine());
        //priv key
        System.out.println("Enter value for a less than " + p + ":");
        BigInteger a = new BigInteger(br.readLine());
        //key generated
        BigInteger x = g.modPow(a, p);
        System.out.println("R1=" + x);
        // priv Key
        System.out.print("Enter value for b less than " + p + ":");
        BigInteger b = new BigInteger(br.readLine());
        //key generated
        BigInteger y = g.modPow(b, p);
        System.out.println("R2=" + y);

        BigInteger k1 = y.modPow(a, p);
        System.out.println("Key1 calculated :" + k1);

        BigInteger k2 = x.modPow(b, p);
        System.out.println("Key2 calculated :" + k2);
        System.out.println("deffie hellman secret key Encryption has Taken");
    }
}