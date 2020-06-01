package Tasks;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Task5 {
    //part 1
    public static int[] encrypt(String str){
        int[] res = new int[str.length()];
        if(!str.isEmpty()){
            res[0] = str.charAt(0);
            for (int i = 0; i < str.length(); i++) {
                res[i] = str.charAt(i)-res[0];
            }
        }
        return res;
    }
    public static String decrypt(int[] arr){
        String res = "";
        res += (char)arr[0];
        for (int i = 0; i < arr.length; i++) {
            res += (char)arr[i];
        }
        return res;
    }
    //part 2
    public static boolean canMove(String name, String a, String b){
        int dColumn = Math.abs((a.charAt(0)-'0') - (b.charAt(0)-'0')),
                dRow = Math.abs((1+b.charAt(1)-'A') - (1+a.charAt(1)-'A'));
        boolean res = false;
        switch (name) {
            case "Pawn": {
                res = (dRow == 0 || dColumn <= 1 || a.charAt(1) == '2');
                break;
            }
            case "Knight": {
                res = (dColumn == 2 && dRow == 1)||(dColumn == 1 && dRow == 2);
                break;
            }
            case "Bishop": {
                res = (dColumn == dRow);
                break;
            }
            case "Rook": {
                res = (dColumn == 0 || dRow == 0);
                break;
            }
            case "Queen": {
                res = (dColumn == 0 || dColumn == dRow || dRow == 0);
                break;
            }
            case "King": {
                res = (dRow <= 1 && dColumn <= 1);
                break;
            }
        }
        return res;
    }
    //part 3
    public static boolean canComplete(String a, String b){
        String sub = b;
        int i = 0,
                j = 0,
                n = 0;
        while (i < a.length() && j < sub.length()){
            if(a.charAt(i) == sub.charAt(j)){
                i++;
            }
            j++;
        }
        return (i == a.length());
    }
    //part 4
    public static int sumDigProd(int ...num){
        int res = 0,
                buf = 0,
                buf2 = 1,
                n = 10;
        for (int i = 0; i < num.length; i++) {
            buf += num[i];
        }
        do {
            res = buf;
            while(res > n){
                buf *= res % n;
                res /= 10;
            }
        } while(res > 9);
        return res;
    }
    //part 5
    public static String[] sameVowelGroup(String[] str){
        String vowels = "AEYUIOaeyuio",
                abc = "",
                originWord = str[0],
                res = originWord;
        boolean flag = false;
        for (int i = 0; i < originWord.length(); i++) {
            if(vowels.indexOf(originWord.charAt(i)) != -1){
                abc += originWord.charAt(i);
            }
        }
        for (int i = 1; i < str.length; i++) {
            for (int j = 0; j < str[i].length(); j++) {
                if(vowels.indexOf(str[i].charAt(j)) != -1){
                    if(abc.indexOf(str[i].charAt(j)) != -1)
                        flag = true;
                    else flag = false;
                }
            }
            if(flag){
                res += " " + str[i];
                flag = false;
            }
        }
        return res.split(" ");
    }
    //part 6
    public static boolean validateCard(long n){
        String str = String.valueOf(Long.reverse(n));
        int sum = 0,
                check = (int) n % 10,
                s = 0;
        if (str.length() > 13 && str.length() < 20){
            for (int i = 1; i < str.length(); i++){
                s = 2 * (str.charAt(i)-'0');
                if(s > 9)
                    s = (s % 10) + (s / 10);
                sum += s;
            }
        }
        return Math.abs(10-(sum%10)) == check;
    }
    //part 7
    public static String numToEng(int n){
        boolean flag = false;
        String str = String.valueOf(Math.abs(n)),
                res = "";
        int i = str.length();
        if (n > 0 && n < 1000){
            do {
            i = str.length();
            switch (str.length()){
                case 1: {
                    switch (str.charAt(0)) {
                        case '1': {
                            res += " one";
                            break;
                        }
                        case '2': {
                            res += " two";
                            break;
                        }
                        case '3': {
                            res += " three";
                            break;
                        }
                        case '4': {
                            res += " four";
                            break;
                        }
                        case '5': {
                            res += " five";
                            break;
                        }
                        case '6': {
                            res += " six";
                            break;
                        }
                        case '7': {
                            res += " seven";
                            break;
                        }
                        case '8': {
                            res += " eight";
                            break;
                        }
                        case '9': {
                            res += " nine";
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    switch (str.charAt(0)){
                        case '0': {
                            break;
                        }
                        case '1': {
                            switch (str.charAt(1)){
                                case '0': {
                                    res += " ten";
                                    flag = true;
                                    break;
                                }
                                case '1': {
                                    res += " eleven";
                                    flag = true;
                                    break;
                                }
                                case '2': {
                                    res += " twelve";
                                    flag = true;
                                    break;
                                }
                                case '3': {
                                    res += " thirteen";
                                    flag = true;
                                    break;
                                }
                                case '4': {
                                    res += " fourteen";
                                    flag = true;
                                    break;
                                }
                                case '5': {
                                    res += " fifteen";
                                    flag = true;
                                    break;
                                }
                                case '6': {
                                    res += " sixteen";
                                    flag = true;
                                    break;
                                }
                                case '7': {
                                    res += " seventeen";
                                    flag = true;
                                    break;
                                }
                                case '8': {
                                    res += " eighteen";
                                    flag = true;
                                    break;
                                }
                                case '9': {
                                    res += " nineteen";
                                    flag = true;
                                    break;
                                }
                            }
                            break;
                        }
                        case '2': {
                            res += " twenty";
                            break;
                        }
                        case '3': {
                            res += " thirty";
                            break;
                        }
                        case '4': {
                            res += " fourty";
                            break;
                        }
                        case '5': {
                            res += " fifty";
                            break;
                        }
                        case '6': {
                            res += " sixty";
                            break;
                        }
                        case '7': {
                            res += " seventy";
                            break;
                        }
                        case '8': {
                            res += " eighty";
                            break;
                        }
                        case '9': {
                            res += " ninety";
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    switch (str.charAt(0)){
                        case '0': {
                            break;
                        }
                        case '1': {
                            res += " one hundred";
                            break;
                        }
                        case '2': {
                            res += " two hundred";
                            break;
                        }
                        case '3': {
                            res += " three hundred";
                            break;
                        }
                        case '4': {
                            res += " four hundred";
                            break;
                        }
                        case '5': {
                            res += " five hundred";
                            break;
                        }
                        case '6': {
                            res += " six hundred";
                            break;
                        }
                        case '7': {
                            res += " seven hundred";
                            break;
                        }
                        case '8': {
                            res += " eight hundred";
                            break;
                        }
                        case '9': {
                            res += " nine hundred";
                            break;
                        }
                    }
                    break;
                }
            }
            str = str.substring(1);
        } while(i >= 0 && !flag);
        } else if (n==0)
            res = "zero";
        else res = "Incorrect";
        return res.trim();
    }
    public static String numToRus(int n){
        boolean flag = false;
        int i;
        String str = String.valueOf(Math.abs(n)),
                res = "";
        if (n > 0 && n < 1000) {
            do {
                i = str.length();
                switch (str.length()){
                    case 1: {
                    switch (str.charAt(0)) {
                        case '1': {
                            res += " один";
                            break;
                        }
                        case '2': {
                            res += " два";
                            break;
                        }
                        case '3': {
                            res += " три";
                            break;
                        }
                        case '4': {
                            res += " четыре";
                            break;
                        }
                        case '5': {
                            res += " пять";
                            break;
                        }
                        case '6': {
                            res += " шесть";
                            break;
                        }
                        case '7': {
                            res += " семь";
                            break;
                        }
                        case '8': {
                            res += " восемь";
                            break;
                        }
                        case '9': {
                            res += " девять";
                            break;
                        }
                    }
                    break;
                }
                    case 2: {
                    switch (str.charAt(0)){
                        case '0': {
                            break;
                        }
                        case '1': {
                            switch (str.charAt(1)){
                                case '0': {
                                    res += " десять";
                                    flag = true;
                                    break;
                                }
                                case '1': {
                                    res += " одиннадцать";
                                    flag = true;
                                    break;
                                }
                                case '2': {
                                    res += " двенадцать";
                                    flag = true;
                                    break;
                                }
                                case '3': {
                                    res += " тринадцать";
                                    flag = true;
                                    break;
                                }
                                case '4': {
                                    res += " четырнадцать";
                                    flag = true;
                                    break;
                                }
                                case '5': {
                                    res += " пятнадцать";
                                    flag = true;
                                    break;
                                }
                                case '6': {
                                    res += " шестнадцать";
                                    flag = true;
                                    break;
                                }
                                case '7': {
                                    res += " семнадцать";
                                    flag = true;
                                    break;
                                }
                                case '8': {
                                    res += " восемнадцать";
                                    flag = true;
                                    break;
                                }
                                case '9': {
                                    res += " девятнадцать";
                                    flag = true;
                                    break;
                                }
                            }
                            break;
                        }
                        case '2': {
                            res += " двадцать";
                            break;
                        }
                        case '3': {
                            res += " тридцать";
                            break;
                        }
                        case '4': {
                            res += " сорок";
                            break;
                        }
                        case '5': {
                            res += " пятьдесят";
                            break;
                        }
                        case '6': {
                            res += " шестьдесят";
                            break;
                        }
                        case '7': {
                            res += " семдесят";
                            break;
                        }
                        case '8': {
                            res += " восемьдесят";
                            break;
                        }
                        case '9': {
                            res += " девяносто";
                            break;
                        }
                    }
                    break;
                }
                    case 3: {
                    switch (str.charAt(0)){
                        case '0': {
                            break;
                        }
                        case '1': {
                            res += " сто";
                            break;
                        }
                        case '2': {
                            res += " двести";
                            break;
                        }
                        case '3': {
                            res += " триста";
                            break;
                        }
                        case '4': {
                            res += " четыреста";
                            break;
                        }
                        case '5': {
                            res += " пятьсот";
                            break;
                        }
                        case '6': {
                            res += " шестьсот";
                            break;
                        }
                        case '7': {
                            res += " семьсот";
                            break;
                        }
                        case '8': {
                            res += " восемьсот";
                            break;
                        }
                        case '9': {
                            res += " девятьсот";
                            break;
                        }
                    }
                    break;
                }
            }
            str = str.substring(1);
            } while(i > 0 && !flag);
        } else if (n==0)
            res = "ноль";
        else res = "Неверно";
        return res.trim();
    }
    //part 8
    public static String getSHA256Hash(String str) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(str.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }
    //part 9
    public static String correctTitle(String str){
        String ch = "",
                res = "";
        String[] txt = str.toLowerCase().split(" "),
                abc = {"and", "the", "of", "in"};
        for (int i = 0; i < txt.length; i++) {
            if(!(abc[0].equals(txt[i]) || abc[1].equals(txt[i]) ||
                    abc[2].equals(txt[i]) || abc[3].equals(txt[i]))){
                ch += txt[i].charAt(0);
                res += ch.toUpperCase() + txt[i].substring(1) + " ";
                ch = "";
            } else {
                res += txt[i] + " ";
            }
        }
        return res.trim();
    }
    //part 10
    public static String hexLattice(int n){
        int count = 1,
                i = 1,
                buf;
        String res = "";
        while(n > count){
            i++;
            count = 1 + 3 * i * (i-1);
        }
        if(n != count)
            res = "Invalid";
        else{
            buf = 2*i-1;
            //upper half
            for (int j = i; j < buf; j++) {
                for (int k = 0; k < buf-j; k++)
                    res += " ";
                for (int k = 0; k < j; k++) 
                    res += "o ";
                res += "\n";
            }
            //bottom half
            for (int j = buf; j >= i ; j--) {
                for (int k = 0; k < buf-j; k++)
                    res += " ";
                for(int k = j; k > 0; k--)
                    res += "o ";
                res += "\n";
            }
        }
        return res;
    }
}
