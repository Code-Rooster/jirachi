package roosterwithhands;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MapPanel extends JPanel
{
    public ImageIcon map = new ImageIcon("src/images/map.png");

    public JirachiFrame jirachiFrame;

    public int zoomAmount = 0;
    public int zoomRange = 10;

    float initDiagLen = Operations.GetDistance(Point.zero, new Point(map.getIconWidth(), map.getIconHeight()));

    public void ChangeZoom(int amount, Point zoomPos)
    {
        zoomAmount = Operations.IntClamp(zoomAmount += amount, -zoomRange, zoomRange);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        float newDiagLen = (initDiagLen + (zoomAmount * 100));

        int newWidth = 0;
        int newHeight = 0;

        newWidth = (int) ((newDiagLen * App.guiManager.jirachiFrame.aspectRatio) / Math.sqrt(Math.pow(App.guiManager.jirachiFrame.aspectRatio, 2) + 1));
        newHeight = (int) (newDiagLen / Math.sqrt(Math.pow(App.guiManager.jirachiFrame.aspectRatio, 2) + 1));

        System.out.println(App.guiManager.jirachiFrame.aspectRatio);
        
        g.drawImage(map.getImage(), jirachiFrame.panelX, jirachiFrame.panelY, newWidth, newHeight, this);
    }
}
