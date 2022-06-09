package roosterwithhands;

import javax.print.attribute.standard.Media;

public class Area
{
    public String name;

    public Point point;

    public Media themeMusic;

    public Area(String n, Point p, Media mus)
    {
        this.name = n;
        this.point = p;
        this.themeMusic = mus;

        App.areaManager.AddArea(this);
    }
}
