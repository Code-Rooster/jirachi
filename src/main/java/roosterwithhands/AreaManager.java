package roosterwithhands;

import java.util.List;

public class AreaManager {
    // Maybe make this a dictionary later? (only if needed)
    public static List<Area> areas;

    public static void AddArea(Area area)
    {
        areas.add(area);
    }

    public static void RemoveArea(Area area)
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
