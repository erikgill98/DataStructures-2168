import java.util.Scanner;
//**********************************************************
// FILE: NAME   : intcoll1client.java
// DESCRIPTION  : This is a client of class Intcoll1.
//**********************************************************

import java.util.*;

public class Intcoll2client {

    public static final int SENTINEL = 0;

    public static void main(String[] args) {
        System.out.println("Intcoll2");
        int value;
        Scanner keyboard=new Scanner(System.in);
        Intcoll2 P = new Intcoll2(), N = new Intcoll2(), L = new Intcoll2();


        System.out.println("Enter an integer to be inserted or 0 to quit:");
        value=keyboard.nextInt();
        while(value != SENTINEL) {
            if (value > 0) {P.insert(value); L.insert(value);
            }else{
                N.insert(-value); L.omit(-value);
            }
            System.out.println("Enter next integer to be inserted or 0 to quit:");
            value=keyboard.nextInt();
        }

        System.out.println("\nThe values in collection P are:");
        P.print();
        System.out.println("\nThe values in collection N are:");
        N.print();
        System.out.println("\nThe values in collection L are:");
        L.print();
        if (P.equals(N)) System.out.println("\nP and N are equal.");
        else System.out.println("\nP and N are NOT equal.");
        Intcoll2 A=new Intcoll2();
        A.copy(L);
        System.out.println("\nThe values in the copy of L are:\n");
        A.print();

        Intcoll2 B = new Intcoll2();
        B.insert(1);
        B.insert(2);
        B.insert(3);
        B.omit(2);
        B.print();

    }
}

