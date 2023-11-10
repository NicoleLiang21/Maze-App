import java.util.ArrayList;

public class MazeSolverStack extends MazeSolver
{

    private MyStack worklist, track; //#ADD tracking feature
    private Square current;
    private Maze maze;


    /*
     * Constructor for MazeSolverStack
     */
    public MazeSolverStack(Maze m){
        super(m);
        
        makeEmpty();
        add(m.getStart());
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
        if (current.getType() == 'E') return true;
        else if (worklist.size() == 0) return true; //#ADD triggers the 'no path exists' message
        return false;
    }


    public String getPath(){
        String message = "";
        // this method is going to be called multiple times -- figure out which mode to enter
        if (maze.getEnd().getPrevious() != null) //#ADD like alllll of this
        {
            track = new MyStack();
            current = maze.getEnd().getPrevious();

            // redrawing the maze with x's
            while (current.getPrevious() != null)
            {
                if (current.getType() != 'E')
                    current.setType('x');
                track.push(current);

                current = current.getPrevious();
            }

            // getting the return message
            Square sq;
            int count = 1;
            while (track.size() != 0)
            {
                sq = (Square) track.pop();
                message += "[" + sq.getRow() + ", " + sq.getCol() + "] -->";
                
                if (count == 4)
                {
                    message += "\n";
                    count = 0;
                }
                count++;
            }
            message = message.substring(0, message.length()-4);
        }
        else
            message = "No such path exists";
        
        return message;
    }


    public Square step(){
        if (this.worklist.size() == 0) return null;

        current = (Square) this.worklist.pop();
        
        //#ADD changed some stuff here in regards to treating '_' and 'E' squares
        ArrayList<Square> neighbors = maze.getNeighbors(current);
        for (Square sq : neighbors){
            if (sq.getPrevious() == null && (sq.getType() == '_' || sq.getType() == 'E'))
            {
                if (sq.getType() == '_') {
                    // determine if it's a first or second path
                    if (neighbors.indexOf(sq) == neighbors.size() - 1)
                        sq.setType('.');
                    else
                        sq.setType('o');
                }
                // connect this square to the previous one
                sq.setPrevious(current);
                this.worklist.push(sq);
            }
        }
        
        // Update the current square
        if (current.getType() != 'S' && current.getType() != 'E')
            current.setType('.');

        //#ADD edit condition here
        if (isSolved())
            getPath();
            
        return current;
    }


    public void solve(){
        // call step method until it is solved
        while (!isSolved() || this.worklist.size() != 0){
            step();
        }
        getPath();
    }
}
