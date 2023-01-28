import java.util.*;
import java.io.*;

// class MultiThread implements runnable 
class MultiThread implements Runnable {
    int first;
    int last;
    int totalNum;
    int sum; 

    // isPrime function checks if number is prime or not by checking for each number if there is any number less than its square root that is prime
    public static boolean isPrime(long n) {
        if (n == 0 || n == 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    // a multiThread takes inputs first and last to decide the range of numbers each thread should calculate primes for
    public MultiThread(int first, int last) {
        this.first = first;
        this.last = last;
    }

    // checks for prime numbers and adds them to the primeNumbers arrayList, increments totalNum
    @Override
    public void run() {
        sum = 0;
        totalNum = 0;
        ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
        for (int i = first; i <= last; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
                totalNum = totalNum + 1;
                sum = sum + i;
            }
        }
        /*
        I couldn't figure out how to print the totalNum and sum of all 8 threads combined. In addition to this I was
        having issues with the sum I would often get incorrect numbers
        */
    }
}
public class ass1 {
    public static void main(String[] args) {
        // makes use of 8 threads to calculate prime numbers
        // nums array helps find the range for each thread to calculate primes
        // this is done by dividing 100000000 by 8 and having the first thread calculate 
        // the first 12500000 numbers, the 2nd the next 12500000, and so on..
        int nums[] = new int[8];
        int count = 1;
        for(int i=0; i<8; i++){
            nums[i] = count*12500000;
            count++;
        }
        // starts the timer and creates ArrayList of threads
        long startTime = System.nanoTime();
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 8; i++) {
            if(i==0){
                threads.add(new Thread(new MultiThread(0, nums[0])));
                threads.get(0).start();
            }
            else{
                threads.add(new Thread(new MultiThread(nums[i-1], nums[i])));
                threads.get(i).start();
            }
        }
        // joins the threads
        for(int i=0; i<8; i++){
            try
            {
                threads.get(i).join();
            } catch (Exception e)
            {
            }
        }
        long endTime = System.nanoTime();
        double timeTaken = (double)((endTime-startTime)/1000000000);
        try{
            PrintWriter printWriter = new PrintWriter(new File("primes.txt"));
            printWriter.println(timeTaken);
        } catch (Exception e){
        }
    }
}