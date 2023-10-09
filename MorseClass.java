import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseClass {
    private static final Map<String, String> morseCodeMap = new HashMap<>();

    static {
        morseCodeMap.put("A", ".-");
        morseCodeMap.put("B", "-...");
        morseCodeMap.put("C", "-.-.");
        morseCodeMap.put("D", "-..");
        morseCodeMap.put("E", ".");
        morseCodeMap.put("F", "..-.");
        morseCodeMap.put("G", "--.");
        morseCodeMap.put("H", "....");
        morseCodeMap.put("I", "..");
        morseCodeMap.put("J", ".---");
        morseCodeMap.put("K", "-.-");
        morseCodeMap.put("L", ".-..");
        morseCodeMap.put("M", "--");
        morseCodeMap.put("N", "-.");
        morseCodeMap.put("O", "---");
        morseCodeMap.put("P", ".--.");
        morseCodeMap.put("Q", "--.-");
        morseCodeMap.put("R", ".-.");
        morseCodeMap.put("S", "...");
        morseCodeMap.put("T", "-");
        morseCodeMap.put("U", "..-");
        morseCodeMap.put("V", "...-");
        morseCodeMap.put("W", ".--");
        morseCodeMap.put("X", "-..-");
        morseCodeMap.put("Y", "-.--");
        morseCodeMap.put("Z", "--..");
        morseCodeMap.put("0", "-----");
        morseCodeMap.put("1", ".----");
        morseCodeMap.put("2", "..---");
        morseCodeMap.put("3", "...--");
        morseCodeMap.put("4", "....-");
        morseCodeMap.put("5", ".....");
        morseCodeMap.put("6", "-....");
        morseCodeMap.put("7", "--...");
        morseCodeMap.put("8", "---..");
        morseCodeMap.put("9", "----.");
        morseCodeMap.put(".", ".-.-.-");
        morseCodeMap.put("'", ".---.");
        morseCodeMap.put("(", "-.--.");
        morseCodeMap.put(":", "---...");
        morseCodeMap.put("+", ".-.-.");
        morseCodeMap.put("¿", "..-.-");
        morseCodeMap.put(",", "--..--");
        morseCodeMap.put("!", "-.-.--");
        morseCodeMap.put(")", "-.--.-");
        morseCodeMap.put(";", "-.-.-.");
        morseCodeMap.put("-", "-....-");
        morseCodeMap.put("$", "...-..-");
        morseCodeMap.put("¡", "--...-");
        morseCodeMap.put("?", "..--..");
        morseCodeMap.put("/", "--..-.");
        morseCodeMap.put("&", ".-...");
        morseCodeMap.put("=", "-...-");
        morseCodeMap.put("_", "..--.-");
        morseCodeMap.put("@", ".--.-.");
    }

    public static String Encrypt(String text) {
        StringBuilder morseCode = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if (c == ' ') {
                morseCode.append(" ");
            } else if (morseCodeMap.containsKey(String.valueOf(c))) {
                morseCode.append(morseCodeMap.get(String.valueOf(c))).append(" ");
            }
        }
        return morseCode.toString();
    }

    public static String Decrypt(String morseCode) {
        StringBuilder text = new StringBuilder();
        String[] words = morseCode.split("   ");
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                for (Map.Entry<String, String> entry : morseCodeMap.entrySet()) {
                    if (entry.getValue().equals(letter)) {
                        text.append(entry.getKey());
                        break;
                    }
                }
            }
            text.append(" ");
        }
        return text.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 0 if you want to encprypt, 1 if you want to decrypt : ");

        int Int = scanner.nextInt();
        if( Int == 0 ){
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Enter text to encode to Morse code: ");
        String inputText = scanner2.nextLine();
        String morseCode = Encrypt(inputText);
        System.out.println("Morse Code: " + morseCode);
        scanner2.close();
        }
        if( Int == 1 ){
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Enter Morse code to decode to text: ");
        String inputMorse = scanner2.nextLine();
        String decodedText = Decrypt(inputMorse);
        System.out.println("Decoded Text: " + decodedText);
        scanner2.close();
        }
        scanner.close();
    }
}
