package roosterwithhands;

import java.util.List;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JDialog;
//import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import roosterwithhands.Areas.Area;
import roosterwithhands.GUI.MapPanel;

public class Operations implements ActionListener {
    public static Area GetNearestArea(Point targetWorldPoint)
    {
        List<Area> areas = App.areaManager.areas;

        if(areas != null && areas.size() > 0)
        {
            int areaRadius = 50;
            Area currentClosestArea = areas.get(0);
            float currentShortestDistance = GetDistance(targetWorldPoint, currentClosestArea.point);

            for (Area area : areas)
            {
                float newDist = GetDistance(targetWorldPoint, area.point);
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

    public static int IntClamp(int original, int min, int max)
    {
        return (original > max ? max : original < min ? min : original);
    }

    public static float FloatClamp(float original, float min, float max)
    {
        return (original > max ? max : original < min ? min : original);
    }

    public static void CreateArea(Point p, JFrame parentFrame)
    {
        JDialog dialog = new JDialog(parentFrame, "Create a new Area");
        String songName = "None";
        JLabel chosenSong = new JLabel("Chosen song: " + songName);
        JButton button = new JButton("Choose Song");

        button.addActionListener(new Operations());

        dialog.add(chosenSong);
        dialog.add(button);

        dialog.pack();
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static Point FrameToWorldPoint(Point p, MapPanel mapPanel)
    {
        Vector2 v = new Vector2((float) p.x, (float) p.y);

        v = v.Subtract(new Vector2(mapPanel.panelRect.x, mapPanel.panelRect.y));
        
        v = v.Divide(mapPanel.GetCurrentDiagLen() / mapPanel.initDiagLen);

        v.x = FloatClamp(v.x, 0, mapPanel.map.getIconWidth());
        v.y = FloatClamp(v.y, 0, mapPanel.map.getIconHeight());

        Point worldPoint = new Point(Math.round(v.x), Math.round(v.y)).ClampRect(0, mapPanel.map.getIconWidth(), 0, mapPanel.map.getIconHeight());

        return worldPoint;
    }

    public static Point WorldToFramePoint(Point p, MapPanel mapPanel)
    {
        Vector2 v = new Vector2((float) p.x, (float) p.y);

        v = v.Multiply(mapPanel.GetCurrentDiagLen() / mapPanel.initDiagLen);

        v = v.Add(new Vector2(mapPanel.panelRect.x, mapPanel.panelRect.y));

        Point framePoint = new Point(Math.round(v.x), Math.round(v.y));

        return framePoint;
    }
}
