package com.ash.ik.arrays;

public class CountPrime {


    public static int countPrimes(int n) {

        boolean[] prime= new boolean[n];
        int cnt= 0;
        for(int i=2; i<n; i++) {
            if(prime[i]) {
                continue;
            }
            cnt++;
            for(int j=2; j*i<n; j++) {
                prime[j*i] = true;
            }
        }
        return cnt;
    }

    public static int countPrimesBF(int n) {

        int count= 0 ;
        boolean prime= true;
        for(int i=2; i<=n; i++) {
            prime = true;
            for (int j=2; j<i;  j++) {
                if(i%j == 0) {
                    prime = false;
                    break;
                }
            }

            if(prime) {
                //System.out.println(i);
                count++;
            }
        }

        return count;

    }






    public static void main(String[] args) {
       System.out.println(countPrimes(10));
       System.out.println(countPrimesBF(10));
    }
}
