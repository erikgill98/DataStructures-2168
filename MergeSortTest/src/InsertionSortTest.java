import java.util.*;

public class InsertionSortTest {
    static int icount = 0;

    public static void main(String[] args) {
        Random gen = new Random();
        int[] a = new int[32];
        int i;
        for (i = 0; i < a.length; i++) a[i] = gen.nextInt(5000) + 1;
        System.out.println("Initial array:");
        for (i = 0; i < a.length; i++) System.out.println(a[i] + " ");
        System.out.println();
        insertionSort(a);
        System.out.println("Sorted array:");
        for (i = 0; i < a.length; i++) System.out.println(a[i] + " ");
        System.out.println("Done!");
        System.out.println("icount " + icount);
       // System.out.println(" count " + count + " m " + m);
    }

    public static void insertionSort(int[] a){

        for(int i = 1; i < a.length; i++){ //iterates through array
            int val = a[i]; //creating val of a[index]
            int j = i; //setting j = i value

            while(j > 0 && a[j-1] > val){  //runs while j > than index value
                a[j] = a[j-1]; //sets j equal to index to left of original spot
                j--; //goes to next index
                icount++;
            }
            a[j] = val;
        }
    }
}