import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class FileEncryptionDecryption {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    public static void main(String[] args) {
        try {
            // Replace "your_secret_key" with a strong and secure key
            String secretKey = "your_secret_key";

            // Encrypt a file
            encryptFile("plaintext.txt", "encrypted.txt", secretKey);

            // Decrypt the encrypted file
            decryptFile("encrypted.txt", "decrypted.txt", secretKey);

            System.out.println("File encryption and decryption completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void encryptFile(String inputFileName, String outputFileName, String secretKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException {

        SecretKey key = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        try (InputStream inputStream = new FileInputStream(inputFileName);
             OutputStream outputStream = new FileOutputStream(outputFileName)) {

            byte[] inputBytes = new byte[(int) new File(inputFileName).length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            outputStream.write(Base64.getEncoder().encode(outputBytes));
        }
    }

    private static void decryptFile(String inputFileName, String outputFileName, String secretKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException {

        SecretKey key = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, key);

        try (InputStream inputStream = new FileInputStream(inputFileName);
             OutputStream outputStream = new FileOutputStream(outputFileName)) {

            byte[] inputBytes = Base64.getDecoder().decode(inputStream.readAllBytes());
            byte[] outputBytes = cipher.doFinal(inputBytes);

            outputStream.write(outputBytes);
        }
    }
}