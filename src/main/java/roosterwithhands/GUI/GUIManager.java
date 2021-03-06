package roosterwithhands.GUI;

import java.awt.Component;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPopupMenu;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialPalenightContrastIJTheme;

import roosterwithhands.MouseManager;
import roosterwithhands.Areas.NewAreaDialog;
import roosterwithhands.Encounters.EncounterDialog;


public class GUIManager
{
    public JirachiFrame jirachiFrame;
    public MapPanel mapPanel;

    public JDialog newAreaDialog;
    public JDialog newEncounterDialog;
    
    private ContextMenuItems cMI;

    public JPopupMenu overNothing = new JPopupMenu();
    public JPopupMenu overArea = new JPopupMenu();

    public GUIManager()
    {
        // For some reason this doesn't work on mac?
        //FlatMaterialPalenightContrastIJTheme.setup();

        cMI = new ContextMenuItems();

        overNothing.add(cMI.newArea);
        overNothing.addSeparator();
        overNothing.add(cMI.changeMap);
        overNothing.add(cMI.newEncounter);

        overArea.add(cMI.goHere);
        overArea.addSeparator();
        overArea.add(cMI.editArea);
        overArea.addSeparator();
        overArea.add(cMI.deleteArea);
    }

    public void StartGUI()
    {
        mapPanel = new MapPanel();
        jirachiFrame = new JirachiFrame();
    }

    public void CreateAndShowNewAreaDialog()
    {
        newAreaDialog = new JDialog(jirachiFrame, "Create new area");
        newAreaDialog.add(new NewAreaDialog());

        newAreaDialog.pack();

        newAreaDialog.setLocationRelativeTo(null);

        newAreaDialog.setVisible(true);
    }

    public void CreateAndShowNewEncounterDialog()
    {
        newEncounterDialog = new EncounterDialog();
    }

    public void ChangeMap()
    {
        JFileChooser mapChooser = new JFileChooser();

        jirachiFrame.add(mapChooser);
    }

    public void ShowContextMenu(Component invoker, JPopupMenu menuToShow)
    {
        menuToShow.show(invoker, jirachiFrame.mousePos.x, jirachiFrame.mousePos.y);
    }
}
