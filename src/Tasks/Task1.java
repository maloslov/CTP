package Tasks;

public class Task1 {
    // Part 1
    public static int remainder(int a, int b){
        return a % b;
    }
    // Part 2 - triangle's square
    public static double sriArea(double length, double height){
        return height * length / 2;
    }
    // Part 3 - how many legs do animals have
    public static int animalLegs(int chickens, int cows, int pigs){
        return 4*(cows + pigs + chickens/2);
    }
    // Part 4
    public static boolean profitableGamble(double prob, double prize, double pay){
        if(prob*prize>pay)
            return true;

        return false;
    }
    // Part 5
    public static String operation(int N, int a, int b){
        if(N== a+b)
            return "added";
        else if(N== a-b)
            return "substracted";
        else if(N==a*b)
            return "multiplied";
        else if(b != 0 && N == a/b)
            return "divided";
        return "none";
    }
    // Part 6 - char to int
    public static int ctoa(char c){
        return (int)c;
    }
    // Part 7 - sum from 1 to n
    public static int addUpTo(int digit){
        int res=0;
        for (int i = 1; i <= digit; i++)
            res+=i;

        return res;
    }
    // Part 8 - count triangle's third edge
    public static int nextEdge(int a, int b) {
        return a + b - 1;
    }
    // Part 9 - sum of elements
    public static int sumOfCubes(int[] mas){
        int res = 0;
        for (int i = 0; i < mas.length; i++)
            res+=mas[i];

        return res;
    }
    // Part 10
    public static boolean abcmath(int a, int b, int c){
        int res = a;
        for (int i = 0; i <= b; i++)
            res*=2;

        if (res % c == 0)
            return true;
        return false;
    }
}
