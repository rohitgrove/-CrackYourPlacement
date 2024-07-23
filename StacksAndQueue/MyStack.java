import java.util.Queue;
import java.util.LinkedList;

public class MyStack {
    public int top;
    public Queue<Integer> q1;
    public Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {

        q1.add(x);
        top = x;
    }

    public int pop() {
        while (q1.size() > 1) {
            top = q1.poll();
            q2.add(top);
        }
        int e = q1.poll();
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
        return e;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
