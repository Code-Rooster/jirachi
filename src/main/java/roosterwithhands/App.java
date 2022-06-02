package roosterwithhands;

import javax.security.auth.login.LoginException;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.*;
import java.awt.*;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialPalenightContrastIJTheme;

public class App extends JFrame
{
    public static List<Area> areas;
    public static Point lastMousePos;

    public static void main( String[] args ) throws LoginException, InterruptedException
    {
        FlatMaterialPalenightContrastIJTheme.setup();

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run()
         {
             CreateAndShowGUI();
         }});
        
        JirachiBot.StartBot();
    }

    private static void CreateAndShowGUI()
    {
        JFrame frame = new JFrame("Pokemon Mystery Manager");
        frame.setIconImage(new ImageIcon("src/images/shaymin.jpg").getImage());
        
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel emptyLabel = new JLabel("");
        emptyLabel.setIcon(new ImageIcon("src/images/map.png"));

        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        frame.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e)
            {
                if(SwingUtilities.isRightMouseButton(e))
                {
                    overNothing.show(frame, e.getX(), e.getY());
                }
            }
        });

        frame.addMouseMotionListener(new MouseInputAdapter() 
        {
            public void mouseMoved(MouseEvent e)
            {
                lastMousePos = new Point(e.getX(), e.getY());
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    private static JPopupMenu overArea = new JPopupMenu()
    {{
        add(new JMenuItem("Visit Area"));
        add(new JMenuItem("Edit Area"));
        addSeparator();
        add(new JMenuItem("Delete Area"));
    }};

    private static JPopupMenu overNothing = new JPopupMenu()
    {{
        JMenuItem newArea = new JMenuItem("New Area");
        newArea.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Operations.CreateArea(lastMousePos);
            }
        });
        add(newArea);
    }};
}
