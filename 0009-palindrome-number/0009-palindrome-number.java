class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindrome
        // Numbers ending with 0 (except 0 itself) also not palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        // Reverse half of the number
        while (x > reversedHalf) {
            int digit = x % 10;
            reversedHalf = reversedHalf * 10 + digit;
            x /= 10;
        }

        // For even length: x == reversedHalf
        // For odd length: x == reversedHalf / 10 (middle digit ignored)
        return (x == reversedHalf) || (x == reversedHalf / 10);
    }
}