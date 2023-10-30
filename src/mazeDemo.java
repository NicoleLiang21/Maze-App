public class mazeDemo{
    public static void main(String[] args)
    {
        String fileName = "src\\maze-invalid";
        Maze maze = new Maze();
        
        maze.loadMaze(fileName);
        maze.getNeighbors(maze.getStart());
        maze.getStart();
        maze.getEnd();

        maze.reset();
        System.out.println(maze);

    }
}