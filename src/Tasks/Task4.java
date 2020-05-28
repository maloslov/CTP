package Tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task4 {
    // Part 1
    public static String formatEssay(int n, int k, String str){
        String line = "",
                res = "";
        if (n > 0 && n < 101 && k > 0 && k < 81){
            String[] words = str.split(" ");
            for (int i = 0; i < n; i++) {
                if (line.length() + words[i].length() > k){
                    res = res.trim() + "\r\n" + words[i] + " ";
                    line = words[i];
                } else {
                    res += words[i] + " ";
                    line += words[i];
                }
            }
        } else res = "Wrong arguments";
        return res.trim();
    }
    // Part 2
    public static String[] split(String str){
        String s = str;
        List<String> res = new ArrayList<>();
        int count = 0,
                i = 0;
        while (s.length() > 0){
            if(s.charAt(i) == '(')
                count++;
            else count--;
            if(count == 0){
                res.add(s.substring(0, i+1));
                s = s.substring(i+1);
                i=-1;
            }
            i++;
        }
        return res.toArray(new String[0]);
    }
    // Part 3
    public static String toCamelCase(String str){
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '_')
                i++;
            res += str.charAt(i);
        }
        return res;
    }
    public static String toSnakeCase(String str){
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                res += '_';
            res += str.charAt(i);
        }
        return res;
    }
    // Part 4
    public static String overTime(double[] arr){
        String out = "";
        if(arr.length == 4){
            double res = 0;
            if(arr[1] <= 17){
                res = arr[2]*(arr[1]-arr[0]);
            } else {
                res = arr[2]*( (arr[1]-(arr[0]+arr[1]-17)) +   //work time
                        (arr[1]-17)*arr[3] );   //work overtime
            }
            out = "$"+String.format("%.2f",res);
        } else out = "Wrong argument";
        return out;
    }
    // Part 5
    public static String countBMI(String weight, String height){
        double w = Double.parseDouble(weight.split(" ")[0]),
                h = Double.parseDouble(height.split(" ")[0]);
        if (weight.split(" ")[1].equals("pounds"))
            w *= 0.45;
        if(weight.split(" ")[1].equals("inches"))
            h *= 0.0254;

        double bmi = w / (h * h);
        String[] msg = {" Underweight"," Normal weight"," Overweight"};
        String res = String.format("%.1f", bmi);

        if(bmi < 18.5)
            res += msg[0];
        else if(bmi > 25)
            res += msg[2];
        else res += msg[1];

        return res;
    }
    // Part 6
    public static int bugger(int num){
        int i = 0,
                n = num,
                dec = 1;
        while(n > 9){
            while(n > 0){
                dec *= n%10;
                n /= 10;
            }
            n = dec;
            i++;
        }
        return i;
    }
    // Part 7
    public static String toStarShorthand(String str){
        String res = "";
        char ch = str.charAt(0);
        res += str.charAt(0);
        int count = 1;
        if (str.length() > 1){
            for (int i = 1; i < str.length(); i++) {
                if(str.charAt(i) == ch){
                    res += "*";
                    count++;
                } else {
                    if(count>1){
                        res += count;
                        count = 1;
                    }
                    ch = str.charAt(i);
                    res += str.charAt(i);
                }
            }
        } else res = str;

        return res;
    }
    // Part 8
    public static boolean doesRhyme(String str1, String str2){
        String word1 = str1.substring(str1.lastIndexOf(' ')+1),
                word2 = str2.substring(str2.lastIndexOf(' ')+1),
                abc = "AEYUIOaeyuio",
                res1 = "",
                res2 = "";
        int i = 0;
        while(i < word1.length() || i < word2.length()){
            if (abc.indexOf(word1.charAt(i)) != -1)
                res1 += word1.charAt(i);
            if (abc.indexOf(word2.charAt(i)) != -1)
                res2 += word2.charAt(i);
            i++;
        }
        return res1.equals(res2);
    }
    // Part 9
    public static boolean trouble(int a, int b){
        String x = String.valueOf(a),
                y = String.valueOf(b),
                ch = "";
        boolean res = false;
        for (int i = 0; i < x.length()-2; i++) {
            if(x.charAt(i) == x.charAt(i+1) && x.charAt(i) == x.charAt(i+2))
                ch += x.charAt(i);
        }
        for (int i = 0; i < y.length()-1; i++) {
            if(y.charAt(i) == y.charAt(i+1) && ch.indexOf(y.charAt(i)) != -1)
                res = true;
        }
        return res;
    }
    // Part 10
    public static int countUniqueBooks(String str, char end){
        int res = 0;
        if(str.length() > 2){
            boolean flag = false;
            int len = 0;
            String word = "";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == end) {
                    if (!flag ){
                        flag = true;
                        len = 0;
                    } else {
                        if (len > 0){
                            res += len;
                            word = "";
                            len = 0;
                        }
                        flag = false;
                    }
                } else {
                    if (flag && word.indexOf(str.charAt(i)) == -1){
                        len++;
                        word += str.charAt(i);
                    }
                }
            }
        }
        return res;
    }
}
