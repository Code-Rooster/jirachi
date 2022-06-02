package roosterwithhands;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class Operations {
    public Area GetNearestArea(List<Area> areas, Point targetPoint)
    {
        if(areas.size() > 0)
        {
            int areaRadius = 10;
            Area currentClosestArea = areas.get(0);
            float currentShortestDistance = GetDistance(targetPoint, currentClosestArea.point);
            areas.remove(0);

            for (Area area : areas)
            {
                float newDist = GetDistance(targetPoint, area.point);
                if(newDist < currentShortestDistance)
                {
                    currentShortestDistance = newDist;
                    currentClosestArea = area;
                }
            }

            if(currentShortestDistance < areaRadius)
            {
                return currentClosestArea;
            }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }

    public float GetDistance(Point a, Point b)
    {
        return (float)Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }

    public static void CreateArea(Point p)
    {
        System.out.println("whoaaaa");

        JDialog dialog = new JDialog(App.getFrames()[0], "Create a new Area");
        String songName = "None";
        JLabel chosenSong = new JLabel("Chosen song: " + songName);

        JFileChooser chooser = new JFileChooser();

        chooser.showOpenDialog(dialog);
    }
}
