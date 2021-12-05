package Front;
import javax.swing.*;
public class Label 
{
    private JLabel label, language, Time;
    public Label()
    {
        label=new JLabel("Insert text here");
        label.setBounds(50,280,400,20);
        language = new JLabel("English");
        language.setBounds(250,20, 400,20);

        Time = new JLabel("1 : 00");
        Time.setBounds(450, 20, 400,20);
    }   
    public JLabel  getLabel1()
    {
        return label;
    }
    public JLabel getLanguage()
    {
        return language;
    }
    public JLabel getTime()
    {
        return Time;
    }
    
}
