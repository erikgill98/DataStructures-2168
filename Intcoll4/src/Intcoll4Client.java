import java.util.Scanner;
//**********************************************************
// FILE: NAME   : intcoll1client.java
// DESCRIPTION  : This is a client of class Intcoll1.
//**********************************************************

import java.util.*;

public class Intcoll4Client {

    public static final int SENTINEL = 0;

    public static void main(String[] args) {
        int value;
        Scanner keyboard = new Scanner(System.in);
        Intcoll4 P = new Intcoll4(), N = new Intcoll4(), L = new Intcoll4(); //P N L are new objects of intcoll1

        System.out.println("Enter an integer to be inserted or 0 to quit:");
        value = keyboard.nextInt();
        while(value != SENTINEL){
            if (value > 0) {
                P.insert(value);
                L.insert(value);
            }else{
                N.insert(-value);
                L.omit(-value);
            }
            System.out.println("Enter next integer to be inserted or 0 to quit:");
            value = keyboard.nextInt();
        }

        System.out.println("\nThe values in collection P are:");
        P.print();
        System.out.println("\nThe values in collection N are:");
        N.print();
        System.out.println("\nThe values in collection L are:");
        L.print();
        if (P.equals(N)) System.out.println("\nP and N are equal.");
        else System.out.println("\nP and N are NOT equal.");
        Intcoll4 A = new Intcoll4(); //creates new object A
        A.copy(L);
        System.out.println("\nThe values in the copy of L are:\n");
        A.print();


     /*   Intcoll4 B = new Intcoll4();
        B.insert(10);
        B.insert(20);
        B.insert(30);
        B.insert(40);
        B.insert(50);
        B.insert(60);
        B.copy(B);

      */



    }
}

