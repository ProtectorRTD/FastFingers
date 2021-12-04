package Back;
import java.awt.event.*;
import java.lang.module.FindException;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
public class ListenerArea 
{
    private String rus;
    private char[] alhabet_rus;
    private JTextArea user_area;
    private FinderWord finderWord;
    private String user_word;
    private JTextArea area;

    private KeyAdapter keyAdapter;
    private String language;
    // private KeyAdapter keyAdapter;
    public ListenerArea(JTextArea user_area, JTextArea wordsArea, FinderWord finderWord)
    {
        this.area = wordsArea;
        this.user_area = user_area;
        user_word = "";
        this.finderWord = finderWord;
        language = "English";
        Russian();       
    } 
    public void Russian()
    {
        rus = "абвгдеёжзийклмнопрстуфхцчшщьыъэюя";
        alhabet_rus = rus.toCharArray();
    }

    private void listener()
    {
        keyAdapter = new KeyAdapter()
        {

            @Override
            public void keyTyped(KeyEvent e) 
            {                
            }

            @Override
            public void keyPressed(KeyEvent e) 
            {

            }

            @Override
            public void keyReleased(KeyEvent e) 
            {
                if(e.getKeyChar() ==  KeyEvent.VK_BACK_SPACE && user_word.length()>=1)
                {
                    user_word = user_area.getText();
                    // System.out.println("");
                }    
                else if(language.equals("Русский Язык"))
                {
                    for(int i = 0; i < alhabet_rus.length; i++)
                    {
                        if(e.getKeyChar() == (alhabet_rus[i]))
                        {
                            user_word = user_area.getText();         

                        }
                    }
                }
                if((e.getKeyCode() == KeyEvent.VK_SPACE))
                {
                    try 
                    {
                        if(language.equals("English"))
                        {
                            user_word = user_area.getText();
                            finderWord.compare(area, user_word,  finderWord);
                        }
                        if(language.equals("Русский Язык"))
                        {
                            user_word = user_area.getText();
                            finderWord.compare(area, user_word, finderWord);
                        }
                    } 
                    catch (BadLocationException e1) 
                    {
                        e1.printStackTrace();
                    }  
                    user_area.setText("");
                    user_word = "";
                }      
            }
       };
    }
    public void addListener(String language, FinderWord finderWord_1) //сделать удаление когда lable меняет название
    {
        if(!(this.language.equals("English"))) 
        {
            this.language = language;
        }
        if(this.finderWord != finderWord_1)
        {
            finderWord = finderWord_1;
        }
        else
        {
            listener();
            user_area.addKeyListener(keyAdapter); 
        }
        // user_area.addKeyListener(keyAdapter); 

    }
}
