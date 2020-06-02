package Tasks;

import java.util.Arrays;

public class Task6 {
    //part 1
    public static int bell(int n) {
        int res = 0;
        int[][] arr = new int[n + 1][n + 1];
        arr[0][0] = 1;
        arr[n][n] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i - 1][j - 1] + j * arr[i - 1][j];
            }
        }
        for (int i = 0; i <= n; i++) {
            res += arr[n][i];
        }
        return res;
    }
    //part 2
    public static String translateWord(String word){
        String res = word;
        if (res.matches("[aeyuioAEYUIO]")) {
            res += "yay";
        }
        else {
            String ch = res.split("[aeyuioAEYUIO]")[0];
            res = res.replaceFirst(ch,"") + ch + "ay";
        }
        return res;
    }
    public static String translateSentence(String sent){
        String abc = "aeiouyAEIOUY";
        char end = sent.charAt(sent.length()-1);
        String[] newSent = sent.substring(0, sent.length()-1).split(" ");
        sent = "";
        for (int i = 0 ; i < newSent.length; i++) {
            for (int j = 0; j < abc.length(); j++) {
                if (abc.indexOf(newSent[i].charAt(j)) != -1) {
                    sent += newSent[i] + "yay ";
                    break;
                }
                else {
                    String word = newSent[i].split("[aeiyouAEIYOU]")[0];
                    sent += newSent[i].replaceFirst(word, "") + word + "ay ";
                    break;
                }
            }
        }
        return (sent.trim() + end);
    }
    //part 3
    public static boolean validColor(String rgb){
        int ind = rgb.indexOf('(');
        boolean res = false;
        double[] n = new double[ind];
        String[] values = rgb.substring(ind + 1, rgb.indexOf(')')).split(",");
        for (int i = 0; i < 3; i++) {
            n[i] = Double.parseDouble(values[i]);
            res = (n[i] >= 0 && n[i] <= 255 && values.length == 3);
        }
        return res;
    }
    //part 4
    public static String stripUrlParams(String url, String ...paramsToStrip){
        String str = "",
                res = "";
        if (url.indexOf("?") == -1)
            return url;
        else {
            str = url.substring(url.indexOf("?") + 1);
            url = url.substring(0, url.indexOf("?") + 1);
        }
        char[] params = str.toCharArray();
        for (char param : params) {
            if (Character.isLetter(param))
                if (!(res.contains(String.valueOf(param)))) {
                    if (paramsToStrip.length > 0) {
                        for (String arg : paramsToStrip) {
                            if (!(arg.contains(String.valueOf(param))))
                                res += str.substring(str.lastIndexOf(param), str.lastIndexOf(param) + 3) + "&";
                        }
                    }
                    else
                        res += str.substring(str.lastIndexOf(param), str.lastIndexOf(param) + 3) + "&";
                }
        }
        return (url + res.substring(0, res.length()-1));
    }
    //part 5
    public static String getHashTags( String str){
        String[] hash = new String[]{" "," "," "};
        String [] arr = str.split(" ");
        String buf = "";
        for (int i = 0; i < arr.length; i++){
            if (arr[i].length()>hash[0].length())
                hash[0]= arr[i];
            else if (arr[i].length()>hash[1].length())
                hash[1] = arr[i];
            else if (arr[i].length()>hash[2].length())
                hash[2] = arr[i];
        }
        for (int i = 0; i < hash.length; i++){
            if (hash[i]==" ")
                hash[i] = " ";
            else
                hash[i] = "#" + hash[i].toLowerCase();
        }
        return Arrays.toString(hash);
    }
    //part 6
    public static int ulam(int n){
        int[] res = new int[n];
        res[0]=1;
        res[1]=2;
        int len=2,
                next=3;
        while (next < Integer.MAX_VALUE && len < n){
            int count = 0;
            for (int i = 0;  i < len; i++){
                for (int j = len-1; j > i; j--){
                    if (res[i] + res[j] == next && res[i] != res[j])
                        count++;
                    else if (count > 1)
                        break;
                }
                if (count > 1)
                    break;
            }
            if (count == 1) {
                res[len] = next;
                len++;
            }
            next++;
        }
        return res[n-1];
    }
    //part 7
    public static String longestNonrepeatingSubstring(String str){
        char[] arr = str.toCharArray();
        String sub = "";
        str="";
        for(int i = 0 ; i < arr.length; i++){
            if (!str.contains(String.valueOf(arr[i])))
                str += arr[i];
            else{
                if (str.length() > sub.length())
                    sub = str;
                str = "" + arr[i];
            }
        }
        if (str.length() > sub.length())
            sub = str;
        return sub;
    }
    //part 8
    public static String convertToRoman(int n){
        String res = "";
        if (n < 1 || n > 3999)
            res = "Too big number";
        else {
            while (n >= 1000) {
                res += "M";
                n -= 1000;
            }
            while (n >= 900) {
                res += "CM";
                n -= 900;
            }
            while (n >= 500) {
                res += "D";
                n -= 500;
            }
            while (n >= 400) {
                res += "CD";
                n -= 400;
            }
            while (n >= 100) {
                res += "C";
                n -= 100;
            }
            while (n >= 90) {
                res += "XC";
                n -= 90;
            }
            while (n >= 50) {
                res += "L";
                n -= 50;
            }
            while (n >= 40) {
                res += "XL";
                n -= 40;
            }
            while (n >= 10) {
                res += "X";
                n -= 10;
            }
            while (n >= 9) {
                res += "IX";
                n -= 9;
            }
            while (n >= 5) {
                res += "V";
                n -= 5;
            }
            while (n >= 4) {
                res += "IV";
                n -= 4;
            }
            while (n >= 1) {
                res += "I";
                n -= 1;
            }

        }
        return res;
    }
    //part 9
    public static boolean formula(String form){
        boolean res = false;
        int answer = 0,
                expectedResult = 0,
                i = 1;
        String[] arr = form.split(" ");
        if (!Character.isDigit(arr[0].charAt(0)))
            res = false;
        else answer = Integer.parseInt(arr[0]);
        while (!arr[i].equals("=")) {
            if (arr[i].equals("+")){
                answer += Integer.parseInt(arr[i + 1]);
            }
            if (arr[i].equals("-")){
                answer -= Integer.parseInt(arr[i + 1]);
            }
            if (arr[i].equals("*")){
                answer *= Integer.parseInt(arr[i + 1]);
            }
            if (arr[i].equals("/")){
                answer /= Integer.parseInt(arr[i + 1]);
            }
            i += 2;
        }
        i = form.indexOf('=');
        String check = form.substring(i + 1, form.length());
        if (check.contains("="))
            res = false;
        else expectedResult = Integer.parseInt(arr[arr.length - 1]);
        if (answer == expectedResult)
            res = true;
        else res = false;
        return res;
    }
    //part 10
    public static boolean palindromeDescendant(int n){
        boolean res = false;
        int buf = 0;
        String str = " ";
        StringBuffer buf1 = new StringBuffer(n),
                buf2 = new StringBuffer(n);
        if (buf1.length() % 2 != 0)
            res = false;
        else{
            while (!res){
                if(buf1 != buf1.reverse()){
                    for(int i=0; i < buf1.length(); i += 2){
                        int a = Integer.parseInt(String.valueOf(buf1.charAt(i)));
                        int b = Integer.parseInt(String.valueOf(buf1.charAt(i+1)));
                        buf2.append(a + b);
                    }
                    str = buf2.toString();
                }
                else
                    res = true;
            }
        }
        return res;
    }
}
