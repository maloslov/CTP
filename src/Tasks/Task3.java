package Tasks;

public class Task3 {
    // Part 1
    public static int solution(int a, int b, int c){
        int d = b*b - 4*a*c;
        int answer = -1;
        if(d < 0){
          answer = 0;
        } else if(d == 0){
            answer = 1;
        } else {
            answer = 2;
        }
        return answer;
    }
    // Part 2
    public static int findZip(String str) {
        int index = -1;
        boolean flag = false;
        if (str.length() > 5){
            for (int i = 0; i < str.length() - 2; i++) {
                if (str.charAt(i)=='z' &&
                        str.charAt(i+1)=='i' &&
                        str.charAt(i+2)=='p'){
                    if (flag) {
                        index = i;
                        break;
                    }
                    else flag = true;
                    }
                }
            }
        return index;
    }
    // Part 3
    public static boolean checkPerfect(int num){
        int counter = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) counter+=i;
        }
        return (counter == num);
    }
    // Part 4
    public static String flipEndChars(String str){
        String newStr = "";
        if(str.length() > 1 && !(str.charAt(0) == str.charAt(str.length()-1))){
            for (int i = 0; i < str.length(); i++) {
                if (i==0) newStr += str.charAt(str.length()-1);
                else if (i == str.length()-1) newStr += str.charAt(0);
                else newStr += str.charAt(i);
            }
        } else if (str.length()>2)
            newStr = "Two's a pair.";
        else newStr = "Incompatible.";
        return newStr;
    }
    // Part 5
    public static boolean isValidHexCode(String str){
        String abc = "abcdefABCDEF";
        boolean flag = false;
        int count = 1;
        if(str.length() == 7 && str.charAt(0) == '#') {
                for (int i = 1; i < str.length(); i++) {
                if(abc.indexOf(str.charAt(i)) != -1 || Character.isDigit(str.charAt(i)))
                    count++;
                }
        } else count = -1;
        return (count == str.length());
    }
    // Part 6
    public static boolean same(int[] arr1, int[] arr2){
        int buf1 = 0,
                buf2 = 0,
                i = 0;
        while(i < arr1.length-1 || i < arr2.length-1){
            if(i < arr1.length-1 && arr1[i] != arr1[i+1])
                buf1++;
            if(i < arr2.length-1 && arr2[i] != arr2[i+1])
                buf2++;
            i++;
        }
        return buf1==buf2;
    }
    // Part 7
    public static boolean isKaprekar(int n){
        String nsqr = String.valueOf(n*n);
        int nnew = -1;
        boolean flag = false;
        if (n==0 || n==1)
            flag=true;
        else if (n>3) {
            nnew = Integer.parseInt(nsqr.substring(0, nsqr.length() / 2)) +
                    Integer.parseInt(nsqr.substring(nsqr.length() / 2));
            flag = (nnew==n);
        }
        return flag;
    }
    // Part 8
    public static String longestZero(String str){
        String res = "",
                buf = "";
        if(str.indexOf('0') != -1 && str.length()>0){
            for (int i = 0; i < str.length()-1; i++) {
                if (str.charAt(i) == '0')
                    buf += "0";
                else {
                    if(buf.length() > res.length())
                        res = buf;
                    buf = "";
                }
            }
        }
        return res;
    }
    // Part 9
    private static boolean isPrime(int nu){
        boolean flag = true;
        for (int i = 2; i < nu; i++) {
            if(nu%i==0)
                flag = false;
        }
        return flag;
    }
    public static int nextPrime(int n){
        int res = n;
        boolean flag = isPrime(res);
        while(!(flag)){
            res++;
            flag = isPrime(res);
        }
        return res;
    }
    // Part 10
    public static boolean isRightTriangle(int a, int b, int c){
        boolean flag = false;
        if(a*a+b*b==c*c || a*a+c*c==b*b || b*b+c*c==a*a)
            flag = true;
        return flag;
    }
    //test
    public static void main(String[] args){
        System.out.println("01-> " + solution(1,0,-1)); //2
        System.out.println("02-> " + findZip("all zip files are zipped")); //18
        System.out.println("03-> " + checkPerfect(28)); //true
        System.out.println("04-> " + flipEndChars("Ada")); //adA
        System.out.println("05-> " + isValidHexCode("#5D5C5C")); //true
        System.out.println("06-> " + same(new int[]{1,3,4,4,4},new int[]{2,5,7})); //true
        System.out.println("07-> " + isKaprekar(5)); //false
        System.out.println("08-> " + longestZero("100100100")); //00
        System.out.println("09-> " + nextPrime(12)); //13
        System.out.println("10-> " + isRightTriangle(3,4,5)); //true
    }
}
