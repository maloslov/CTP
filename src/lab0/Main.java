package lab0;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        Lab0.allPrimes();
        Lab0.arePalindromes(args);
        while (true) {
            String a = read.next();
            if(a.equals("0"))
                break;
            Lab0.isPalindrome(a);
        };
        
    }
}
