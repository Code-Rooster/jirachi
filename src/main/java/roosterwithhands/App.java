package roosterwithhands;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import roosterwithhands.Areas.AreaManager;
import roosterwithhands.GUI.GUIManager;
import roosterwithhands.JirachiBot.JirachiBot;

import javax.security.auth.login.LoginException;

public class App extends JFrame
{
    public static AreaManager areaManager = new AreaManager();
    public static Point lastMousePos;

    public static ImageIcon map = new ImageIcon("src/images/map.png");

    public static GUIManager guiManager = new GUIManager();

    public static List<JirachiContainer> openJContainers = new ArrayList<JirachiContainer>();
    public static void main(String[] args) throws LoginException, InterruptedException
    {
        guiManager.StartGUI();
        
        JirachiBot.StartBot();
    }
}
