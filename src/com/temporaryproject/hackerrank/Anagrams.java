package com.temporaryproject.hackerrank;

import java.util.Arrays;

public class Anagrams {

    public static boolean isAnagram(String a, String b) {
        // Complete the function

        boolean status;

        if(a.length()!=b.length())
            status = false;
        else {

            char[] aCharArray = a.toLowerCase().toCharArray();
            char[] bCharArray = a.toLowerCase().toCharArray();

            Arrays.sort(aCharArray);
            Arrays.sort(bCharArray);
            status = Arrays.equals(aCharArray, bCharArray);

        }

        return status;
    }

    public static void runModule(){
        System.out.println(isAnagram("Hello","Heoll"));
    }

}
