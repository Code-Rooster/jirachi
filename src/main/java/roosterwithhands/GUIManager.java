package roosterwithhands;

import java.awt.event.*;
import java.awt.Component;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialPalenightContrastIJTheme;

import roosterwithhands.JirachiBot.JirachiBot;

public class GUIManager
{
    public JirachiFrame jirachiFrame;
    public MapPanel mapPanel;

    public GUIManager()
    {
        FlatMaterialPalenightContrastIJTheme.setup();
    }

    public void StartGUI()
    {
        mapPanel = new MapPanel();
        jirachiFrame = new JirachiFrame();
    }

    public void CreateAndShowNewAreaGUI()
    {
        JDialog newAreaDialog = new JDialog(jirachiFrame, "Create new area");
        newAreaDialog.add(new NewAreaDialog());

        newAreaDialog.pack();
        newAreaDialog.setVisible(true);
    }

    public void ChangeMap()
    {
        JFileChooser mapChooser = new JFileChooser();

        jirachiFrame.add(mapChooser);
        //App.frame.pack();
    }

    public static void ShowContextMenu(Component invoker, JPopupMenu menuToShow)
    {
        menuToShow.show(invoker, MouseManager.lastMousePos.x, MouseManager.lastMousePos.y);
    }

    public JPopupMenu overNothing = new JPopupMenu()
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

        JMenuItem changeMap = new JMenuItem("Change map");
        changeMap.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                ChangeMap();
            }
        });
        add(changeMap);

        addSeparator();

        JMenuItem playTestMusic = new JMenuItem("Play test music in VC");
        playTestMusic.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JirachiBot.PlayTestMusic();
            }
        });
        add(playTestMusic);
    }};
}
