import java.util.ArrayList;

public class MazeSolverQueue extends MazeSolver {

    private MyQueue worklist;
    private Square current;
    private Maze maze;

    /*
     * creates empty worklist
     */
    public void makeEmpty(){ 
        worklist = new MyQueue();
    }
    /*
     * checks if the worklist is empty
     * @return true if it is empty
     */
    public boolean isEmpty()
    {
        return worklist.size() == 0;
      }
    /*
     * adds square to the worklist
     * @param square
     */
    public void add(Square sq) {
        worklist.add(sq);
    }

    /*
     * returns the next square in the worklist
     * @return square
     */
    public Square next(){
        worklist.remove();
        return (Square) worklist.peek();
    }
    
    
    public MazeSolverQueue(Maze m){
        super(m);

        add(m.getStart());
        maze = m;
        current = (Square) this.worklist.peek();

    }
    
    public boolean isSolved(){
        if (current.getType() == 3) return true;
        return false;
    }

    public String getPath(){
        String message = "";

        if (worklist.size() == 0) message += "No such path exists; ";
        else
        {
            while (worklist.size() != 0)
                message += worklist.remove(); // .pop() for Stacks
        }

        if (isSolved())
            return message + "the maze is solved";
        return message + "the maze is not solved";

    }

    public Square step(){ 
        if (worklist.size() == 0) return null;
        current = (Square) worklist.remove();
        if (current.getType() == 'E'){
            getPath();
        }
        ArrayList<Square> neighbors = maze.getNeighbors(current);
        for (Square sq : neighbors){
            if ((sq.getType() == '_' || sq.getType() == 'E') && !this.worklist.contains(sq)) {
                worklist.add(sq);
        }
    }
        
        if (current.getType() != 'S' || current.getType() != 'E')
            current.setType('.');
        return current;
    }

    public void solve(){
        // call step method until it is solved
        while (!isSolved() || worklist.size() != 0){
            step();
        }
    }
}
