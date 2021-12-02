package Front;
import javax.swing.*;

import Back.Generate;
import Back.Parser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
public class Frame 
{
    private static JFrame f;
    private JLabel label, language;

    private Parser parser;
    private JTextArea words_generator, user_area;
    public Frame()
    {
        allLabel();
        textArea();
        settingsFrame();
        
        parser = new Parser();

        addObject();
        addListener();
        
        new Generate(words_generator,language.getText(), parser);

        f.setVisible(true);
    }    
    private void settingsFrame()
    {
        f = new JFrame("TextField Example");
        f.setSize(800,600);
        f.setResizable(false);
        f.setTitle("Text static information 1.0");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
    }
    private void allLabel()
    {
        Label class_label = new Label();
        label = class_label.getLabel1();
        language = class_label.getLanguage();

    }

    private void textArea()
    {
        Area area = new Area();
        words_generator = area.getArea();
        user_area = area.getAreaUser();
    }

    private void addObject()
    {
        f.add(label);
        f.add(language);
        f.add(words_generator);
        f.add(user_area);
    }

    private void addListener()
    {
        language.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)  
            {  
                if(language.getText().equals("Русский Язык"))
                {
                    language.setText("English");
                    new Generate(words_generator, language.getText(),parser);
                }
                else
                {
                    language.setText("Русский Язык");
                    new Generate(words_generator, language.getText(),parser);                    
                }
            } 
        });
    }
}
