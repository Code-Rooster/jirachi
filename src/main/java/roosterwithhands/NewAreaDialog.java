package roosterwithhands;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JTextField;

public class NewAreaDialog extends JPanel implements ActionListener 
{
    protected JLabel nameLabel;
    protected JTextField areaNameField;
    protected JButton confirmButton;

    String name;

    public NewAreaDialog(JDialog parent)
    {
        super(new GridBagLayout());
        
        App.inDialog = true;

        nameLabel = new JLabel("Name of new area: ");
        areaNameField = new JTextField(10);
        areaNameField.addActionListener(this);
        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Area newArea = new Area(areaNameField.getText(), Operations.FrameToWorldPoint(MouseManager.lastMousePos, App.guiManager.jirachiFrame.mapPanel), null);
                App.guiManager.jirachiFrame.mapPanel.repaint();
                App.inDialog = false;

                parent.dispose();
            }
        });

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        add(nameLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        add(areaNameField, c);

        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 2;
        c.gridheight = 1;
        add(confirmButton, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("action performed");
        name = areaNameField.getText();
    }
}
