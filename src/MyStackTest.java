public class MyStackTest {
    
    public static void main(String[] args)
    {
        MyStack stack = new MyStack();

        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println(stack.pop()); // should return 1
        System.out.println(stack.peek()); // should return 2
    }

}
