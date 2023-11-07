import java.util.ArrayList;

public class MazeSolverStack extends MazeSolver
{

    private MyStack worklist;
    private Square current;
    private Maze maze;

    /*
     * Constructor for MazeSolverStack
     */
    public MazeSolverStack(Maze m){
        super(m);
        
        makeEmpty();

        current - 

        maze = m;
        add(maze.getStart());
    }

    /*
     * creates empty worklist
     */
    public void makeEmpty()
    {
        this.worklist = new MyStack();
    }

    /*
     * checks if the worklist is empty
     * @return true if it is empty
     */
    public boolean isEmpty()
    {
        if (this.worklist.size() == 0)
            return true;
        
        return false;
    }

    /*
     * adds square to the worklist
     * @param square
     */
    public void add(Square sq)
    {
        this.worklist.push(sq);
    }

    /*
     * returns the next square in the worklist
     * @return square
     */
    public Square next()
    {
        return (Square) this.worklist.pop();
    }
    
    public boolean isSolved(){
        if (this.worklist.size() == 0) return true;
        else if (current.getType() == 3) return true;
        return false;
    }

    public String getPath(){
        String message = "";

        if (this.worklist.size() == 0) message += "No such path exists; ";
        else
        {
            while (this.worklist.size() != 0)
                message += worklist.pop(); // .remove() for queues
        }

        if (isSolved())
            return message + "the maze is solved";
        return message + "the maze is not solved";

    }

    public Square step(){ 
        if (this.worklist.size() == 0) return null;
        current = (Square) this.worklist.pop();
        if (current.getType() == 3){
            getPath();
        }
        ArrayList<Square> neighbors = maze.getNeighbors(current);
        for (Square sq : neighbors){
            if ((sq.getType() != 1 || sq.getType() != 'o' || sq.getType() != '.') && !this.worklist.contains(sq))
                this.worklist.push(sq);
        }
        
        Square sq = current;
        current = new Square (current.getRow(), current.getCol(), '.');
        return sq;
    }

    public void solve(){
        // call step method until it is solved
        while (!isSolved() || this.worklist.size() != 0){
            step();
        }
    }
}
