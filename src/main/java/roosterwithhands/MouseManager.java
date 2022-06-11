package roosterwithhands;

import java.awt.*;
import java.awt.event.*;

import javax.swing.SwingUtilities;

public class MouseManager extends MouseAdapter
{
    public JirachiContainer jContainer;

    public MouseManager(Container container, JirachiContainer jC)
    {
        AddMouseListeners(container);

        jContainer = jC;
    }

    public void AddMouseListeners(Container container)
    {
        container.addMouseListener(this);
        
        container.addMouseMotionListener(this);

        container.addMouseWheelListener(this);
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        super.mouseMoved(e);

        jContainer.HandleMouseMoved(new Point(e.getX(), e.getY()));
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        super.mouseClicked(e);

        if(SwingUtilities.isRightMouseButton(e))
        {
            jContainer.HandleRightClick();
        }
        else if(SwingUtilities.isLeftMouseButton(e))
        {
            jContainer.HandleLeftClick();
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        super.mouseWheelMoved(e);

        jContainer.HandleMouseWheelMoved(e.getWheelRotation());
    }
}
