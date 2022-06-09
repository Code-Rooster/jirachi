package roosterwithhands;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MapPanel extends JPanel
{
    public ImageIcon map = new ImageIcon("src/images/map.png");

    public JirachiFrame jirachiFrame;

    public int zoomAmount = 0;
    public int zoomRange = 10;

    public Rectangle panelRect;

    float initDiagLen = Operations.GetDistance(Point.zero, new Point(map.getIconWidth(), map.getIconHeight()));

    public void ChangeZoom(int amount, Point zoomPos)
    {
        if((zoomAmount > 0 && amount < 0) || (zoomAmount < zoomRange && amount > 0))
        {
            zoomAmount = Operations.IntClamp(zoomAmount += amount, 0, zoomRange);

            jirachiFrame.focalPoint = Operations.FrameToWorldPoint(MouseManager.lastMousePos, this).ClampRect(0, map.getIconWidth(), 0, map.getIconHeight());

            repaint();
        }
    }

    public float GetCurrentDiagLen()
    {
        return initDiagLen + (zoomAmount * 100);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        panelRect = jirachiFrame.RecalculateRect();
        
        g.drawImage(map.getImage(), panelRect.x, panelRect.y, panelRect.width, panelRect.height, this);

        //g.fillRect(MouseManager.lastWorldPos.x, MouseManager.lastWorldPos.y, 20, 20);
    }
}
