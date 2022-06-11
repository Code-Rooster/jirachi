package roosterwithhands.GUI;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import roosterwithhands.App;
import roosterwithhands.JirachiContainer;
import roosterwithhands.MouseManager;
import roosterwithhands.Operations;
import roosterwithhands.Point;
import roosterwithhands.Areas.Area;

public class JirachiFrame extends JFrame implements JirachiContainer
{
    public float aspectRatio;
    public MapPanel mapPanel;

    public Area highlightedArea;
    public Area selectedArea;

    public MouseManager mouseManager;
    
    public Point mousePos;
    public Point focalPoint = Point.zero;

    public JirachiFrame()
    {
        List<Image> icons = new ArrayList<Image>();
        icons.add(new ImageIcon("src/images/shayminIcon16.png").getImage());
        icons.add(new ImageIcon("src/images/shayminIcon32.png").getImage());
        icons.add(new ImageIcon("src/images/shayminIcon64.png").getImage());
        icons.add(new ImageIcon("src/images/shayminIcon128.png").getImage());

        this.setIconImages(icons);

        ImageIcon map = App.guiManager.mapPanel.map;
        aspectRatio = (float)map.getIconWidth() / (float)map.getIconHeight();

        this.setTitle("Pokemon Mystery Manager");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        mouseManager = new MouseManager(this, this);

        mapPanel = App.guiManager.mapPanel;
        mapPanel.jirachiFrame = this;
        
        this.add(mapPanel);
        
        this.setPreferredSize(new Dimension(map.getImage().getWidth(this), map.getImage().getHeight(this)));
        
        this.pack();
        
        this.setLocationRelativeTo(null);
        
        this.setVisible(true);
    }

    public Rectangle RecalculateRect()
    {
        Rectangle rect = new Rectangle();

        rect.width = (int) ((mapPanel.GetCurrentDiagLen() * aspectRatio) / Math.sqrt(Math.pow(aspectRatio, 2) + 1));
        rect.height = (int) (mapPanel.GetCurrentDiagLen() / Math.sqrt(Math.pow(App.guiManager.jirachiFrame.aspectRatio, 2) + 1));

        rect.x = (int) ((float) (rect.width - getWidth()) / -((float) mapPanel.getWidth() / (float) focalPoint.x));
        rect.y = (int) ((float) (rect.height - getHeight()) / -((float) mapPanel.getHeight() / (float) focalPoint.y));
        
        return rect;
    }

    @Override
    public void HandleMouseMoved(Point newPos) 
    {
        mousePos = newPos;
        Point worldPos = Operations.FrameToWorldPoint(newPos, mapPanel);

        highlightedArea = Operations.GetNearestArea(Operations.FrameToWorldPoint(newPos, mapPanel));

        mapPanel.repaint();
    }

    @Override
    public void HandleMouseWheelMoved(int amount)
    {
        focalPoint = mousePos;
        mapPanel.ChangeZoom(amount);
    }

    @Override
    public void HandleRightClick() {
        if(highlightedArea != null)
        {
            selectedArea = highlightedArea;
            App.guiManager.ShowContextMenu(this, App.guiManager.overArea);
        }
        else
        {
            App.guiManager.ShowContextMenu(this, App.guiManager.overNothing);
        }
    }

    @Override
    public void HandleLeftClick() {

    }
}
