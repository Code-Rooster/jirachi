package roosterwithhands;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

import java.awt.event.*;
import java.awt.event.MouseEvent;

public class MouseManager {
    public static Point lastMousePos;

    public static void AddMouseListeners(JFrame frame)
    {
        frame.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(SwingUtilities.isRightMouseButton(e))
                {
                    // Handle right mouse button clicked

                    if(Operations.GetNearestArea(Operations.FrameToWorldPoint(lastMousePos, App.guiManager.jirachiFrame.mapPanel)) != null)
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
            @Override
            public void mouseMoved(MouseEvent e)
            {
                lastMousePos = new Point(e.getX(), e.getY());

                App.guiManager.jirachiFrame.mapPanel.repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e))
                {
                    lastMousePos = new Point(e.getX(), e.getY());
                    Point p = Operations.FrameToWorldPoint(new Point(e.getX(), e.getY()), App.guiManager.jirachiFrame.mapPanel);
                    System.out.println(p.x + ", " + p.y);
                }
                super.mouseDragged(e);
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
