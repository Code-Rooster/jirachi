package roosterwithhands;

public class Point
{
    int x;
    int y;

    public Point(int xPos, int yPos)
    {
        this.x = xPos;
        this.y = yPos;
    }

    public Point(float xPos, float yPos)
    {
        this.x = (int) Math.round(xPos);
        this.y = (int) Math.round(yPos);
    }
    
    public Point(Double xPos, Double yPos)
    {
        this.x = (int) Math.round(xPos);
        this.y = (int) Math.round(yPos);
    }

    public Point Add(Point p)
    {
        return new Point(this.x + p.x, this.y + p.y);
    }

    public Point Subtract(Point p)
    {
        return new Point(this.x - p.x, this.y - p.y);
    }

    public Point Multiply(float f)
    {
        return new Point((int) (this.x * f), (int) (this.y * f));
    }

    public Point Divide(float f)
    {
        return new Point((int) (this.x / f), (int) (this.y / f));
    }

    public Point ClampRect(int xMin, int xMax, int yMin, int yMax)
    {
        int newX = Operations.IntClamp(this.x, xMin, xMax);
        int newY = Operations.IntClamp(this.y, yMin, yMax);

        return new Point(newX, newY);
    }

    public static Point zero = new Point(0, 0);
}
