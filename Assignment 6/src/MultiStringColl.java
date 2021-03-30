import java.util.*;

public class MultiStringColl {
    private btNode c;
    private int howmany;
    private int total;
    private int count;

    public MultiStringColl() {
        c = null;
        howmany = 0;
        count = 0;
        total = 0;
    }

    public MultiStringColl(String i) {
        c = null;
        howmany = 0;
        count = 0;
        total = 0;
    }

    public void copy(MultiStringColl obj) {
        if (this != obj) {//checks if elements aren't the same
            howmany = obj.howmany;//sets howmany equal to the size of obj
            total = obj.total; //total is how big obj is
            count = obj.total;
            c = copytree(obj.c);//runs obj.c through copytree func
        }
    }

    public boolean belongs(String i) {
        btNode p = c;
        while ((p != null) && (i.compareTo(p.info) != 0)) {
            if (i.compareTo(p.info) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return p != null;
    }

    public void insert(String i) {
        int count = 1;
        btNode pred = null;
        btNode p = c;
        if(i != null) {
            while ((p != null) && (p.info.compareTo(i) != 0)) {
                pred = p;
                if (i.compareTo(p.info) < 0) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }

            if (p != null) {
                p.count++;
                total++;
            } else if (p == null) {
                howmany++;
                total++;
                p = new btNode(i, null, null, 1);
                if (pred != null) {
                    if (i.compareTo(pred.info) < 0) {
                        pred.left = p;
                    } else {
                        pred.right = p;
                    }
                } else {
                    c = p;
                }
            }
        }
    }

    public void omit(String i) {
        btNode pred = null; //empty node
        btNode p = c; //p points to the root node which is c

        while ((p != null) && (p.info.compareTo(i) != 0)) { //finds where i is within the tree
            pred = p; //sets pred equal to p, which is c, which is the root node
            if (p.info.compareTo(i) < 0)
                p = p.right;
            else
                p = p.left;
        }//when while loop finishes, p is pointing to the node that i is in

        if (p != null) {
            btNode newP = p;
            howmany--;

            if(p.right == null){ //no right branch
                newP = p.left;
            }else if(count == 1){
                newP = null;
            }else if(count > 1){
                count--;
            }

            else if(p.left == null){ //no left branch
                newP = p.right;
            }else if(count == 1){
                newP = null;
            }else if(count > 1){
                count--;
            }

            else if((p.left != null) && (p.right != null)){ //both left and right succ
                btNode doubleBranch = p.left;
                if(doubleBranch.right == null){
                    newP = doubleBranch;
                    newP.right = p.right;

                }else{
                    while(doubleBranch.right.right != null){
                        doubleBranch = doubleBranch.right;
                    }
                    newP = doubleBranch.right;
                    doubleBranch.right = newP.left;
                    newP.right = p.right;
                    newP.left = p.left;
                }
            }else if(count == 1){
                newP = null;
            }else if(count > 1){
                count--;
            }

            if(pred == null){
                c = newP;
            }
            else if(pred.right == p){
                pred.right = newP;
            }else{
                pred.left = newP;
            }
        }
    }

    public int get_howmany() {
        return howmany;
    }

    public int get_total() {
        return total;
    }

    public int get_count(){
        return count;
    }

    public void print() {
        printtree(c);
    }

    public boolean equals(MultiStringColl obj) {
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
        return result;
    }

    private static btNode copytree(btNode t) {
        btNode root = null;
        if(t != null){
            root = new btNode(t.info, copytree(t.left), copytree(t.right), t.count);
        }
        return root;
    }

    private static void printtree(btNode t) {
        if(t != null){
            printtree(t.left);
            System.out.println(t.info + " (count " + t.count + ")");
            printtree(t.right);
        }
    }

    private static int toarray(btNode t, String[] a, int i) {
        int num_nodes = 0;
        if (t != null) {
            num_nodes = toarray(t.left, a, i);
            a[num_nodes + i] = t.info;
            num_nodes = num_nodes + 1 + toarray(t.right, a, num_nodes + i + 1);
        }
        return num_nodes;
    }

    private static class btNode {
        int total;
        String info;
        btNode left;
        btNode right;
        int count;

        public btNode(String s, btNode lt, btNode rt, int n) {
            info = s;
            left = lt;
            right = rt;
            count = n;
        }
        private btNode(){
            info = null;
            left = null;
            right = null;
            count = 0;
        }
    }
}