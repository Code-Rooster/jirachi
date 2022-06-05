package roosterwithhands;

import java.awt.event.*;
import java.awt.Component;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialPalenightContrastIJTheme;

public class GUIManager
{
    public static void StartGUI(JFrame frame)
    {
        FlatMaterialPalenightContrastIJTheme.setup();

        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run()
            {
                CreateAndShowGUI(frame);
            }
        });
    }

    public static void CreateAndShowGUI(JFrame frame)
    {
        frame = new JFrame("Pokemon Mystery Manager");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel mapLabel = new JLabel(App.map);
        JPanel mapPanel = new JPanel();
        mapPanel.add(mapLabel);

        MouseManager.AddMouseListeners(frame);

        frame.add(mapPanel);

        frame.pack();
        frame.setVisible(true);
    }

    public static void ZoomIn(JFrame frame, Point mousePos, float amount)
    {
        
    }

    public static void CreateAndShowNewAreaGUI()
    {
        JDialog newAreaDialog = new JDialog(App.frame, "Create new area");
        newAreaDialog.add(new NewAreaDialog());

        newAreaDialog.pack();
        newAreaDialog.setVisible(true);
    }

    public static void ShowContextMenu(Component invoker, JPopupMenu menuToShow)
    {
        menuToShow.show(invoker, MouseManager.lastMousePos.x, MouseManager.lastMousePos.y);
    }

    public static JPopupMenu overNothing = new JPopupMenu()
    {{
        JMenuItem newArea = new JMenuItem("Create new area");
        newArea.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // Handle the creation of a new area
                CreateAndShowNewAreaGUI();
            }
        });
        add(newArea);
    }};
}
