package roosterwithhands;

import javax.swing.*;

import roosterwithhands.JirachiBot.JirachiBot;

import javax.security.auth.login.LoginException;

import java.util.List;

public class App extends JFrame
{
    public static List<Area> areas;
    public static Point lastMousePos;

    public static ImageIcon map = new ImageIcon("src/images/map.png");

    public static GUIManager guiManager = new GUIManager();

    public static void main(String[] args) throws LoginException, InterruptedException
    {
        guiManager.StartGUI();

        JirachiBot.StartBot();
    }
}
