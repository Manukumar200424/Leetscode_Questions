class Solution {
    public boolean isNumber(String s) {

        s = s.trim();

        boolean digitSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Digit
            if (Character.isDigit(ch)) {
                digitSeen = true;
            }

            // Sign
            else if (ch == '+' || ch == '-') {

                // Sign allowed only at beginning
                // or immediately after e/E
                if (i > 0 && s.charAt(i - 1) != 'e'
                          && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            // Decimal point
            else if (ch == '.') {

                // Dot not allowed after e/E
                // and only one dot allowed
                if (dotSeen || eSeen) {
                    return false;
                }

                dotSeen = true;
            }

            // Exponent
            else if (ch == 'e' || ch == 'E') {

                // Only one e/E allowed
                // and digit must exist before e
                if (eSeen || !digitSeen) {
                    return false;
                }

                eSeen = true;

                // Need digits after e
                digitSeen = false;
            }

            // Invalid character
            else {
                return false;
            }
        }

        return digitSeen;
    }
}