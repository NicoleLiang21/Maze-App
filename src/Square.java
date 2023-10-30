public class Square {

    private int type;
    private int row, col;

    /*
     * Constructor for the Square class
     */
    public Square(int r, int c, int t)
    {
        type = t;
        row = r;
        col = c;
    }

    /*
     *  Accessor method for row
     *  @return int
     */
    public int getRow()
    {
        return row;
    }

    /*
     *  Accessor method for col
     *  @return int
     */
    public int getCol()
    {
        return col;
    }

    /*
     *  Accessor method for type
     *  @return int
     */
    public int getType()
    {
        return type;
    }

    /*
     * toString method for this class
     * We chose to display in symbols, but we take the type as a number since that's the way in which the source file was programmed
     */
    public String toString()
    {
        switch (type)
        {
            case 0:
                return "_";
            case 1:
                return "#";
            case 2:
                return "S";
            case 3:
                return "E";
            case 'o':
                return "o";
            case '.':
                return ".";
            case 'x':
                return "x";
            default:
                return null;
        }
    }

}
