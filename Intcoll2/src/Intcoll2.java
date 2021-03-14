//*********************************************************************
// FILE NAME    : Intcoll1.java
// DESCRIPTION  : This file contains the class Intcoll1.
//*********************************************************************

public class Intcoll2 {
    private int[] c;
    private int how_many; //number of user inputs

    //initiliazes array/constructor
    public Intcoll2() { //initializes array which can hold 500+1 ints
        c = new int[500+1];
        how_many = 0;
    }

    //alternate constructor
    public Intcoll2(int i) { //initializes array which can hold i + 1 ints
        c = new int[i+1];
        c[0] = 0;
        how_many = 0;
    }

    //creates a copy of obj
    public void copy(Intcoll2 obj) { //copy's the contents of obj into
        if (this != obj){ //checks if there's a copy made already
            c = new int[obj.c.length]; //c is now array size of the amount of objs
           // int j = 0; //creates new int named i
           for(int i = 0; i < c.length; i++){ //loop goes through c
                if(i !=  obj.how_many) { //checks if
                    c[i] = obj.c[i];
                }
           }
           //c[i] = 0;
           how_many = obj.how_many;
        }
    } //doesn't work

    //checks if element is in array
    public boolean belongs(int i) { //returns true if array contains i
        int j = 0;
        while ((c[j] != how_many) && (c[j] != i)) //checks if c[index] is not equal to howmany. also checks if c[index] is not equal to i
            //^^keeps running until one condition is met
            j++;//increments if they're not equal
        return (c[j] != how_many);  //if both conditions are met it returns true. if not runs through entire collection and returns false
    }

    //if i > 0 and i is not in collection then i is added to collection
    public void insert(int i) {
        if (i > 0) {
            int j = 0;
            while ((c[j] != how_many) && (c[j] != i)) //same thing as belongs, while it hasn't reached end of array
                j++;

            if (c[j] == how_many) { //if c[index] is equal to the user inputs
                if (j == c.length - 1) {
                    int[] temp = new int[c.length * 2]; // create new array d twice the length c

                    for(i = 0; i < how_many; i++){//goes through user input into new array
                        temp[i] = c[i]; //sets original array = to the temp
                    }
                    c = temp; //sets input to c
                }
                c[j] = i;
                c[j + 1] = 0; //if c[j] equals 0, replace 0 with input i
            }
        }
    }

    //removes i if i is in collection
    public void omit(int i) {//if array contains i, it will be removed
        if(i > 0) {
            int j = 0;
            while ((j < how_many) && (j != i)) { //goes through array checking if
                j++;
            }
            if (j != how_many && c[j] == i) {
                how_many--;
                c[j] = c[how_many];
            }
        }
    } //doesnt work

    //returns the number of ints in collection
    public int get_howmany() {
        return how_many; //just returns the value of how_many since it is the size of the array
    }

    //outputs ints in collection
    public void print() {
        int j = 0;
        System.out.println(" ");
        while (j != how_many) { //iterates through array until c[index] is equal to how_many
            System.out.println(c[j]);
            j++;
        }
    }

    //returns true if integers in collection are the same as ints in obj
    public boolean equals(Intcoll2 obj) { //both whiles do same thing just opposite
        int j = 0;
        boolean result = true;
        if(this.get_howmany() == obj.get_howmany()) {
            while ((c[j] != how_many) && result) { //while c[index] isn't end of array and true
                result = obj.belongs(c[j]); //stays true, changes to false if not true
                j++;
            }
            j = 0;
            while ((obj.c[j] != how_many) && result) { //checks if everything is in object array is in method array
                result = belongs(obj.c[j]);
                j++;
            }
        }else{
            result = false;
        }
        return result;
    }

}
