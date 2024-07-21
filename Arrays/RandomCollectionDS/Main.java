public class Main {
    public static void main(String[] args) {
        RandomizedCollection obj = new RandomizedCollection();
        boolean param_1 = obj.insert(1);
        boolean param_2 = obj.insert(1);
        boolean param_3 = obj.insert(2);
        boolean param_4 = obj.remove(1);
        int param_5 = obj.getRandom();
        
        System.out.println("Insert 1: " + param_1);
        System.out.println("Insert 1 again: " + param_2);
        System.out.println("Insert 2: " + param_3);
        System.out.println("Remove 1: " + param_4);
        System.out.println("Get Random: " + param_5);
    }
}
