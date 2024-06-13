import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] text = br.readLine().toCharArray();
        char[] pattern = br.readLine().toCharArray();

        int[] prefixTable = getPrefixTable(pattern);
        List<Integer> matchIndices = new ArrayList<>();

        int textIndex = 0;
        int patternIndex = 0;
        while (textIndex < text.length) {
            if (text[textIndex] == pattern[patternIndex]) {
                textIndex++;
                patternIndex++;
                if (patternIndex == pattern.length) {
                    matchIndices.add((textIndex - pattern.length) + 1);
                    patternIndex = prefixTable[patternIndex - 1];
                }
            } else {
                if (patternIndex != 0) {
                    patternIndex = prefixTable[patternIndex - 1];
                } else {
                    textIndex++;
                }
            }
        }

        System.out.println(matchIndices.size());
        for (int index : matchIndices) {
            System.out.print(index + " ");
        }
    }

    private static int[] getPrefixTable(char[] pattern) {
        int[] prefixTable = new int[pattern.length];
        int length = 0;
        int i = 1;
        while (i < pattern.length) {
            if (pattern[i] == pattern[length]) {
                length++;
                prefixTable[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = prefixTable[length - 1];
                } else {
                    prefixTable[i] = length;
                    i++;
                }
            }
        }
        return prefixTable;
    }
}