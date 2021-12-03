package Front;
import javax.swing.*;

import Back.FinderWord;
import Back.Generate;
import Back.ListenerArea;
import Back.Parser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Frame 
{
    private static JFrame f;
    private JLabel label, language;

    private Parser parser;
    // private Users user;
    private Area area;
    private ListenerArea  listenArea;
    private JTextArea words_generator, user_area;
    private FinderWord finderWord;
    public Frame()
    {
        allLabel();
        settingsFrame();
        textArea();
        
        parser = new Parser();
        
        addObject();
        addListener();
        
        
        
        new Generate(words_generator,language.getText(), parser);
        finderWord.list_word();
        listenArea = new ListenerArea(user_area, words_generator,   finderWord);
        listenArea.addListener(language.getText());

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
        area = new Area(); //класс!!
        words_generator = area.getArea();
        user_area = area.getAreaUser();
        // area.addListener(language.getText());
        finderWord =  new FinderWord(words_generator);
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
                    // area.addListener(language.getText());
                    listenArea.addListener(language.getText());
                    new Generate(words_generator, language.getText(),parser);
                    
                }
                else
                {
                    language.setText("Русский Язык");
                    // area.addListener(language.getText());
                    listenArea.addListener(language.getText());
                    new Generate(words_generator, language.getText(),parser);                    
                }
            } 
        });
        // area.addListener(language.getText());
    }
}
