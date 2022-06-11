package roosterwithhands.Encounters;

import javax.swing.JDialog;

import roosterwithhands.JirachiContainer;
import roosterwithhands.MouseManager;
import roosterwithhands.Point;

public class EncounterDialog extends JDialog implements JirachiContainer
{
    MouseManager mouseManager;

    public EncounterDialog()
    {
        mouseManager = new MouseManager(this, this);
    }

    @Override
    public void HandleMouseMoved(Point newPos) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void HandleMouseWheelMoved(int amount) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void HandleRightClick() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void HandleLeftClick() {
        // TODO Auto-generated method stub
        
    }
}
