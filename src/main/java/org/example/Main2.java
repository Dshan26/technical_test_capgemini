package org.example;

public class Main2 {

    static int[] myArray = {1,2,2,4,5,6,7,8,8,8};

    public static void main(String[] args) {
        int longest = 0, number = 0,current = 0,prev = 0;

        for (int i : myArray) {
            if (i != prev) current = 1;
            else current++;

            if (current > longest) {
                longest = current;
                number = i;
            }

            prev = i;
        }

        System.out.println("Longest: " + longest);
        System.out.println("Number: " + number);
    }
}
