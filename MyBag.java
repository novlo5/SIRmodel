import java.lang.ProcessBuilder.Redirect.Type;
import java.util.Iterator;
public class MyBag<Type> implements Iterable<Type>  
{

    private int count;
    private LinkedList<Type> bag;
    public MyBag(){

        bag = new LinkedList<Type>();
        count = 0;
    }

    public int count(){return count;}

    public void add(Type item)
    {
        this.bag.insertAtTail(item);
        this.count++;
    }

    public Iterator<Type> iterator(){
        ListIterator i = new ListIterator();
        return i;
    }

             private class ListIterator implements Iterator<Type>{

                Node<Type> curr, prev;

               public ListIterator(){

                curr = bag.head;

               }

               public boolean hasNext(){

                return curr != null;
                        
               }
                
               
               public Type next(){

                 Node<Type> temp = new Node<Type>(curr.data);
                 prev = curr;
                 curr = curr.next;
                 return temp.data;

               }

                
                public void remove(){
                    prev.next = curr.next;
                }

            }
            class LinkedList<Type>
            {
                private Node<Type> head;
                private Node<Type> tail;
                
                public LinkedList(){
                    head = null;
                    tail = null;
                }
        
                public void insertAtTail(Type data){
                    Node<Type> newTail = new Node<Type>(data);
                        if(head == null){
                            head = newTail;
                            tail = newTail;
                            tail.prev = head;
                        }
                        else{
                            tail.next = newTail;
                            newTail.prev = tail;
                            tail = newTail;
                            
                        }
                }
            }
   
}   


