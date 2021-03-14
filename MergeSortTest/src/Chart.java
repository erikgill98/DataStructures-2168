import java.util.*;

public class Chart {


    public static void main(String[] args) {
        //creating arrays for sorts
        int[] quicksort_arr = new int[10];
        int[] insertionsort_arr = new int[10];
        int[] mergesort_arr = new int[10];

        //initializing the arrays
        MergeSortTest test_merg = null;
        InsertionSortTest test_inset= null;
        QuickSortTest test_quick= null;

        //initializing random generator
        Random gen=new Random();

        int[] sizes = {64, 128, 256, 512}; //creating array of sizes
        int[][] charts = new int[3][3]; //holding values for the outputs - m's, icount's, qcount's


        for (int j = 0; j < sizes.length; j++) { //loop for each size in the sizes array
            int[] a = new int[sizes[j]];
            int[] b = new int[sizes[j]];
            int[] c = new int[sizes[j]];
            int[] d = new int[sizes[j]];

            for (int i = 0; i < 10; i++) { //loop that collects m's, qcount's, icount's
                for (int k = 0; k < a.length; k++) { //fills arrays with the random values
                    a[k] = gen.nextInt(5000) + 1; //filling index with value
                }

                //copying "a" array 3 times for merge/quick/insertion sorts
                b = a.clone();
                c = a.clone();
                d = a.clone();

                //calling the sorts
                test_merg.mergesort(b, 0, a.length-1);
                test_inset.insertionSort(c);
                test_quick.quickSort(d, 0, a.length-1);

                //storing the sorts - m's, qcount, icount
                quicksort_arr[i] = test_quick.qcount;
                insertionsort_arr[i] = test_inset.icount;
                mergesort_arr[i] = test_merg.m;

                //resetting counts back to 0 because counts will continously increase -- we keep using the same objects(test_merg,test_insert,test_quick)
                test_quick.qcount = 0;
                test_inset.icount = 0;
                test_merg.m = 0;
            }

            //creating the 'chart'
            if (j == 0) {  //index 0 is size 64 in sizes array
                System.out.println("Array Order is \n Min -- Avg -- Max");
                charts[0][0] = _min(quicksort_arr);
                charts[0][1] = _avg(quicksort_arr);
                charts[0][2] = _max(quicksort_arr);

                charts[1][0] = _min(insertionsort_arr);
                charts[1][1] = _avg(insertionsort_arr);
                charts[1][2] = _max(insertionsort_arr);

                charts[2][0] = _min(mergesort_arr);
                charts[2][1] = _avg(mergesort_arr);
                charts[2][2] = _max(mergesort_arr);

                System.out.println("\n\n");

                System.out.println("ARRAY SIZE 64");
                System.out.println(Arrays.deepToString(charts));

                charts = new int[3][3];

            }else if(j == 1){ //index 1 is 128 in sizes array
                charts[0][0] = _min(quicksort_arr);
                charts[0][1] = _avg(quicksort_arr);
                charts[0][2] = _max(quicksort_arr);

                charts[1][0] = _min(insertionsort_arr);
                charts[1][1] = _avg(insertionsort_arr);
                charts[1][2] = _max(insertionsort_arr);

                charts[2][0] = _min(mergesort_arr);
                charts[2][1] = _avg(mergesort_arr);
                charts[2][2] = _max(mergesort_arr);

                System.out.println("\n\n");
                System.out.println("ARRAY SIZE 128");
                System.out.println(Arrays.deepToString(charts));
                charts = new int[3][3];

            }else if (j == 2){ //index 2 is 256 in sizes array
                charts[0][0] = _min(quicksort_arr);
                charts[0][1] = _avg(quicksort_arr);
                charts[0][2] = _max(quicksort_arr);

                charts[1][0] = _min(insertionsort_arr);
                charts[1][1] = _avg(insertionsort_arr);
                charts[1][2] = _max(insertionsort_arr);

                charts[2][0] = _min(mergesort_arr);
                charts[2][1] = _avg(mergesort_arr);
                charts[2][2] = _max(mergesort_arr);

                System.out.println("\n\n");

                System.out.println("ARRAY SIZE 256");
                System.out.println(Arrays.deepToString(charts));
                charts = new int[3][3];

            }else if (j == 3){ //index 3 is 512 in sizes array
                charts[0][0] = _min(quicksort_arr);
                charts[0][1] = _avg(quicksort_arr);
                charts[0][2] = _max(quicksort_arr);

                charts[1][0] = _min(insertionsort_arr);
                charts[1][1] = _avg(insertionsort_arr);
                charts[1][2] = _max(insertionsort_arr);

                charts[2][0] = _min(mergesort_arr);
                charts[2][1] = _avg(mergesort_arr);
                charts[2][2] = _max(mergesort_arr);

                System.out.println("\n\n");

                System.out.println("ARRAY SIZE 512");
                System.out.println(Arrays.deepToString(charts));
                charts = new int[3][3];
            }
        }
    }

    public static int _max(int[] arr){ //max function
        int len = arr.length; //creating len variable size of array

        int n = arr[0]; //n is now index 0
        for (int i = 0; i < len; i++){ //iterates through array
            if (arr[i] > n){ //checks if next value is greater
                n = arr[i]; //if it is then sets to higher val
            }
        }
        return n; //returns highest val
    }

    public static int _min(int[] arr){ //min function
        int len = arr.length; //creating len variable size of array

        int n = arr[0]; //n is now index 0
        for (int i = 0; i < len; i++){ //iterates through array
            if (arr[i] < n){ //checks if next value is less
                n = arr[i]; //if it is then sets to higher val
            }
        }
        return n; //returns lowest val
    }

    public static int _avg(int[] arr){ //avg function
        int len = arr.length;  //creating len variable size of array

        int sum = 0; //creating sum variable
        for (int i = 0; i < len; i++){ //iterates through array
            sum += arr[i]; //adds next int to sum
        }

        int avg = sum / len; //gets avg
        return avg; //returns avg
    }
}
