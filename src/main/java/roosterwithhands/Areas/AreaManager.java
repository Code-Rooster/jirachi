package roosterwithhands.Areas;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AreaManager {
    // Maybe make this a dictionary later? (only if needed)
    public List<Area> areas = new ArrayList<Area>();

    ObjectMapper mapper = new ObjectMapper();

    public AreaManager()
    {
        try 
        {
            FileReader jsonFile = new FileReader("src/Areas.json");

            try
            {
                Area[] areaArray = mapper.readValue(jsonFile, Area[].class);
                areas = new ArrayList<Area>(Arrays.asList(areaArray));
            }
            catch(JsonProcessingException e)
            {
                e.printStackTrace();
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public void AddArea(Area area)
    {
        if(!areas.contains(area))
        {
            areas.add(area);

            SaveAreaJSON();
        }
        else
        {
            System.err.println(area.name + " was already contained within the list of areas.");
        }
    }

    public void RemoveArea(Area area)
    {
        if(areas.contains(area))
        {
            areas.remove(area);

            SaveAreaJSON();
        }
        else
        {
            System.err.println(area.name + " was not found in the list of areas and as such could not be removed.");
        }
    }

    private void SaveAreaJSON()
    {
        try
        {
            String json = mapper.writeValueAsString(areas);
            FileWriter jsonFile;
            try 
            {
                jsonFile = new FileWriter("src/Areas.json");
                jsonFile.write(json);
                jsonFile.flush();
                jsonFile.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
        catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
    }
}
