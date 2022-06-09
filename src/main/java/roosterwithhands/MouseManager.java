package roosterwithhands;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

import java.awt.event.*;
import java.awt.event.MouseEvent;

public class MouseManager {
    public static Point lastMousePos;
    public static Point lastWorldPos;

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

                App.guiManager.jirachiFrame.mapPanel.repaint();
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
