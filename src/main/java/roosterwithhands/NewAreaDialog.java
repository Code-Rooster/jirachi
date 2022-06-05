package roosterwithhands;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JTextField;

public class NewAreaDialog extends JPanel implements ActionListener {
    protected JLabel nameLabel;
    protected JLabel label;
    protected JTextField areaNameField;
    protected JButton confirmButton;

    String name;

    public NewAreaDialog()
    {
        super(new GridBagLayout());

        nameLabel = new JLabel("Name of new area: ");
        areaNameField = new JTextField(10);
        areaNameField.addActionListener(this);
        areaNameField.addActionListener(this);
        confirmButton = new JButton("Confirm");

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        add(nameLabel, c);

        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        add(areaNameField, c);

        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        add(confirmButton, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("action performed");
        name = areaNameField.getText();
    }
}
