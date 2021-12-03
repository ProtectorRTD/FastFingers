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
    public ListenerArea(JTextArea user_area, JTextArea wordsArea, FinderWord finderWord)
    {
        this.area = wordsArea;
        this.user_area = user_area;
        user_word = "";
        this.finderWord = finderWord;
        Russian();       
    } 
    public void Russian()
    {
        rus = "абвгдеёжзийклмнопрстуфхцчшщьыъэюя";
        alhabet_rus = rus.toCharArray();
    }
    public void addListener(String language) // для Бэка
    {
        user_area.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e) 
            {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void keyPressed(KeyEvent e) 
            {
                // если пробел то проверить слова и выделить его      
            }

            @Override
            public void keyReleased(KeyEvent e) 
            {
                if(Character.isDefined(e.getKeyChar()) && language.equals("English"))
                {
                    user_word += e.getKeyChar();
                }
                if(language.equals("Русский Язык"))
                {
                    for(int i = 0; i < alhabet_rus.length; i++)
                    {
                        if(e.getKeyChar() == (alhabet_rus[i]))
                        {
                            user_word +=e.getKeyChar();                            
                        }
                    }
                }
                if(e.getKeyChar() ==  KeyEvent.VK_BACK_SPACE && user_word.length()>1)
                {
                    user_word = user_word.substring(0, user_word.length()-2);
                } 
                if(e.getKeyCode() == KeyEvent.VK_SPACE)
                {
                    try 
                    {
                        finderWord.compare(area, user_word);
                    } 
                    catch (BadLocationException e1) 
                    {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }  
                    user_area.setText("");
                    user_word = "";
                }      
            }
       });
    }
}
