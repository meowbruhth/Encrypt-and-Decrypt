import java.util.Scanner;

public class MainClass {

    public static String encrypt(String plainText, String key) {
        StringBuilder encryptedText = new StringBuilder();
        int keyLength = key.length();
        for (int i = 0; i < plainText.length(); i++) {
            char plainChar = plainText.charAt(i);
            char keyChar = key.charAt(i % keyLength);
            char encryptedChar = encryptChar(plainChar, keyChar);
            encryptedText.append(encryptedChar);
        }
        return encryptedText.toString();
    }

    public static String decrypt(String encryptedText, String key) {
        StringBuilder decryptedText = new StringBuilder();
        int keyLength = key.length();
        for (int i = 0; i < encryptedText.length(); i++) {
            char encryptedChar = encryptedText.charAt(i);
            char keyChar = key.charAt(i % keyLength);
            char plainChar = decryptChar(encryptedChar, keyChar);
            decryptedText.append(plainChar);
        }
        return decryptedText.toString();
    }

    private static char encryptChar(char plainChar, char keyChar) {
        if (Character.isUpperCase(plainChar)) {
            return (char) (((plainChar - 'A' + keyChar - 'A') % 26) + 'A');
        } else if (Character.isLowerCase(plainChar)) {
            return (char) (((plainChar - 'a' + keyChar - 'A') % 26) + 'a');
        } else {
            return plainChar;
        }
    }

    private static char decryptChar(char encryptedChar, char keyChar) {
        if (Character.isUpperCase(encryptedChar)) {
            int result = (encryptedChar - 'A' - (keyChar - 'A')) % 26;
            if (result < 0) {
                result += 26;
            }
            return (char) (result + 'A');
        } else if (Character.isLowerCase(encryptedChar)) {
            int result = (encryptedChar - 'a' - (keyChar - 'A')) % 26;
            if (result < 0) {
                result += 26;
            }
            return (char) (result + 'a');
        } else {
            return encryptedChar;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String plainText = scanner.nextLine();
        String key = scanner.nextLine();
        String encryptedText = encrypt(plainText, key);
        System.out.println("Encrypted Text: " + encryptedText);
        String decryptedText = decrypt(encryptedText, key);
        System.out.println("Decrypted Text: " + decryptedText);
        scanner.close();
    }

}