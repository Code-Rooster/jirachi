package roosterwithhands.Encounters;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Pokemon {
    public static String spriteURLBase = "raw.githubusercontent.com/msikma/pokesprite/master/pokemon-gen8/regular/";
    
    public String name;

    public int baseHP;
    public int baseAttack;
    public int iD;
    
    private String getSlug()
    {
        return name.toLowerCase();
    }
    
    public Image getSprite()
    {
        ImageIcon spriteIcon = new ImageIcon(spriteURLBase + getSlug() + ".png");

        return spriteIcon.getImage();
    }
}
