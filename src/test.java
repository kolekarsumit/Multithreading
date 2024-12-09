import java.util.HashMap;
import java.util.Map;

public class test {
    public static int[] findSecondLargestProduct(int[] nums) {

        int[] secondMaxPair = new int[2];
        if (nums == null || nums.length < 2) {
            return secondMaxPair;
        }

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int max1Index = -1, max2Index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max2 = max1;
                max2Index = max1Index;
                max1 = nums[i];
                max1Index = i;
            } else if (nums[i] > max2) {
                max2 = nums[i];
                max2Index = i;
            }
        }

        // Variables to store the second largest product and its indices
        int secondMaxProduct = Integer.MIN_VALUE;

        // Second pass: Calculate products and find the second largest product
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];

                if (product < max1 * max2 && product > secondMaxProduct) {
                    secondMaxProduct = product;
                    secondMaxPair[0] = i;
                    secondMaxPair[1] = j;
                }
            }
        }

        return secondMaxPair;
    }



    public static String findMostFrequentCharacter(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("String must not be null or empty");
        }

        // HashMap to store the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        char mostFrequentChar = s.charAt(0);
        int maxFrequency = 0;

        // Traverse the string once
        for (char c : s.toCharArray()) {
            // Increment the frequency in the map
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);

            // Check if the current character's frequency is greater than the max frequency
            if (frequencyMap.get(c) > maxFrequency) {
                mostFrequentChar = c;
                maxFrequency = frequencyMap.get(c);
            }
        }

        // Return the most frequent character as a string
        return String.valueOf(mostFrequentChar);
    }

    public static void main(String[] args) {
        String s1 = "abacabad";
        System.out.println("Most frequent character: " + findMostFrequentCharacter(s1)); // Output: "a"

    }
}
