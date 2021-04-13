package com.ash.ik.string;

import java.io.IOException;

public class AddTwoNumbersWithCarry {

    public static int addNumbers(String a, String b) {

        int carry= 0;
        int count= 0;
        int len_a= a.length();
        int len_b= b.length();
        StringBuilder result = new StringBuilder();

        while(len_a != 0 || len_b != 0) {

            // Assigning the ascii value
            // of the character
            int x = 0, y = 0;
            if (len_a > 0)
            {
                x = a.charAt(len_a - 1) - '0';
                len_a--;
            }
            if (len_b > 0)
            {
                y = b.charAt(len_b - 1) - '0';
                len_b--;
            }

            // Add both numbers/digits
            int sum = x + y + carry;

            // If sum > 0, icrement count
            // and set carry to 1
            if (sum >= 10)
            {
                carry = 1;
                count++;
                result.append(sum%10);
            } // Else, set carry to 0
            else {
                carry = 0;
                result.append(sum);
            }
        }

        return Integer.parseInt(result.reverse().toString());
}



    public static int add(String a, String b) {

        int a1= a.length();
        int b1= b.length();

        int carry= 0;
        int i=0;
        int sum= 0;
        StringBuilder sb= new StringBuilder();
        while(a1 != 0 || b1 != 0) {

            int x=0; int y=0;
            if(a1 > 0) {
                x = a.charAt(a1 -1) - '0';
                a1--;
            }
            if(b1 > 0) {
                y = b.charAt(b1 -1) - '0';
                b1--;
            }
            sum = x+y+carry;

            if(sum >= 10) {
                carry = 1;
                sb.append(sum%10);
            } else {
                carry = 0;
                sb.append(sum);
            }


        }

        return Integer.parseInt(sb.reverse().toString());
    }



    public static void main(String[] args) throws IOException {
        System.out.println(addNumbers("23", "19"));
        System.out.println(add("23", "19"));
    }
}
