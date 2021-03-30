import java.util.*;
public class StringColl {
    private btNode c; //initialize btNode c
    private int howmany; //initialize counter howmany

    // Creates an empty collection
    public StringColl() {
        c = null; //sets btNode c to be a null set
        howmany = 0; //set int howmany to 0
    }

    // Creates an empty collection of integers with size i
    public StringColl(int i) {
        c = null;
        howmany = 0;
    }

    //extension of copy -- copies tree
    private static btNode copytree(btNode t) {
        btNode root = null; //sets root to null
        if (t != null) { //runs while the node is not empty
            root = new btNode(); //creates new node
            root.info = t.info; //new root becomes t
            root.left = copytree(t.left); //left guy is t.left
            root.right = copytree(t.right); //right guy is t.right
        }
        return root; //returns root
    }

    // Creates a copy of a collection where elements are not equal. Takes in collection parameter obj of type StringColl
    public void copy(StringColl obj) {
        if (this != obj) {//checks if elements aren't the same
            howmany = obj.howmany;//sets howmany equal to the size of obj
            c = copytree(obj.c);//runs obj.c through copytree func
        }
    }

    // insert function, taking in the parameter string i
    public void insert(String i) {
        btNode pred = null;//sets new btNode to null
        btNode p = c; //sets p to c

        while ((p != null) && !(p.info.equals(i))) { //while p isn't empty and p contains i
            pred = p; //set pred to p
            if (p.info.compareTo(i) > 0){//compares  values of p with i (string).
                p = p.left;
            }else{
                p = p.right; //if equal values than p set to the right node
            }
        }
        if (p == null) { //if p is null
            howmany++; //increment howmany
            p = new btNode(i, null, null); //creates a new node with no children
            if (pred != null) { //if pred never received a value
                if (pred.info.compareTo(i) > 0){//comparison of pred and i
                    pred.left = p; //if not equal than the left node of pred is p
                }
                else {//else the right node of pred is p
                    pred.right = p;
                }
            } else {//else when p has contents, set them to replace c
                c = p;
            }
        }
    }

    public void omit(String i) {
        btNode pred = null; //empty node
        btNode p = c; //p points to the root node which is c

        while ((p != null) && (p.info.compareTo(i) != 0)) { //finds where i is within the tree
            pred = p; //sets pred equal to p, which is c, which is the root node
            if (p.info.compareTo(i) > 0)
                p = p.left;
            else
                p = p.right;
        }
        //when while loop finishes, p is pointing to the node that i is in

        if(p != null){//checking/assuming if i is in the collection
            btNode temp = p; //temp now points to p which is the node containing i

            if((p.left != null) && (p.right != null)){ //left and right successor
                btNode b = p.left; //new node, b points to left i
                if(b.right == null){ //checks if i-left has a right branch
                    temp = b; //if it does, temp(i node) points to b(i-left node)
                    temp.right = p.right; //the i right node now points to the i right node --- p.right is now b
                } else{ //if b.right isn't null
                    while(b.right.right != null){ //while loop runs till last branch
                        b = b.right; //sets b to the second to last right i node
                    }
                }
            }

            else if(p.right == null){//left successor, no right branch
                if(pred != null){
                    pred.left = p.left; //sets preds left i node equal to the node location that is being omitted
                }
                else {
                    c = p.left;
                }//if no pred, then p's successor becomes root
            }

            else if(p.left == null){//right successor, no left branch
                if(pred != null){
                    pred.right = p.right; //sets preds right i node equal to the node location that's being omitted
                }else{
                    c = p.right; //if no pred, then p's successor becomes root
                }
            }

            else{//no successor
                if(pred != null){
                    if(0 < pred.info.compareTo(i)){ //if i is less than the predisecor it is on the left side of tree
                        pred.left = null; //removes pointer from pred and changes to i
                    }
                    else{
                        pred.right = null; //if i is greater than pred, sets right tree null
                    }
                }
                else c = null; //if no preds sets c to null
            }//no successor
        }
    }

    // boolean functioning determining if parameter string i is in the collection
    public boolean belongs(String i) {
        btNode p = c; //sets a btNode p equal to c
        while ((p != null) && (i.compareTo(p.info)!= 0)) { //while p isn't empty p contains i
            if (i.compareTo(p.info) < 0) { //compares  values of p with i (string).
                p = p.left;
            } else {
                p = p.right; //if equal values than p set to the right node
            }
        }
        return (p != null); //return if p has contents
    }

    // returns the number of integers stored in collection
    public int get_howmany() {
        return howmany;
    }

    // prints collection
    public void print() {
        printtree(c);
    }

    // returns true if collection contains every value in that of obj.
    public boolean equals(StringColl obj) {
        int j = 0;
        boolean result = (howmany == obj.howmany);//creating boolean variable the length of howmany
        if (result) { //if holds
            String[] a = new String[howmany];//creating string array the size of howmany
            String[] b = new String[howmany];
            toarray(c, a, 0); //chaning both trees to arrays
            toarray(obj.c, b, 0);

            while ((result) && (j < howmany)) { //runs until array ends or values aren't equal anymore
                result = (a[j].equals(b[j]));
                j++;
            }
        }
        return result; //return the result
    }

    // An extension of the print method.
    private static void printtree(btNode t) {
        if (t != null) { //checks if t isn't null
            printtree(t.left); //puts left side through printtree
            System.out.println(t.info);
            printtree(t.right); //puts right side through printtree
        }
    }

    // toarray, created to place objects into an array taking paramters btNode t, a string 'a', and an integer i
    private static int toarray(btNode t, String[] a, int i) {
        int num_nodes = 0; //number of nodes initialized to zero
        if (t != null) { //if t is not empty
            num_nodes = toarray(t.left, a, i); //numnodes becomes object of type toarray passing the left node of t, a, and i
            a[num_nodes + i] = t.info; //a at position num_nodes + i is set equal to the contents of t
            num_nodes = num_nodes + 1 + toarray(t.right, a, num_nodes + i + 1); //num nodes incremented
        }
        return num_nodes; //return num_nodes
    }

    // This is an inner class for a binary tree
    private static class btNode {
        private String info;
        private btNode left;
        private btNode right;

        private btNode(String s, btNode lt, btNode rt) {
            info = s; left = lt; right = rt;
        }

        private btNode() {
            info = null; left = null; right = null;
        }
    }

}
