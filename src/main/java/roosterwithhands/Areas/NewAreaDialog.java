package roosterwithhands.Areas;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JTextField;

import roosterwithhands.App;
import roosterwithhands.JirachiContainer;
import roosterwithhands.Operations;
import roosterwithhands.Point;

public class NewAreaDialog extends JPanel implements ActionListener, JirachiContainer
{
    protected JLabel nameLabel;
    protected JTextField areaNameField;

    protected JLabel songLabel;
    protected JTextField songPathField;
    protected JButton songChooserButton;
    protected JFileChooser songChooser;

    protected JButton confirmButton;

    String name;

    public NewAreaDialog()
    {
        super(new GridBagLayout());
        
        nameLabel = new JLabel("Name of new area: ");
        areaNameField = new JTextField(20);

        songLabel = new JLabel("Path/URL of song: ");
        songPathField = new JTextField(15);
        songChooserButton = new JButton("...");
        songChooserButton.addActionListener(this);

        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(this);

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        add(nameLabel, c);

        c.gridx = 1;
        c.gridwidth = 2;
        add(areaNameField, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(songLabel, c);

        c.gridx = 1;
        add(songPathField, c); 

        c.gridx = 2;
        add(songChooserButton, c);

        c.gridx = 2;
        c.gridy = 2;
        add(confirmButton, c);

        App.openJContainers.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == songChooserButton)
        {
            songChooser = new JFileChooser(System.getProperty("user.dir"));
            this.add(songChooser);
            int songChooserResult = songChooser.showOpenDialog(this);

            if(songChooserResult == JFileChooser.APPROVE_OPTION)
            {
                String filePath = songChooser.getSelectedFile().getAbsolutePath();

                songPathField.setText(filePath);
            }
        }

        if(e.getSource() == confirmButton)
        {
            Area newArea = new Area(areaNameField.getText(), 
                    Operations.FrameToWorldPoint(App.guiManager.jirachiFrame.mousePos, 
                    App.guiManager.jirachiFrame.mapPanel), songPathField.getText());

            App.guiManager.jirachiFrame.mapPanel.repaint();

            App.openJContainers.remove(this);

            App.guiManager.newAreaDialog.dispose();
        }

        System.out.println("action performed");
        name = areaNameField.getText();
    }

    

    @Override
    public void HandleMouseMoved(Point newPos) {
        
    }

    @Override
    public void HandleMouseWheelMoved(int amount) {
        
    }

    @Override
    public void HandleRightClick() {
        
    }

    @Override
    public void HandleLeftClick() {
        
    }
}
