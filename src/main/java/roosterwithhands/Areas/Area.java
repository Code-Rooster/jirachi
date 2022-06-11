package roosterwithhands.Areas;

import com.fasterxml.jackson.annotation.JsonProperty;

import roosterwithhands.App;
import roosterwithhands.Point;

public class Area implements java.io.Serializable
{
    public String name;

    public Point point;

    public String areaTheme;

    public Area(@JsonProperty("name") String n, @JsonProperty("point") Point p, @JsonProperty("areaTheme") String mus)
    {
        this.name = n;
        this.point = p;
        this.areaTheme = mus;

        if(App.areaManager != null)
        {
            App.areaManager.AddArea(this);
        }
    }
}
