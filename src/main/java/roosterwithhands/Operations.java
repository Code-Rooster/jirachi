package roosterwithhands;

import java.util.List;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JDialog;
//import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Operations implements ActionListener {
    public static Area GetNearestArea(Point targetPoint)
    {
        List<Area> areas = AreaManager.areas;

        if(areas != null && areas.size() > 0)
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

    public static float GetDistance(Point a, Point b)
    {
        return (float)Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }

    public static void CreateArea(Point p, JFrame parentFrame)
    {
        JDialog dialog = new JDialog(parentFrame, "Create a new Area");
        String songName = "None";
        JLabel chosenSong = new JLabel("Chosen song: " + songName);
        JButton button = new JButton("Choose Song");

        button.addActionListener(new Operations());

        //JFileChooser chooser = new JFileChooser();

        dialog.add(chosenSong);
        dialog.add(button);
        //dialog.add(chooser);

        dialog.pack();
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if(actionCommand.equals("Choose Song"))
        {
            
        }
    }
}
