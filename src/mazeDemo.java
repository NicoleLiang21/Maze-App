public class mazeDemo{
    public static void main(String[] args)
    {
        String fileName = "Maze-App/src/maze-2";
        Maze maze = new Maze();
        
        maze.loadMaze(fileName);
        maze.getNeighbors(maze.getStart());
        maze.getStart();
        maze.getStart();
        maze.getEnd();
        
        System.out.println(maze);

        maze.reset();
        System.out.println(maze);

    }
}