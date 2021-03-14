import java.util.*;

public class Intcoll4 {
   private int howmany; //keep tracks of howmany ints are in collection by object
   private ListNode c; //c of type ListNode, name of Linked List

   //default constructor
   public Intcoll4(){ //no need to worry about capacity - ignoring capacity problem
      c=null; //c name of linked list where all ints are stored in collection. needs to be set to null which is empty
      howmany = 0; //starts at 0 because it counts how many items are in collection
   }

   //alternate constructor
   public Intcoll4(int i){ //can be same code because we're not worrying about capacity
      c=null;
      howmany = 0;
   }

   public void copy(Intcoll4 obj) { //obj is just parameter name
       if(this != obj) { //checks if this obj being copied is already copied
           howmany = obj.howmany; //sets the new obj to the howmany being copied
       }else{
           c = new ListNode(obj.c.info, null); //creating new ListNode named c. obj.c.info is the first(head) of array being copied
           ListNode pInfo = c; //pInfo is now the head of the copy //pInfo is value
           ListNode q = obj.c; //qInfo is pointer(??) or Node as a whole
           //obj is intcoll4 that passes through function....c in member that i'm currently in

           while(q.link != null){ //as long as q is still pointing to another node it keeps running
               q = q.link; //setting q to the next pointer
               pInfo.link = new ListNode(q.info, null); //pInfo(value) is now the newest node in the copied LinkedList
               pInfo = pInfo.link; //now i'm setting the newest node->(pInfo.link) to copy another node and the while loop goes again
           }
       }
   }

   //puts i into collection if it isn't there --- if it's there does nothing
   public void insert(int i) {
      ListNode p = c; //p pointing to first list item c
      while ((p != null) && (p.info != i)) p = p.link; //while it is not there, look in next list item
      if (p == null){ //hits if statement if array traverse hits null
         p = new ListNode(i, c); //this uses alternate constructor to add item
        // p.info=i;
        // p.link=c;
         c = p;
         howmany++;
      }
   }

   public void omit(int i) {
      ListNode p = c; //sets new listnode p = to listnode c //listnode is head
      ListNode pred = null; //creates pred, which is a null variable
          while ((p != null) && (p.info != i)){ //while loop runs while p has a node and p.info(int value) is not equal to user input
              pred = p; //sets pred equal to the current node it's on
              p = p.link; //then sets p equal to what link is pointing to
          }
          if (p != null){ //checks if p is not null
              if (pred != null) { //checks if pred is null
                  pred.link = p.link; //changes what pred points too
              }
              else c = p.link; //null check
              howmany--; //decreases the howmany count since we changed pointers
          }
   }

   //checks if i is in linked list
   public boolean belongs(int i)  {
      ListNode p = c; //p pointing to first list item c
      while ((p != null) && (p.info != i)){ //traverses through linked list, checks if value of index isn't null and i
          p = p.link;
      }
      return (p != null); //returns false if it isn't in linked list
   }

   public int get_howmany(){
       return howmany;
   }

   //prints out all the integers in collection
   public void print() {
       ListNode p = c; //p starts out points to first item, which is c
       System.out.println();
       //while loop does traversal of linked list
       while (p != null){ //p starts at first index, so on until it there are no more ints -- null
         System.out.println(p.info); //prints out what is stored in p's info(number)
         p = p.link; //change what p is points to link
       }
   }

   public boolean equals(Intcoll4 obj) {
       ListNode p = c; //creates new ListNode p that's equal to c
       boolean value = (howmany == obj.howmany); //sets boolean value = to howmany(how long linkedlist is) == obj

       while((p != null) && value){
           value = obj.belongs(p.info); //calls belongs, checks if everything that is in obj is in p
           p = p.link; //sets p equal to next info value
       }

       return value;
   }

   // The inner class for ListNode
      private class ListNode { //def of listNode class
           private int info;//new int named info
           private ListNode link; //link member of type list node

           public ListNode(){ //default constructor
               info=0;
               link=null;
           }

           //Alternate constructor
           public ListNode(int i, ListNode p) {
               info=i; //info is now int i
               link=p; //link is now what p is pointing to
               // link contains whole next node in list
           }
      }
 }