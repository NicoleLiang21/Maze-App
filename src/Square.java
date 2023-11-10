public class Square {

    private int type;
    private int row, col;
    private Square previous;

    /*
     * Constructor for the Square class
     */
    public Square(int r, int c, int t)
    {
        type = t;
        row = r;
        col = c;
        previous = null;
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
     *  Change the type
     *  @param int t
     */
    public void setType(int t)
    {
        type = t;
    }

    /*
     *  Accessor method for prevoius
     *  @return Square
     */
    public Square getPrevious()
    {
        return previous;
    }

    /*
     *  Connect this square to the previous one
     *  @param Square sq
     */
    public void setPrevious(Square sq)
    {
        previous = sq;
    }

    /*
     * toString method for this class
     * We chose to display in symbols, but we take the type as a number since that's the way in which the source file was programmed
     */
    public String toString()
    {
        switch (type)
        {
            case '_':
                return "_";
            case '#':
                return "#";
            case 'S':
                return "S";
            case 'E':
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
