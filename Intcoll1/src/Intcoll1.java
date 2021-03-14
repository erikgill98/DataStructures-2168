//*********************************************************************
// FILE NAME    : Intcoll1.java
// DESCRIPTION  : This file contains the class Intcoll1.
//*********************************************************************

public class Intcoll1 {
    private int[] c;

    public Intcoll1() { //initializes array which can hold 500 + 1 ints
        c = new int[500+1];
        c[0] = 0;
    }

    public Intcoll1(int i) { //initializes array which holds i + 1 ints
        c = new int[i+1];
        c[0] = 0;
    }

    /*
    This method starts by checking if the array being copied already has a copy made of it.
    If not, it creates a new array "obj.c" the same size as the length of c[]. It then runs
    through the array c copying every integers in that collection into obj.c[] until c[j] = 0.
    This makes a complete copy of the original array.

    A.copy(obj)
    called by A.c
     */
    public void copy(Intcoll1 obj) { //copys contents of obj into
        if (this != obj){
            c = new int[obj.c.length]; //c is now array size of the amount of obj
            int j = 0; //creates in named j

            while (obj.c[j] != 0) {
                c[j] = obj.c[j]; j++;
            }
            c[j] = 0;
        }
    }

    /*
    This method takes integar i and checks if that int is inside of whatever array. belong(i)
    Returns false if number is not in array. Runs through array and checks if c[j] equals or 0 or i.
    if equals , returns true, if equals 0, the statement 0 = not 0 is false thus returns false.
     */
    public boolean belongs(int i) {
        int j = 0;
        while ((c[j] != 0) && (c[j] != i)) j++;
        return (c[j] != 0);
    }

    public void insert(int i) {
        if (i > 0) {
            int j = 0;
            while ((c[j] != 0) && (c[j] != i))//same thing as belongs, while it hasn't reached end of array
                j++;

            if (c[j] == 0) {
                if (j == c.length - 1) {
                    int[] temp = new int[c.length * 2]; // create new array temp twice the length c

                    for(i = 0; i < c.length; i++){ //goes through user input into new array
                        temp[i] = c[i];//sets original array = to the temp
                    }
                    c = temp; //sets input to c
                }
                c[j] = i;
                c[j + 1] = 0; //if c[j] equals 0, replace 0 with input i
            }
        }
    }


        /*
        Removes i from array if it is there. Starts by making sure i is positive and not 0.
        It iterates through c[j] until c[i] either = 0 or i. If = 0 it will break. If = i it then searches for the next 0 in c[].
         */

    public void omit(int i) {
        if (i>0) { //checks if input is larger than 0
            int j = 0; //creates new variable j, for traversing array
            while ((c[j] != 0) && (c[j] != i)) //checks for repeats of value
                j++; //increments j by 1 if there are no repeats
            if (c[j] == i) {
                int k = j+1; //k is new index that traverses array if there is repeated value
                while (c[k] != 0) //checks if k is equal to 0
                    k++; //increments index by 1
                c[j] = c[k-1]; //Not sure what these two lines do
                c[k-1]=0;
            }
        }
    }

   /*
   Iterates though whatever array. get_howmany() and counts each integar until c[j] = 0. Then returns the number of objects in the collection.
    */

    public int get_howmany() { //returns the number of integers in the array and outputs  the number of integers in array
        int j=0, howmany=0; //creates two variables int j and howmany

        while (c[j]!=0){ //checks if c index j is equal to 0
            howmany++; //if it is increments by 1
            j++;
        }
        return howmany; //returns the value of howmany
    }

    /*
    Iterates through whichever array.print() printing every integar in c[j] on a sepearte line until c[j] = 0.
     */
    public void print() {
        int j = 0;
        System.out.println();
        while (c[j] != 0) {
            System.out.println(c[j]); j++;
        }
    }

        /*
        Checks if whichever array.equals (obj) contains the same integars as array obj.
        If for example you were to call a.equals(b), it would iterate through b[] using
        the belong method to make sure every integar in b[] is in a[]. It then iterates through a[]
        and makes sure every integar in a[] is also in b[]. If these conditions are met it returns true.
         */

    public boolean equals(Intcoll1 obj) {
        int j = 0;
        boolean result = true;
        while ((c[j] != 0)&&result) {
            result = obj.belongs(c[j]); j++;
        }
        j = 0;
        while ((obj.c[j] != 0)&&result) {
            result = belongs(obj.c[j]); j++;
        }
        return result;
    }
}
