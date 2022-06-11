package roosterwithhands;

import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JirachiFrame extends JFrame implements ComponentListener
{
    public float aspectRatio;
    MapPanel mapPanel;
    
    Point focalPoint = Point.zero;

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
        MouseManager.AddMouseListeners(this);

        mapPanel = App.guiManager.mapPanel;
        mapPanel.jirachiFrame = this;
        
        this.add(mapPanel);
        
        this.addComponentListener(this);
        
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
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {
        
    }

    @Override
    public void componentShown(ComponentEvent e) {
        
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        
    }
}
