import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        System.out.print("Test cases: ");
        long test = input.nextLong();
//        for (int i = 0; i < test; i++) {
//            long myInput = input.nextLong();
//
//        }
        sum(5);
    }
    //sum of self powers 1^1 + 2^2 + 3^3 + 4^4.......N^n
    public static String count(long num) {
        BigInteger modulus = BigInteger.TEN.pow(10);
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= num; i++)
            sum = sum.add(BigInteger.valueOf(i).modPow(BigInteger.valueOf(i), modulus));
        return sum.mod(modulus).toString();
    }

    public static void digitalSum() {
        int n,temp;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int count=0;
        int sum=0;
        for(int i=10;i<=n;i++){
            temp = i;
            while(temp>0){
                sum+= factorial(temp%10);
                temp = temp/10;
            }
            if(sum%i==0)
                count+=i;
            sum=0;
        }
        System.out.println(count);
    }

    static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);

    }
    public static void sumOfNthPower() {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        long sum = 0;

        // loop through
        for (int i = 2; i < 1000000; i++) {
            long temp = i;
            long sum1 = 0;

            while (temp > 0) {
                int a = (int)(temp % 10);
                sum1 += (long)Math.pow(a, num);
                temp = temp / 10;
            }

            if (sum1 == i) {
                sum += sum1;
            }

        }

        System.out.println(sum);
        input.close();
    }

    public static long smallestMultiple(long n) {
        long result = 1;
        for (int i = 1; i <= n ; i++) {
            if (isItPrime(i) && (i*result)%i == 0) {
                result *= i;
            } else {
                if (result%i != 0) {
                    result *= divByPrime(i);
                }
            }
        }
        return  result;
    }

    public static  boolean isItPrime(int num) {
        if(num < 2 || num > 3) {
            return (num % 2 != 0 && num % 3 != 0);
        }
        return true;
    }

    public  static int divByPrime(int num) {
        while (!isPrime(num)) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 3;
            }else if (num % 7 == 0) {
                num /=7;
            }
        }
        return num;
    }


    public static void largestPalindromeProduct(int p) {
        int max = Integer.MIN_VALUE; //minimum value holder

        for (int i = 101; i <  1000 ; i++) {
            for (int j = 121; j < 1000 ; j += (i%11 == 0) ? 1: 11) {
                int num = i*j;
                boolean val = isPalindrome(num);

                if(val) {
                    if (num < p) {
                        max = Math.max(max, num);
                    }
                }
            }
            System.out.println(max);
        }
    }

    public  static  boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int start = 0, end = str.length() - 1;

        while (start <= end && str.charAt(start) == str.charAt(end)) {
            start++;
            end--;
        }

        if(end < start) {
            return true;
        }
        return false;
    }
    public static  void gebFibNos(){
        Scanner input = new Scanner(System.in);
        int checkVal = input.nextInt();
        int firstTerm = 1, secondTerm = 1;
        int counter = 0;
        int stopper = 0;

        do {
            int nextTerm = firstTerm + secondTerm;
            String numString = Integer.toString(firstTerm);
            counter++;
            if(numString.length() == checkVal) {
                stopper++;
            }
            // compute the next term
            firstTerm = secondTerm;
            secondTerm = nextTerm;

        } while (stopper == 0);
        System.out.println(counter);

    }
    public static void findSumOfString(String number) {
        int result = 0;
        // loop through the string
        for (int i = 0; i< number.length(); i++) {
            result += Character.getNumericValue(number.charAt(i));
        }
        System.out.println(result);
    }
    public static void sum(int count) {
        Scanner num = new Scanner(System.in);
        int sum = 0 ;
        for (int i =1; i <= count; i++) {
            float number = num.nextFloat();
            sum += number;
        }
        System.out.println(sum);
    }
    public static void genPrimeNo(int number) {

        int counter = 1;
        int candidate = 0;
        do {
            if (isPrime(counter)) {
                System.out.println(counter);
                candidate ++;
            }
            counter ++;
        } while (candidate < number);
    }

    public static void sumOfPrime(int number) {
        int counter = 1;
        int sum = 0;
        do {
            if (isPrime(counter)) {
                sum += counter;
            }
            counter ++;
        } while (counter <= number);
        System.out.println(sum);
    }
    public static void printNPrimeNo(int number) {
        int counter = 1;
        int candidate = 0;
        int myNo = 0;
        do {
            if (isPrime(counter)) {
                myNo = counter;
                candidate ++;
            }
            counter ++;
        } while (candidate < number);
        System.out.println(myNo);
    }


    public  static boolean isPrime(int n) {
        if(n == 1) {
            return false;
        }

        for(int i=2;i<n;i++) {
            if(n % i == 0) {

                return false;
            }
        }

        return  true;
    }

    public static void squaresDiffrence(int n) {
        int sumOfSquares = 0;
        int sum = 0;
        int power2 = 0;
        int diff = 0;
        for (int i = 1; i <= n ; i++) {
            sumOfSquares += (i*i);
            sum += i;
        }
        power2 = (int) Math.pow(sum, 2);
        diff = (power2 - sumOfSquares);
        System.out.println(Math.abs(diff));
    }

    public static void fibonacci() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextInt();
            long num1 = 1;
            long num2  = 2;
            long num3 = 0;
            long sum = 2;
            for (int i = 1; i < n-2; i++) {

                num3 = num1 + num2;
                if (num3 % 2 == 0 && num3 < n) {
                    sum += num3;
                }
                num1 = num2;
                num2 = num3;
            }
            System.out.println(sum);
        }
    }

    public static  void largestPallindrome() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextInt();
            int counter = 1;
            int largest = 0;
            int num1 = 0;
            int num2 = 0;
            int product = 0;
            int myProduct = 0;
            int reversed = 0;
            int myReversed = 0;
            while (counter < n ) {
                num1 = counter;

                for (int i = 1; i < n ; i++) {
                    num2 = i;
                    product = num1 * num2;
                    myProduct = product;
                    System.out.println(num1 + "*" + num2 + "=" +product);

                    while (product != 0) {
                        int remainder = product % 10;
                        reversed = (reversed * 10) + remainder;
                        product /= 10;
                        myReversed = reversed;
                    }

                    if (myReversed == myProduct) {
                        largest = myProduct;
                    }
                    reversed = 0;

                }
                counter ++;

            }
            System.out.println(largest);

        }
    }


    public static void largestFactor() {
        int number = 210;

        for(int i=2; i<(number/i); i++){      // no factors would exist beyond a/i for a particular i
            while( number%i == 0){            // if i is a factor
                number = number/i;            // divide a by i else we wont get a prime number
            }
        }

        if(number > 1) {
            System.out.println(number);
        }
    }



}