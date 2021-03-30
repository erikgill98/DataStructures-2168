import java.util.Scanner;

public class ChildStringColl extends MultiStringColl{
    public ChildStringColl(){
        super();
    }
    public ChildStringColl(String i){
        super(i);
    }

    @Override
    public void insert(String i){
        if(!belongs(i)){
            super.insert(i);
        }
    }
    @Override
    public int get_count(){
        return super.get_count();
    }
    @Override
    public int get_total(){
        return super.get_total();
    }

    public static final String SENTINEL = "###";

    public static void main(String[] args)
    {
        String input; Scanner keyboard=new Scanner(System.in);
        ChildStringColl P=new ChildStringColl(), N=new ChildStringColl(), L= new ChildStringColl();

        System.out.println("Enter a +String to be inserted or a -String to be removed or # to quit:");
        input=keyboard.nextLine();
        while(!(input.equals(SENTINEL)))
        {
            if (input.charAt(0) == '+') {P.insert(input.substring(1)); L.insert(input.substring(1));}
            else if(input.charAt(0) == '-') {N.insert(input.substring(1)); L.omit(input.substring(1));}
            System.out.println("Enter next string to be inserted or removed or # to quit:");
            input=keyboard.nextLine();
        }
        System.out.println("\nThe inputs in collection P are:");
        P.print();
        System.out.println("\nThe inputs in collection N are:");
        N.print();
        System.out.println("\nThe inputs in collection L are:");
        L.print();

        if (P.equals(L)) System.out.println("\nP and L are equal.");
        else System.out.println("\nP and L are NOT equal.");
        ChildStringColl A=new ChildStringColl(); A.copy(L);
        System.out.println("\nThe inputs in the copy of L are:\n");
        A.print();

        String x = "test";
        if(P.belongs(x))
            System.out.println("\n" + x + " is in collection P");
        else
            System.out.println("\n" + x + " is not in collection P");
    }
}
