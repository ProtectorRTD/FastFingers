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
    //баг что пользователь может написать правильное слово но которое находится последним
    //теперь надо доделать когда время заканчивается чтобы нельзя было менять текст поле, создать класс, который будет считать
    // возможно кликабельный лабейл заменить на что-то большее, сделать бэкграунд фото
    //увеличить размеры текста мб посмотреть про отклик клавы, может лучше будет смотреться typed а не released
    // выделять серым следующее слово 
    private static JFrame f;
    private JLabel label, language, time;
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
        listenArea = new ListenerArea(user_area, words_generator,   finderWord, parser, time);
        listenArea.addListener(language.getText(), finderWord);

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
        time = class_label.getTime();
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
        f.add(time);
    }

    private void addListener()
    {
        // FinderWord finderWord_1 = new FinderWord(words_generator); 
        language.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)  
            {  
                ////сделать удаление(keyListener) когда lable меняет название
                String language_label = null;
                if(language.getText().equals("Русский Язык"))
                {
                    language.setText("English");
                    new Generate(words_generator, language.getText(),parser);
                    language_label = "English";
                    user_area.setText("");
                }
                else
                {
                    language.setText("Русский Язык");
                    new Generate(words_generator, language.getText(),parser);  
                    // removeKeyListener.use  
                    language_label = "Русский Язык";
                    user_area.setText("");
                }
                finderWord = null;
                FinderWord finderWord_1 = new FinderWord(words_generator);   
                finderWord_1.list_word();            
                System.out.println(language_label);
                listenArea.addListener(language_label, finderWord_1);
                listenArea.setBooleanStartTimer();
            } 
        });
        // area.addListener(language.getText());
    }
}
