package roosterwithhands;

import java.util.ArrayList;
import java.util.List;

public class AreaManager {
    // Maybe make this a dictionary later? (only if needed)
    public List<Area> areas = new ArrayList<Area>();

    public AreaManager()
    {
        //areas = List.of(new Area("Test Area", new Point(100, 100), null));
    }

    public void AddArea(Area area)
    {
        if(!areas.contains(area))
        {
            areas.add(area);
        }
    }

    public void RemoveArea(Area area)
    {
        if(areas.contains(area))
        {
            areas.remove(area);
        }
        else
        {
            System.err.println(area.name + " was not found in the list of areas and as such could not be removed.");
        }
    }
}
