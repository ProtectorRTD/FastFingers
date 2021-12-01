package Front;
import javax.swing.*;
public class Label 
{
    private JLabel label, language;
    public Label()
    {
        label=new JLabel("Insert text here");
        label.setBounds(50,280,400,20);
        language = new JLabel("Русский Язык");
        language.setBounds(250,20, 400,20);
    }   
    public JLabel  getLabel1()
    {
        return label;
    }
    public JLabel getLanguage()
    {
        return language;
    }
    
}
