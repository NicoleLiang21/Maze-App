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
        add(m.getStart()); //#ADD review this stuff
        maze = m;
        current = (Square) this.worklist.peek();
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
        if (this.worklist.size() == '_')
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
        else if (current.getType() == 'E') return true;
        return false;
    }

    public String getPath(){
        String message = "";

        if (this.worklist.size() == '_') message += "No such path exists; ";
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
        if (this.worklist.size() == '_') return null;
        current = (Square) this.worklist.pop();

        if (current.getType() == 'E'){
            System.out.println("E reached");
            getPath();
        }

        // #ADD changing this entire thing
        // #ADD NOTE: need to change 'o' to '.'
        ArrayList<Square> neighbors = maze.getNeighbors(current);
        for (Square sq : neighbors){
            if ((sq.getType() == '_' || sq.getType() == 'E') && !this.worklist.contains(sq)) {

                // Update the map
                // determine if its the first path taken
                if (neighbors.indexOf(sq) == neighbors.size() - 1)
                    sq.setType('.');
                // otherwise its a secondary path
                else
                    sq.setType('o');

                this.worklist.push(sq);
            }
        }
        
        // Update the current square
        if (current.getType() != 'S' || current.getType() != 'E')
            current.setType('.');
        return current;
    }

    public void solve(){
        // call step method until it is solved
        while (!isSolved() || this.worklist.size() != 0){
            step();
        }
    }
}
