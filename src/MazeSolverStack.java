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

        maze = m;
        add(maze.getStart());

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
        if (this.worklist.size() == '_') return true;
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
            getPath();
        }

        // #ADD changing this entire thing
        ArrayList<Square> neighbors = maze.getNeighbors(current);
        for (Square sq : neighbors){
            System.out.println("Loop called; Square is " + sq.getType());
            if (sq.getType() == '_' && !this.worklist.contains(sq)) {// #ADD shorter if condition for valid paths only

                if (neighbors.indexOf(sq) == neighbors.size() - 1) // determine if its the first path taken
                    sq = new Square(sq.getRow(), sq.getCol(), '.');
                else
                    sq = new Square(sq.getRow(), sq.getCol(), 'o'); // otherwise its a secondary path

                this.worklist.push(sq);
                maze.set(sq.getRow(), sq.getCol(), sq); // #ADD added this line & method in Maze --> gets the symbol to update
            }
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
