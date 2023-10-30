import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Maze{

    private Square[][]maze;
    private int col;
    private int row;
    /*
     * Load the maze from a provided file
     * @return success or fail
     */
    public boolean loadMaze(String fname)
    {
        try (Scanner scan = new Scanner(new File(fname)))
        {

            col = scan.nextInt();
            row = Integer.parseInt(scan.next().substring(1));

            int[] types = new int[col*row];
            int count = 0;
            while (scan.hasNext()){
                types[count] = scan.nextInt();
                count++; 
            }
            System.out.println(types);


            maze = new Square[col][row];
            count = 0;
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    maze[i][j] = new Square(i,j,types[count]);
                    count++;
                }

            }
            return true;
        }
        catch (FileNotFoundException e)
        {
            return false;
        }
    }

    /*
     * Gets the neighbors of the current square in the maze
     * @return list of neighbors
     * @param the square
     */
    public ArrayList<Square> getNeighbors(Square sq)
    {
        ArrayList<Square> list = new ArrayList<>();
        int r = sq.getRow();
        int c = sq.getCol();
        if (c < col)  list.add(maze[r][c+1]);
        if (r < row)  list.add(maze[r+1][c]);
        if (r > 0) list.add(maze[r-1][c]);
        if (c > 0)  list.add(maze[r][c-1]);
        
        return list;

    }

    /*
     * Gets the starting square
     * @return the starting square
     */
    public Square getStart()
    {
        for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    if (maze[i][j].getType() == 2){
                        return maze[i][j];
                    }
                }

            }
            return null;
    }

    /*
     * Gets the ending square
     * @return the ending square
     */
    public Square getEnd()
    {
        for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    if (maze[i][j].getType() == 3){
                        return maze[i][j];
                    }
                }

            }
            return null;
    }

    /*
     * Clean the maze
     */
    public void reset()
    {
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (maze[i][j].getType() == 'o' || maze[i][j].getType() == '.' || maze[i][j].getType() == 'x'){
                    maze[i][j] = new Square(i, j, '_');
                }
            }
        }
    }

    /*
     * String representation of this maze
     * @return a print-friendly version of this maze
     */
    public String toString()
    {
        String data = "";
        for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    data += maze[i][j];
                }

            }
        return data;
    }
}