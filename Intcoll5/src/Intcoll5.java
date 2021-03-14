import com.intellij.ide.structureView.impl.StructureViewElementWrapper;
import org.codehaus.groovy.runtime.dgmimpl.arrays.IntegerArrayGetAtMetaMethod;

import java.util.*;

public class Intcoll5 {
    private LinkedList<Integer> c;

    //default constructor of all positive ints
    public Intcoll5() {
        c = new LinkedList<>();
    }

    //alternate constructor of all positive ints
    public Intcoll5(int i){
        c = new LinkedList<Integer>();
    }

    //creates a copy of input
    public void copy(Intcoll5 obj) {
        if(this != obj){//checks if obj is already copied
            LinkedList<Integer> tempList = new LinkedList<>(); //creates a new temp linkedlist
 /*
            for (Integer integer : obj.c) {
                tempList.add(integer);
            }
 */
            ListIterator<Integer> trav = obj.c.listIterator(); //creating a list iterator
            while(trav.hasNext()){ //while the traversal has a next item
                tempList.add(trav.next()); //adding it to temp list then going to the next item in trav
            }
            this.c = tempList; //"this" is the current instance of c
        }
    }

    //inserts i into collection
    public void insert(int i) {
        if(i > 0){ //checking if input is positive
            Integer l = i; //int l is now i
            if((!c.contains(l))){ //checks if c doesn't already contain l
                c.addFirst(l); //adding it to the front of the list
            }
        }
    }

    //removes i form collection if it is in there
    public void omit(int i) {
        if(c.contains(i)){ //checks if i is in collection
            c.remove(Integer.valueOf(i)); //removes the value of i if it is
        }
    }

    //checks if element is in array
    private boolean belongs(int i) {
        return c.contains(i);
    }

    //returns the number of integers in the collection
    public int get_howmany() {
        return c.size(); //returns the size of collection
    }

    //outputs the integers in the collection
    public void print(){
/*
        for (Integer p : c) {
            System.out.println(p.intValue());
        }
*/
        ListIterator<Integer> temp = c.listIterator(); //creating a list iterator called temp
        while(temp.hasNext()){ //while temp has a next value
            Integer p = temp.next(); //p is set to the value
            System.out.println(p.intValue()); //prints out value
        }

    }

    //returns true if the collections are the same same elements and same length
    public boolean equals(Intcoll5 obj){
        boolean result = (this.get_howmany() == obj.get_howmany()); //check statement to see if they are same length

        ListIterator<Integer> temp = obj.c.listIterator(); //listiterator to go through c
        while(temp.hasNext() && result){ //iterators through list while there's a next value and they're the same length
            result = this.belongs(temp.next()); //this sets result to false if there they're not equal
        }
        return result;
    }

}

/*
.add()  - adds something to end of list
.size() - returns the size of the list
.contains() - boolean checks if object is in list
.remove() - removes object from list
.listIterator() - used to traverse list (reference LInkedLIstsDemos.java)
.hasNext() - boolean checks if there is a next object in list
.next() - points to the next object in the list
.intValue() - returns the numeric value of the object
.set() - replaces one element with another eg. list.set(2, "Two")
.addFirst() - inserts object to first slot of linked list
 */