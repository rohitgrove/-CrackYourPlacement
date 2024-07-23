import java.util.Stack;
import java.util.ArrayList;

public class StockSpanner {
    Stack<Integer> st;
    ArrayList<Integer> list;

    public StockSpanner() {
        st = new Stack<>();
        list = new ArrayList<>();
    }

    public int next(int price) {
        list.add(price);
        while (!st.isEmpty() && list.get(st.peek()) <= price) {
            st.pop();
        }
        int previousGreatestIndex = st.isEmpty() ? -1 : st.peek();
        int ans = (list.size() - 1) - previousGreatestIndex;
        st.push(list.size() - 1);
        return ans;
    }
}
