import java.util.HashMap;

public class CheapestFlight {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, HashMap<Integer, Integer>> dist = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, -1);
            dist.put(i, new HashMap<Integer, Integer>());
        }

        map.put(src, 0);

        for (int[] arr : flights) {
            dist.get(arr[0]).put(arr[1], arr[2]);
        }

        for (int step = 0; step <= k; step++) {
            HashMap<Integer, Integer> tempMap = new HashMap<>(map);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist.get(i).containsKey(j) && map.get(i)!=-1 && tempMap.get(j)==-1) {
                        tempMap.put(j, map.get(i) + dist.get(i).get(j));
                    }
                    if (dist.get(i).containsKey(j) && map.get(i)!=-1 && tempMap.get(j)!=-1) {
                        tempMap.put(j, Math.min(tempMap.get(j), map.get(i) + dist.get(i).get(j)));
                    }
                }
            }

            map = tempMap;
        }

        return map.get(dst);
    }
}