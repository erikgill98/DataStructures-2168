//***********************************************************************
// FILE NAME    : Intcoll6.java
// DESCRIPTION  : This file contains the class Intcoll6.
//************************************************************************

import java.util.*;
import java.io.*;

public class Intcoll6 {
    private int howmany;
    private btNode c;

    public Intcoll6() {
        c = null;
        howmany = 0;
    }

    public Intcoll6(int i) {
        c = null;
        howmany = 0;
    }

    private static btNode copytree(btNode t) {
        btNode root=null;
        if (t!=null) {
            root=new btNode();
            root.info=t.info;
            root.left=copytree(t.left);
            root.right=copytree(t.right);
        }
        return root;
    }

    public void copy(Intcoll6 obj){
        if (this!=obj) {
            howmany=obj.howmany;
            c=copytree(obj.c);
        }
    }

    public void insert(int i) {
        if (i>0) {
            btNode pred=null, p=c;

            while ((p!=null)&&(p.info!=i)) {
                pred=p;
                if (p.info>i) p=p.left;
                else p=p.right;
            }

            if (p==null) {
                howmany++; p=new btNode(i, null, null);
                if (pred!=null) {
                    if (pred.info>i) pred.left=p;
                    else pred.right=p;
                }
                else c=p;
            }
        }
    }

    public void omit(int i) {
        btNode pred = null; //empty node
        btNode p = c; //p points to the root node

        while ((p != null) && (p.info != i)) { //finds where i is within the tree
            pred = p; //sets pred equal to p, which is c, which is the root node
            if (p.info > i)
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
                    temp.right = p.right; //the i right node now points to the
                }
            }

            else if(p.right == null){//left successor, no right branch

            }

            else if((p.left == null)){//right successor, no left branch

            }

            else{//no successor
                if(pred != null){
                    if(i < pred.info){ //if i is less than the predisecor it is on the left side of tree
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

    public boolean belongs(int i) {
        btNode p=c;
        while ((p!=null)&&(p.info!=i)) {
            if (p.info>i) p=p.left;
            else p=p.right;
        }
        return (p!=null);
    }

    public int get_howmany() {
        return howmany;
    }

    public void print() {
        printtree(c);
    }

    public boolean equals(Intcoll6 obj) {
        int j = 0;
        boolean result  = (howmany == obj.howmany);
        if(result){
            int[] temp = new int[howmany];
            int[] temp2 = new int[howmany];
            toarray(c, temp, 0);
            toarray(obj.c, temp2, 0);

            j = 0;
            while((result) && (j < howmany)){
                result = (temp[j] == temp2[j]);
                j++;
            }

        }
        return result;
    }

    private static void printtree(btNode t) {
        if (t!=null) {
            printtree(t.left);
            System.out.println(t.info);
            printtree(t.right);
        }
    }

    private static int toarray(btNode t, int[] a, int i) {
        int num_nodes=0;
        if (t!=null) {
            num_nodes=toarray(t.left, a, i);
            a[num_nodes+i]=t.info;
            num_nodes=num_nodes+1+toarray(t.right, a, num_nodes+i+1);
        }
        return num_nodes;
    }

    private static class btNode {
        int info; btNode left; btNode right;

        private btNode(int s, btNode lt, btNode rt) {
            info=s; left=lt; right=rt;
        }

        private btNode() {
            info=0; left=null; right=null;
        }
    }
}
