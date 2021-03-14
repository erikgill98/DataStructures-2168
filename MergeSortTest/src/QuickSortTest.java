import java.util.*;

public class QuickSortTest {
    static int qcount = 0;

    public static void main(String[] args) {
        Random gen = new Random();
        int[] a = new int[32];
        int i;
        for (i = 0; i < a.length; i++) a[i] = gen.nextInt(5000) + 1;
        System.out.println("Initial array:");
        for (i = 0; i < a.length; i++) System.out.println(a[i] + " ");
        System.out.println();
        quickSort(a, 0, a.length - 1);
        System.out.println("Sorted array:");
        for (i = 0; i < a.length; i++) System.out.println(a[i] + " ");
        System.out.println("Done!");
        System.out.println("qcount " + qcount);
       // System.out.println(" count " + count + " m " + m);
    }

    public static void quickSort(int[] a, int low, int high){
        if (low >= high){
            return;
        }

        int index = partition(a, low, high); //creating index variable of partition
        quickSort(a, low, index - 1); //before before index
        quickSort(a, index + 1, high); //after index
    }

    public static int partition(int[] a, int low, int high){
        int i = low - 1;
        int pivot = a[high]; //setting pivot to the right most index

        for(int j = low; j <= high - 1; j++){ //j first element in partition
            if(a[j] < pivot){ //checks if value of index j is less than pivot
                i++; //increments index of smaller element
                //creating two temp variables
                int temp1 = a[i];
                int temp2 = a[j];
                //swapping a[i] and a[j]
                a[i] = temp2;
                a[j] = temp1;
                qcount++;
            }
        }
        //repeating the same swapping process as above with high
        int temp1 = a[i + 1];
        int temp2 = a[high];
        a[i + 1] = temp2;
        a[high] = temp1;

        return i + 1;
    }
}
