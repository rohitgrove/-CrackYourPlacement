import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumNumberOfVisiblePoints {
    private static final double PI = 3.14159265;
    private static final double MARGIN = 1e-9;

    public static double getAngle(int xDiff, int yDiff) {
        return Math.atan2(yDiff, xDiff) * 180 / PI;
    }

    public static int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int n = points.size();
        int common = 0;
        List<Double> vals = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int x = points.get(i).get(0) - location.get(0);
            int y = points.get(i).get(1) - location.get(1);
            if (x == 0 && y == 0) {
                common++;
            } else {
                double A = getAngle(x, y);
                if (A < 0) A += 360;
                vals.add(A);
            }
        }

        Collections.sort(vals);
        List<Double> a = new ArrayList<>(vals);
        a.addAll(vals);
        for (int i = vals.size(); i < a.size(); i++) {
            a.set(i, a.get(i) + 360);
        }

        int ret = 0;
        for (int i = 0, j = 0; i < a.size(); i++) {
            while (j < a.size() && (a.get(j) - a.get(i) <= angle + MARGIN)) {
                j++;
            }
            ret = Math.max(ret, j - i);
        }

        return ret + common;
    }

    public static void main(String[] args) {
        List<List<Integer>> points = new ArrayList<>();
        points.add(Arrays.asList(2, 1));
        points.add(Arrays.asList(2, 2));
        points.add(Arrays.asList(3, 3));
        
        int angle = 90;
        List<Integer> location = Arrays.asList(1, 1);

        int result = visiblePoints(points, angle, location);
        System.out.println(result);  // Expected output: 3
    }
}