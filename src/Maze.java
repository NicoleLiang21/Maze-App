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
             
            // Setting up and verifying number of rows/columns
            row = scan.nextInt();
            col = scan.nextInt();
            /* 
            // Second scanner
            Scanner scan2 = new Scanner(new File(fname));

            // Rows
            scan2.nextLine();

            int rowC = 0;
            while (scan2.hasNextLine())
            {
                rowC++;
                scan2.nextLine();
            }
            if (rowC != row)
            {
                System.out.println("Invalid, number of rows described does not match with actual number");
                return false;
            }

            // Columns
            Scanner scan3 = new Scanner(new File(fname));
            scan3.nextLine();

            String line = scan3.nextLine();
            int colC = 2;
            
            while (line.contains(" "))
            {
                colC++;
                line = line.substring(line.indexOf(" "));
            }
            if (colC != col)
            {
                System.out.println("Invalid, number of columns described does not match with actual number");
                return false;
            }
            */

            // Create the maze
            int[] types = new int[col*row];
            int count = 0;
            
            while (scan.hasNext()){

                // Convert from numbers to symbols
                switch (scan.nextInt())
                {
                    case 0:
                        types[count] = '_';
                        break;
                    case 1:
                        types[count] = '#';
                        break;
                    case 2:
                        types[count] = 'S';
                        break;
                    case 3:
                        types[count] = 'E';
                        break;
                }
                count++;
                
            }

            maze = new Square[row][col];
            count = 0;
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    maze[i][j] = new Square(i, j, types[count]);
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
        if (c != col - 1)  list.add(maze[r][c+1]);
        if (r != row - 1)  list.add(maze[r+1][c]);
        if (r != 0) list.add(maze[r-1][c]);
        if (c != 0)  list.add(maze[r][c-1]);
        
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
                    if (maze[i][j].getType() == 'S'){
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
                    if (maze[i][j].getType() == 'E'){
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
                data += "\n";
            }
        return data;
    }
}