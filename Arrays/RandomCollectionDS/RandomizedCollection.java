import java.util.*;

public class RandomizedCollection {
    public List<Integer> arr;
    public Map<Integer, Set<Integer>> map;

    public RandomizedCollection() {
        arr = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        arr.add(val);
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(arr.size() - 1);
        return map.get(val).size() == 1;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }
        int ind = map.get(val).iterator().next();
        map.get(val).remove(ind);

        if (ind < arr.size() - 1) {
            int lastElement = arr.get(arr.size() - 1);
            arr.set(ind, lastElement);
            map.get(lastElement).add(ind);
            map.get(lastElement).remove(arr.size() - 1);
        }

        arr.remove(arr.size() - 1);
        return true;
    }

    public int getRandom() {
        Random rand = new Random();
        return arr.get(rand.nextInt(arr.size()));
    }
}