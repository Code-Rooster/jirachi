package roosterwithhands;

public class Vector2 
{
    public float x;
    public float y;

    public Vector2(float xPos, float yPos)
    {
        this.x = xPos;
        this.y = yPos;
    }

    
    public Vector2 Add(Vector2 v)
    {
        return new Vector2(this.x + v.x, this.y + v.y);
    }

    public Vector2 Subtract(Vector2 v)
    {
        return new Vector2(this.x - v.x, this.y - v.y);
    }

    public Vector2 Multiply(float f)
    {
        return new Vector2((this.x * f), (this.y * f));
    }

    public Vector2 Divide(float f)
    {
        return new Vector2((this.x / f), (this.y / f));
    }

    public static Vector2 zero = new Vector2(0, 0);
}
