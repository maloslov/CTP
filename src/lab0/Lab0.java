package lab0;

public class Lab0 {
    //Part 1 - Primes
    private static boolean isPrime(int n){
        for (int i = 2; i < n; i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }
    public static void allPrimes(){
        for (int i = 2; i < 100; i++) {
            if(isPrime(i))
                System.out.print(i+" ");
        }
        System.out.println();
    }
    //Part 2 - Palindromes
    private static String reverseString(String s){
        String r="";
        for (int i = s.length()-1; i >= 0; i--) {
            r += s.charAt(i);
        }
        return r;
    }
    private static void comparePalindromes(String s, String r){
        if(r.equals(s)) System.out.println(s + " equals to "+ r +". It's a palindrome.");
        else System.out.println(s + " doesn't equal to "+ r +". It's not a palindrome.");
    }
    public static void arePalindromes(String[] s){
        for (int i = 0; i < s.length; i++) {
            String r = reverseString(s[i]);
            comparePalindromes(s[i],r);
        }
    }
    public static void isPalindrome(String s){
        String r=reverseString(s);
        comparePalindromes(s,r);

    }
}
