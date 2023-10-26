public class Square {

    private char type;
    private int row, col;

    /*
     * Constructor for the Square class
     */
    public Square(int r, int c, char t)
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
    public char getType()
    {
        return type;
    }

    /*
     * toString method for this class
     * G
     */
    public String toString()
    {
        switch (type)
        {
            case '#':
                return "#";
            case '_':
                return "_";
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
