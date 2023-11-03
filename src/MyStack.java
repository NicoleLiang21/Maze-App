import java.util.ArrayList;

public class MyStack
{
    // Tail of the ArrayList will be implemented as the 
    ArrayList array;
    int size;

    /*
     * Constructor for stack class 
     */
    public MyStack()
    {
        array = new ArrayList<>();
    }

    /*
     * push - add an element to the top of the stack
     * @param Object element
     */
    public void push(Object element)
    {
        array.add(element);
    }

    /*
     * pop - get the first element from the top of the stack and removing
     * @return Object element
     */
    public Object pop()
    {
        Object element = array.get(array.size()-1);
        array.remove(array.size()-1);

        return element;
    }

    /*
     * peek - get the first element from the top of the stack without removing
     * @return Object element
     */
    public Object peek()
    {
        return array.remove(array.size()-1);
    }

    /*
     * size - return the size of the stack
     * @return int size
     */
    public int size()
    {
        return array.size();
    }

    /*
     * contains - returns whether or not a stack contains an element
     * @return Object element
     */
    public boolean contains(Object element)
    {
        for (int i = 0; i < array.size(); i++)
            // can use ==; since same object = same memory location
            if (array.get(i) == element) 
                return true;
                
        return false;
    }

}