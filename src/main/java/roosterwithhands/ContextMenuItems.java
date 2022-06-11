package roosterwithhands;

import java.awt.event.*;

import javax.swing.JMenuItem;

import roosterwithhands.JirachiBot.JirachiBot;

public class ContextMenuItems implements ActionListener
{
    public JMenuItem newArea = new JMenuItem("Create new area");
    public JMenuItem changeMap = new JMenuItem("Change map");

    public JMenuItem goHere = new JMenuItem("Go here");
    public JMenuItem editArea = new JMenuItem("Edit area");
    public JMenuItem deleteArea = new JMenuItem("Delete area");
    

    public ContextMenuItems()
    {
        newArea.addActionListener(this);
        changeMap.addActionListener(this);

        goHere.addActionListener(this);
        editArea.addActionListener(this);
        deleteArea.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newArea)
        {
            App.guiManager.CreateAndShowNewAreaGUI();
        }
        else if(e.getSource() == changeMap)
        {
            App.guiManager.ChangeMap();
        }
        else if(e.getSource() == goHere)
        {
            App.guiManager.mapPanel.repaint();
            App.guiManager.mapPanel.currentLocationLabel.setText("Current Location: " + MouseManager.selectedArea.name);
            JirachiBot.PlayMusic(MouseManager.selectedArea.areaTheme);
        }
        else if(e.getSource() == editArea)
        {

        }
        else if(e.getSource() == deleteArea)
        {
            App.areaManager.RemoveArea(MouseManager.selectedArea);
            App.guiManager.mapPanel.repaint();
        }
    }
}
