package roosterwithhands;

import java.awt.Color;
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
        
        if(App.areaManager.areas != null)
        {
            for (Area area : App.areaManager.areas) 
            {   
                Point p = Operations.WorldToFramePoint(area.point, this).Subtract(new Point(10, 35));

                if(area != MouseManager.highlightedArea)
                {
                    g.setColor(new Color(0, 0, 1, 0.25f));
                    g.fillOval(p.x , p.y, 20, 20);
                }
                else
                {
                    int stringWidth = g.getFontMetrics().stringWidth(area.name);
                    int textX = p.x - (int) ((float) stringWidth / 2) + 2;

                    g.setColor(new Color(1, 1, 1, 0.75f));
                    g.fillRoundRect(textX, p.y - 20, stringWidth + 15, 15, 2, 2);
                    g.setColor(new Color(0, 0, 0, 255));
                    g.drawString(area.name, textX + 7, p.y - 8);
                    g.setColor(new Color(1, 1, 0, 0.5f));
                    g.fillOval(p.x , p.y, 20, 20);
                }
            }
        }
    }
}
