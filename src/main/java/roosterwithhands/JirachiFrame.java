package roosterwithhands;

import java.awt.event.*;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class JirachiFrame extends JFrame implements ComponentListener
{
    public float aspectRatio;
    MapPanel mapPanel;

    public int panelX;
    public int panelY;

    public int panelWidth;
    public int panelHeight;

    public JirachiFrame()
    {
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

    @Override
    public void componentResized(ComponentEvent e) {
        Dimension newDimension = new Dimension(getWidth(), getHeight());

        Point focalPoint = new Point(0.5 * mapPanel.getWidth(), 0.5 * mapPanel.getHeight());

        if((float)newDimension.width / (float)newDimension.height > aspectRatio)
        {
            panelHeight = newDimension.height;
            panelWidth = (int)((aspectRatio) * newDimension.height);

            panelX = (int)((newDimension.width - panelWidth) / 2);
            panelY = 0;
        }
        else if((float)newDimension.width / (float)newDimension.height < aspectRatio)
        {
            panelHeight = (int)((1 / aspectRatio) * newDimension.width);
            panelWidth = newDimension.width;

            panelX = 0;
            panelY = (int)((newDimension.height - panelHeight) / 2);
        }
        else
        {
            panelWidth = newDimension.width;
            panelHeight = newDimension.height;

            panelX = 0;
            panelY = 0;
        }
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
    
    class FloatDimension
    {
        float width;
        float height;

        public FloatDimension(float w, float h)
        {
            this.width = w;
            this.height = h;
        }
    }
}
