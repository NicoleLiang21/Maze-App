import java.util.ArrayList;

public abstract class MazeSolver {
    /*
     * creates empty worklist
     */
    abstract void makeEmpty();
    /*
     * checks if the worklist is empty
     * @return true if it is empty
     */
    abstract boolean isEmpty();
    /*
     * adds square to the worklist
     * @param square
     */
    abstract void add(Square sq);

    /*
     * returns the next square in the worklist
     * @return square
     */
    abstract Square next();

    private MyQueue worklist;
    private Square current;
    private Maze maze;
    
    MazeSolver(Maze m){
        maze = m;
    }
    
    private boolean isSolved(){
        if (worklist.size() == 0) return true;
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
        if (current.getType() == 3){
            getPath();
        }
        ArrayList<Square> neighbors = maze.getNeighbors(current);
        for (Square sq : neighbors){
            if ((sq.getType() != 1 || sq.getType() != 'o' || sq.getType() != '.') && !worklist.contains(sq))
                worklist.add(sq);
        }
        
        Square sq = current;
        current = new Square (current.getRow(), current.getCol(), '.');
        return sq;
    }

    public void solve(){
        // call step method until it is solved
        while (!isSolved() || worklist.size() != 0){
            step();
        }
    }
}
