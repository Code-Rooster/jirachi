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
            public void mouseClicked(MouseEvent e)
            {
                if(SwingUtilities.isRightMouseButton(e))
                {
                    // Handle right mouse button clicked

                    if(Operations.GetNearestArea(lastMousePos) != null)
                    {
                        // Handle clicking on an area
                    }
                    else
                    {
                        // Handle clicking on nothing

                        GUIManager.ShowContextMenu(e.getComponent(), GUIManager.overNothing);
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
            }
        });

        frame.addMouseWheelListener(new MouseAdapter() {
            public void mouseWheelMoved(MouseWheelEvent e)
            {
                int notches = e.getWheelRotation();
                System.out.println(notches);
            }
        });
    }
}
