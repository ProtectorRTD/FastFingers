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

        listenArea = new ListenerArea(user_area, area);
                  
    }
    public JTextArea getArea()
    {
        return area;
    }
    public JTextArea getAreaUser()
    {
        return user_area;
    }
    public void addListener(String language) // для Бэка
    {
        listenArea.addListener(language);
    }
}
//     user_area.addKeyListener(new KeyListener()
//     {
//         @Override
//         public void keyTyped(KeyEvent e) 
//         {
//             // TODO Auto-generated method stub
            
//         }

//         @Override
//         public void keyPressed(KeyEvent e) 
//         {
//             // если пробел то проверить слова и выделить его
//             if(e.getKeyCode() == KeyEvent.VK_SPACE)
//             {
//                 finderWord = new FinderWord(area.getText());
//                 finderWord.compare(user_area, user_word);  
//                 user_area.setText("");
//                 user_word = "";
//             }            
//         }

//         @Override
//         public void keyReleased(KeyEvent e) 
//         {
//             if(Character.isDefined(e.getKeyChar()) && language.equals("English"))
//             {
//                 user_word += e.getKeyChar();
//             }
//             if(language.equals("Русский Язык"))
//             {
//                 for(int i = 0; i < alhabet_rus.length; i++)
//                 {
//                     if(e.getKeyChar() == (alhabet_rus[i]))
//                     {
//                         user_word +=e.getKeyChar();                            
//                     }
//                 }
//             }
//             if(e.getKeyChar() ==  KeyEvent.VK_BACK_SPACE && user_word.length()>1)
//             {
//                 user_word = user_word.substring(0, user_word.length()-2);
//             }     
//         }
//    });
