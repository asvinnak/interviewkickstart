package com.ash.ik.string;



public class Base64 {


    private void convertBase64(int number) {
        int curr_val = number;
        int quoficient;
        int reminder;
        StringBuilder sb= new StringBuilder();
        while(curr_val >= 64) {
            quoficient = curr_val/64;
            reminder = curr_val % 64;
            sb.append(reminder);
            curr_val = quoficient;
        }

        sb.append(curr_val);


        String shorturl= sb.reverse().toString();
        //hashtable[shorturl] = longurl;
        System.out.println("http://bit.ly/"+shorturl);
    }


    public static void main(String[] args) {
        Base64 o = new Base64();
        o.convertBase64(100);
    }
}
