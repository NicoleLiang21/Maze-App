public class MyQueueTest {
    public static void main(String args[]){
        MyQueue q = new MyQueue();

        q.add("1");
        q.add("remove");
        q.add("2");
        System.out.println(q.size());
        q.remove();
        System.out.println(q.size());

    }
}
