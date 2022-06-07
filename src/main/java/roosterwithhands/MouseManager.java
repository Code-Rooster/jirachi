package roosterwithhands;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

import java.awt.event.*;
import java.awt.event.MouseEvent;

public class MouseManager {
    public static Point lastMousePos;
    public static Point lastWorldPos;

    public static Point FrameToWorldPoint(JirachiFrame frame)
    {
        // Get the mouse position as a fraction of the frame size
        // (ex. if the frame is 100 px long and the mouse is located at x = 50, return v.x = 0.5)
        Vector2 v = new Vector2((float) lastMousePos.x / (float) frame.getWidth(), (float) lastMousePos.y / (float) frame.getHeight());

        // Multiply v by the width and height of the current map size
        v.x *= (float) frame.mapPanel.panelRect.width;
        v.y *= (float) frame.mapPanel.panelRect.height;

        // Multiply v by the scale factor of the map
        v.Multiply(frame.mapPanel.GetCurrentDiagLen() / frame.mapPanel.initDiagLen);

        // 
        v.Add(new Vector2(frame.mapPanel.panelRect.x, frame.mapPanel.panelRect.y));

        return new Point(Math.round(v.x), Math.round(v.y));
    }

    public static void AddMouseListeners(JFrame frame)
    {
        frame.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(SwingUtilities.isRightMouseButton(e))
                {
                    // Handle right mouse button clicked

                    if(Operations.GetNearestArea(lastWorldPos) != null)
                    {
                        // Handle clicking on an area
                    }
                    else
                    {
                        // Handle clicking on nothing

                        GUIManager.ShowContextMenu(e.getComponent(), App.guiManager.overNothing);
                    }
                }
                else if(SwingUtilities.isLeftMouseButton(e))
                {
                    // Handle left mouse button clicked

                }
            }
        });

        frame.addMouseMotionListener(new MouseInputAdapter()
        {
            public void mouseMoved(MouseEvent e)
            {
                lastMousePos = new Point(e.getX(), e.getY());

                lastWorldPos = FrameToWorldPoint(App.guiManager.jirachiFrame);

                App.guiManager.jirachiFrame.mapPanel.repaint();

                System.out.println(lastWorldPos.x + ", " + lastWorldPos.y);
            }
        });

        frame.addMouseWheelListener(new MouseAdapter() {
            public void mouseWheelMoved(MouseWheelEvent e)
            {
                int notches = e.getWheelRotation();
                App.guiManager.mapPanel.ChangeZoom(notches, lastMousePos);
            }
        });
    }
}
