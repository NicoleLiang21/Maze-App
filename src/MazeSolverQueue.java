import java.util.ArrayList;

public class MazeSolverQueue extends MazeSolver {

    private MyQueue worklist;
    private Square current;
    private Maze maze;

    public MazeSolverQueue(Maze m){
        super(m);
        makeEmpty();
        add(m.getStart());
        maze = m;
        current = (Square) this.worklist.peek();

    }
    /*
     * creates empty this.worklist
     */
    public void makeEmpty(){ 
        this.worklist = new MyQueue();
    }
    /*
     * checks if the this.worklist is empty
     * @return true if it is empty
     */
    public boolean isEmpty()
    {
        return this.worklist.size() == 0;
      }
    /*
     * adds square to the this.worklist
     * @param square
     */
    public void add(Square sq) {
        this.worklist.add(sq);
    }

    /*
     * returns the next square in the this.worklist
     * @return square
     */
    public Square next(){
        this.worklist.remove();
        return (Square) this.worklist.peek();
    }
    
    
    public boolean isSolved(){
        if (current.getType() == 'E') return true;
        return false;
    }

    public String getPath(){
        String message = "";

        if (isSolved())// check if it is solved before if the worklist is empty because current removes from the worklist
            return message + "the maze is solved";
        if (this.worklist.size() == 0) message += "No such path exists; ";
        else
        {
            while (this.worklist.size() != 0)
                message += this.worklist.remove(); // .pop() for Stacks
        }
        return message + "the maze is not solved";

    }

    public Square step(){ // idk how to getpath without nodes :/ also maybe try to add the start's neighbors to worklist instead of overwriting the 'S'
        if (this.worklist.size() == 0) return null;
        current = (Square) this.worklist.remove();
        //System.out.println("get type: " + current.getType());
        if (current.getType() == 'E'){
            return null;// ends the step
        }
        ArrayList<Square> neighbors = maze.getNeighbors(current);
        //System.out.println(neighbors);
        //System.out.println(current);
        for (Square sq : neighbors){
            if ((sq.getType() == '_' || sq.getType() == 'E') && !this.worklist.contains(sq)) {
                this.worklist.add(sq);
        }
    }
        
        if (current.getType() != 'S' || current.getType() != 'E')
            current.setType('.');

        return current;
    }

    public void solve(){
        // call step method until it is solved
        while (!isSolved() || this.worklist.size() != 0){
            step();
        }
        getPath();// get path when the maze is solved
    }
}
