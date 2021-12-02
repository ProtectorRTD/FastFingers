package Back;

import javax.swing.JTextArea;

public class FinderWord 
{
    // private String words;
    public FinderWord()
    {
       
    }    
    public void compare(JTextArea words, String inputUsers)//выделяет цветом  после нажатия проблема, инпут юзерс передается слова
    {
        inputUsers = inputUsers.trim(); //чтобы убрать пробел
        System.out.println(inputUsers);
    }
}
