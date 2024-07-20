public class ExelSheet {
    public static String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--;
            int rem = columnNumber % 26;
            columnNumber /= 26;
            
            res.insert(0, (char) ('A' + rem));
        }
        
        return res.toString();
    }

    public static void main(String[] args) {
        int columnNumber1 = 1;
        System.out.println(convertToTitle(columnNumber1));
        int columnNumber2 = 28;
        System.out.println(convertToTitle(columnNumber2));
        int columnNumber3 = 701;
        System.out.println(convertToTitle(columnNumber3));
    }
}
