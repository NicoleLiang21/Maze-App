import java.util.LinkedList;

public class MyQueue {

    private LinkedList<Object> list;
    private int currentSize = 0;


    public MyQueue(){
        list = new LinkedList<Object>();
    }

    /*
     * adds object to the end of the linked list
     * @param object to be added
     */
    public void add(Object obj){
        
        currentSize ++;
        list.add(obj);
    }
    /*
     * removes object from the front of the linked list
     * @return object that is removed
     */
    public Object remove(){
        currentSize--;
        return list.remove(0);
    }

    /*
     * @return object at the front of the queue
     */
    public Object peek(){
        return list.get(0);
    }


    /*
     * getter for the size of the queue linked list
     * @return integer of the size of the linked list
     */
    public int size(){
        return currentSize;
    }

}
