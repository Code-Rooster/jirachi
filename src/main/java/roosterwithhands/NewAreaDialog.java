package roosterwithhands;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JTextField;

public class NewAreaDialog extends JPanel implements ActionListener 
{
    protected JLabel nameLabel;
    protected JTextField areaNameField;

    protected JLabel songLabel;
    protected JTextField songPathField;
    protected JButton songChooserButton;
    protected JFileChooser songChooser;

    protected JButton confirmButton;

    String name;

    public NewAreaDialog(JDialog parent)
    {
        super(new GridBagLayout());
        
        App.inDialog = true;

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
                    Operations.FrameToWorldPoint(MouseManager.lastMousePos, 
                    App.guiManager.jirachiFrame.mapPanel), songPathField.getText());

            App.guiManager.jirachiFrame.mapPanel.repaint();
            App.inDialog = false;

            App.guiManager.newAreaDialog.dispose();
        }

        System.out.println("action performed");
        name = areaNameField.getText();
    }
}
