package Tasks;

public class Task2 {
    // Part 1
    public static String repeat(String str, int n){
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            res += str.charAt(i) *n;
        }
        return res;
    }
    // Part 2
    public static int differenceMaxMin(int[] mas){
        int max=mas[0],
                min=mas[0];
        for (int i = 1; i < mas.length; i++) {
            if(mas[i] > max)
                max = mas[i];
            if(mas[i] < min)
                min = mas[i];
        }
        return max-min;
    }
    // Part 3
    public static boolean isAvgWhole(int[] mas){
        int res = 0;
        for (int i = 0; i < mas.length; i++) {
            res+=mas[i];
        }
        if(res%mas.length==0)
            return true;
        return false;
    }
    // Part 4
    public static int[] cumulativeSum(int[] mas){
        int[] res = new int[mas.length];
        res[0] = mas[0];
        for (int i = 1; i < mas.length; i++) {
            res[i] = res[i-1] + mas[i];
        }
        return res;
    }
    // Part 5
    public static int getDecimalPlaces(String str){
        if(str.contains("."))
            return str.length()-str.indexOf(".");
        return 0;
    }
    // Part 6
    public static int fibonacci(int n){
        switch (n){
            case 0: return 0;
            case 1: return 1;
            case 2: return 2;
            default: {
                int cur=2,
                        prev=1;
                for (int i = 3; i <= n; i++) {
                    cur += prev;
                    prev = cur - prev;
                }
                return cur;
            }
        }
    }
    // Part 7
    public static boolean isValid(String str){
        if(str.length() == 5){
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) > '9' && str.charAt(i) < '0')
                    return false;
            }
            return true;
        }
        return false;
    }
    // Part 8
    public static boolean isStrangePair(String str1, String str2){
        if(str2.indexOf(str1.charAt(0)) == (str2.length()-1)
                && str2.indexOf(str1.charAt(str1.length()-1)) == 0){
            return true;
        }
        return false;
    }
    // Part 9
    public static boolean isPrefix(String word, String pre){
        if(word.startsWith(pre.substring(0,pre.length()-2)))
            return true;
        return false;
    }
    public static boolean isSuffix(String word, String suf){
        if(word.endsWith(suf.substring(1)))
            return true;
        return false;
    }
    // Part 10
    public static int boxSeq(int step){
        int counter = 0;
        for (int i = 1; i <= step; i++) {
            if(i % 2 == 1)
                counter+=3;
            else counter++;
        }
        return counter;
    }
}
