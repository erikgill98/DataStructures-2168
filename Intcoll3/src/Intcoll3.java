//*********************************************************************
// FILE NAME    : Intcoll1.java
// DESCRIPTION  : This file contains the class Intcoll1.
//*********************************************************************

import java.util.Arrays;

public class Intcoll3 {
    private boolean[] c;
    private int how_many;

    //default constructor
    public Intcoll3() { //initializes array which can hold 500+1 ints
        c = new boolean[500+1];
        how_many = 0;
    }

    //alernate constructor
    public Intcoll3(int i) { //initializes array which can hold i + 1 ints
        c = new boolean[i+1];
        how_many = 0;
    }

    //creates copy of obj to intcoll
    public void copy(Intcoll3 obj) { //copys the contents of obj into
        if (this != obj){
            c = new boolean[obj.c.length]; //c is now array size of the amount of objs

            for(int j = 0; j < obj.c.length; j++){//for loop to go through c
                c[j] = obj.c[j];
            }
            this.how_many = obj.how_many;
        }
    } //doesn't work

    //checks if element is in array
    public boolean belongs(int i) { //returns true if array contains i
        return (i < c.length && i > 0 && c[i]);
    }

    //if i > 0 and i is not in collection, add it to collection
    public void insert(int i) {
        if (i > 0) {
            if (i == c.length - 1){
                boolean[] temp = new boolean[(c.length - 1) * 2];
                System.arraycopy(c, 0, temp, 0, c.length); //intellij suggested it so I used it
                /*
                for(int j = 0; j < c.length; j++){
                    temp[j] = c[j];
                }
                 */
                temp[i] = true;
                c = temp;
                how_many++;
            }else{
                c[i] = true;
                how_many++;
            }
        }
    }

    //removes i if it is in collection
    public void omit(int i) {//if array contains i, it will be removed
        if (i > 0) { //checks if i is > 0
            c[i] = false; //if i is in index it removes and turns to false
            how_many--; //subtracts array by 1
        }
    }

    //returns the number of integers in the collection
    public int get_howmany() {
        return how_many; //just returns the value of how_many since it is the size of the array
    }

    //outputs ints in collection
    public void print() {
        System.out.println(" ");
        for(int j = 0; j < c.length; j++){
            if(c[j]){ //checks if index j is true
                System.out.println(j); //prints if it is
            }
        }
    }

    //returns true if collection and obj are equal
    public boolean equals(Intcoll3 obj) {
        boolean result = true; //creates variable that is set to true

        if (this.how_many == obj.how_many) { //checking to see if user input and obj are =
            for(int i = 0; i < c.length; i++){ //for loop to go through c array
                c[i] = obj.belongs(i); //putting index through belongs to see if it is in array
                result = true;
            }
        }else {
            result = false;
        }
        return result;
    }

}
