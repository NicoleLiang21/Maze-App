public class mazeDemo{
    public static void main(String[] args)
    {
        String fileName = "src\\maze-1";
        Maze maze = new Maze();
        
        maze.loadMaze(fileName);
        
        //maze.getNeighbors(maze.getStart());
        System.out.println(maze.getStart());
        System.out.println(maze.getEnd());

        //maze.reset();
        //System.out.println(maze);
        

    }
}