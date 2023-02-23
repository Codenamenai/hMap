import java.util.HashMap;
import java.util.Map;

public class Main {
    public static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit" +
            ", sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut" +
            " aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
            "voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
            "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui " +
            "officia deserunt mollit anim id est laborum.";
    public static Map<Character, Integer> letter = new HashMap<>();

    public static void main(String[] args) {

        text = text.toLowerCase();
        char symbols;
        for (int i = 0; i < text.length(); i++) {
            symbols = text.charAt(i);
            if (Character.isLetter(symbols)) {
                if (!letter.containsKey(symbols)) {
                    letter.put(symbols, 1);
                } else {
                    Integer increase = letter.get(symbols);
                    increase++;
                    letter.put(symbols, increase);
                }
            }
        }

        System.out.println("Чаще всего в тексте встречается буква " +
                " " + maxV().getKey() + ", " + maxV().getValue() + " раза");

        System.out.println("Реже всего в тексте встречается буква " +
                " " + minV().getKey() + ", " + minV().getValue() + " раз");
    }

    protected static Map.Entry<Character, Integer> minV() {
        Map.Entry<Character, Integer> minValue = null;
        for (Map.Entry<Character, Integer> entry : letter.entrySet()) {
            if (minValue == null || entry.getValue() < minValue.getValue()) {
                minValue = entry;
            }
        }
        return minValue;
    }

    protected static Map.Entry<Character, Integer> maxV() {
        Map.Entry<Character, Integer> maxValue = null;
        for (Map.Entry<Character, Integer> entry : letter.entrySet()) {
            if (maxValue == null || entry.getValue() > maxValue.getValue()) {
                maxValue = entry;
            }

        }
        return maxValue;


    }
}







