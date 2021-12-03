package Front;
import javax.swing.*;

import Back.ListenerArea;

public class Area 
{
    private JTextArea area;
    private JTextArea user_area;
    private ListenerArea listenArea;
    public Area()
    {
        area = new JTextArea("");
        area.setLineWrap(true);
        area.setWrapStyleWord(true); 
        area.setBounds(50,50, 600,200);

        user_area = new JTextArea("");
        user_area.setBounds(50,300, 600, 200);

                  
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