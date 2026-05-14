import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {

        List<Integer> numbers = new ArrayList<>();

        int[] fact = new int[n + 1];
        fact[0] = 1;

        // Calculate factorials
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
            numbers.add(i);
        }

        // Convert k to 0-based index
        k--;

        StringBuilder result = new StringBuilder();

        for (int i = n; i >= 1; i--) {

            int index = k / fact[i - 1];

            result.append(numbers.get(index));

            numbers.remove(index);

            k = k % fact[i - 1];
        }

        return result.toString();
    }
}