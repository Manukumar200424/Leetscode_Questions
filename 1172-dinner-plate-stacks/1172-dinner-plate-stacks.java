import java.util.*;

class DinnerPlates {

    private int capacity;
    private List<Stack<Integer>> stacks;
    private TreeSet<Integer> available;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        stacks = new ArrayList<>();
        available = new TreeSet<>();
    }

    public void push(int val) {

        if (available.isEmpty()) {
            stacks.add(new Stack<>());
            available.add(stacks.size() - 1);
        }

        int idx = available.first();

        stacks.get(idx).push(val);

        if (stacks.get(idx).size() == capacity) {
            available.remove(idx);
        }
    }

    public int pop() {

        while (!stacks.isEmpty()
                && stacks.get(stacks.size() - 1).isEmpty()) {

            int last = stacks.size() - 1;

            available.remove(last);
            stacks.remove(last);
        }

        if (stacks.isEmpty()) {
            return -1;
        }

        int idx = stacks.size() - 1;

        int val = stacks.get(idx).pop();

        available.add(idx);

        while (!stacks.isEmpty()
                && stacks.get(stacks.size() - 1).isEmpty()) {

            int last = stacks.size() - 1;

            available.remove(last);
            stacks.remove(last);
        }

        return val;
    }

    public int popAtStack(int index) {

        if (index >= stacks.size()
                || stacks.get(index).isEmpty()) {
            return -1;
        }

        int val = stacks.get(index).pop();

        available.add(index);

        return val;
    }
}