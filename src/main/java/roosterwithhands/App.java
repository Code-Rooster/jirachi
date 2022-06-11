package roosterwithhands;

import javax.swing.*;

import roosterwithhands.JirachiBot.JirachiBot;

import javax.security.auth.login.LoginException;

public class App extends JFrame
{
    public static AreaManager areaManager = new AreaManager();
    public static Point lastMousePos;

    public static ImageIcon map = new ImageIcon("src/images/map.png");

    public static GUIManager guiManager = new GUIManager();

    public static boolean inDialog = false;

    public static void main(String[] args) throws LoginException, InterruptedException
    {
        guiManager.StartGUI();
        
        JirachiBot.StartBot();
    }
}
