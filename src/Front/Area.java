package Front;
import javax.swing.*;
import java.awt.Font;

// import Back.ListenerArea;

public class Area 
{
    private JTextArea area;
    private JTextArea user_area;
    // private ListenerArea listenArea;
    public Area()
    {
        area = new JTextArea("");
        area.setLineWrap(true);
        area.setWrapStyleWord(true); 
        area.setBounds(50,50, 600,200);

        user_area = new JTextArea("");
        user_area.setBounds(50,300, 600, 200);

        Font font = new Font("Verdana", Font.BOLD, 18); // для размера и дизайна
        area.setFont(font);       

        user_area.setFont(font);
    }
    public JTextArea getArea()
    {
        return area;
    }
    public JTextArea getAreaUser()
    {
        return user_area;
    }




}