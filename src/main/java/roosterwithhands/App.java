package roosterwithhands;

import javax.swing.*;
import javax.security.auth.login.LoginException;

import java.util.List;

public class App extends JFrame
{
    public static List<Area> areas;
    public static Point lastMousePos;
    public static JFrame frame;

    public static ImageIcon map = new ImageIcon("src/images/map.png");

    public static void main(String[] args) throws LoginException, InterruptedException
    {
        GUIManager.StartGUI(frame);

        JirachiBot.StartBot();
    }
}
