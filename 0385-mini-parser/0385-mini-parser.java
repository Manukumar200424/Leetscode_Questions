/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation.
 * public class NestedInteger {
 *     public NestedInteger() {}
 *     public NestedInteger(int value) {}
 *     public boolean isInteger() {}
 *     public Integer getInteger() {}
 *     public void setInteger(int value) {}
 *     public void add(NestedInteger ni) {}
 *     public List<NestedInteger> getList() {}
 * }
 */

class Solution {
    public NestedInteger deserialize(String s) {

        // If the string is just a single integer
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger curr = null;

        int num = 0;
        boolean negative = false;
        boolean hasNum = false;

        for (char ch : s.toCharArray()) {

            if (ch == '[') {
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedInteger();
            }
            else if (ch == ']') {

                if (hasNum) {
                    if (negative) num = -num;
                    curr.add(new NestedInteger(num));
                }

                if (!stack.isEmpty()) {
                    NestedInteger parent = stack.pop();
                    parent.add(curr);
                    curr = parent;
                }

                num = 0;
                negative = false;
                hasNum = false;
            }
            else if (ch == ',') {

                if (hasNum) {
                    if (negative) num = -num;
                    curr.add(new NestedInteger(num));
                }

                num = 0;
                negative = false;
                hasNum = false;
            }
            else if (ch == '-') {
                negative = true;
            }
            else { // digit
                num = num * 10 + (ch - '0');
                hasNum = true;
            }
        }

        return curr;
    }
}