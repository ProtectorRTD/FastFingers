package Back;

import javax.swing.JTextArea;
import javax.swing.text.Highlighter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import java.awt.Color;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
public class FinderWord 
{

    //заменить хайлатер на выделение букв, + сделать дебаги и возможно оптимизацию методов
    // private String words;
    //ошибка в том, что когда в середине текста человек переключает язык, то  поинтер не изменяется
    private int count_words;
    private int pointer;
    private int index;
    // private DefaultHighlighter.DefaultHighlightPainter highlightPainter;
    private String[] word_higlight;
    private Set<String> list_word;
    private JTextArea word_list;
    private Object gray_color;

    
    public FinderWord(JTextArea wordsArea)
    {   
        pointer = 0;
        count_words = 20; 
        word_list = wordsArea;
        
        //грубо говоря если будет счетчик то есть выбирать количество то парсить с него
        //занести слова в хэшсет, а потом проверять находится ли такой, 
        //если есть брать его индекс через indexOf если нет, то находить первое слово и в красное

        //2) либо же просто через индекс найти если нет, то сделать слово красным до первого проблема, и запомнить его координаты
    }    
    public void list_word()
    {
        word_higlight =  word_list.getText().split(" "); //нету текста

        list_word = convertArrayToSet(word_higlight);//set
        pointer = 0;
        count_words = 20; 
        // System.out.println("System.out.println");
    }
    //что нужно онулять поинтер и индекс если другой файндворд
    public void compare(JTextArea words, String inputUsers, FinderWord finderWord) throws BadLocationException //выделяет цветом  после нажатия проблема, инпут юзерс передается слова
    {   

        int count_space = 0;
        int previous_space = 0;
        // int count_highlighter = 0;
        if(this != finderWord)
        {
            pointer = 0;
            count_words = 0;
        }
        inputUsers = inputUsers.trim(); //чтобы убрать пробел
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.red);
        index  = words.getText().indexOf(inputUsers);
       
        //есть вторая идея сделать хэштейбл с со значением их позиции, выходит что если такое слово есть но поинтера нету то все красный
        System.out.println(word_higlight[pointer]);
        if(list_word.contains(inputUsers) && word_higlight[pointer].equals(inputUsers))
        {
            try 
            {
                highlightext(); //возможно делать не через хэш сэт а просто удалять из него а так по индексу проверять
                list_word.remove(inputUsers);
                // count_highlighter++;
                // System.out.println("Debug");
            } 
            catch (BadLocationException e) 
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // word_higlight = inputUsers;
        }
        else
        {
            //доделать если нету такого слова через поинтер
            for(int i = 0; i < words.getText().length(); i++)
            {
                if(words.getText().charAt(i) == ' ')
                {
                    if(count_space == pointer)
                    {
                        try 
                        {
                            if(gray_color != null)  
                            {
                                word_list.getHighlighter().removeHighlight(gray_color);
                            }
                            if(previous_space != 0) previous_space++; //чтобы если первое слово неправильно правильно выделил а так чтобы пробелы не выделяло
                            words.getHighlighter().addHighlight(previous_space, i, painter);
                            String removing = words.getText().substring(previous_space, i);
                            list_word.remove(removing);
                            // count_highlighter++;
                            break;
                        } catch (Exception e) 
                        {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    previous_space = i;
                    count_space ++;
                }
            }
        }
        pointer++;
        highlighTextNext();
        //сделать серое выделене

        // System.out.println(pointer);
        
    }
    public void highlighTextNext() throws BadLocationException
    {
        int count_spaces = 0;
        int previous = 0;
        Highlighter.HighlightPainter gray = new DefaultHighlighter.DefaultHighlightPainter(Color.gray);
        for(int i = 0;  i < word_list.getText().length(); i++)
        {
            if(word_list.getText().charAt(i) == ' ')
            {
                count_spaces++;
                previous = i;
            }
            if(count_spaces == pointer)
            {
                if(previous  != 0) previous++;
                int j = 0;
                for(j = i+1; j < word_list.getText().length(); j++)
                {
                    if(word_list.getText().charAt(j) == ' ')
                    {
                        break;
                    }
                }
                gray_color = word_list.getHighlighter().addHighlight(previous, j, gray);
                break;
            }
        }
    }
    public void highlightext() throws BadLocationException //удаление хайлайта
    {
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.green);
        if(gray_color != null)  
        {
            word_list.getHighlighter().removeHighlight(gray_color);
        }
        for(int i = index; i < word_list.getText().length(); i++)
        {
            if(word_list.getText().charAt(i) != ' ')
            {
                word_list.getHighlighter().addHighlight(index, i+1, painter);
            }
            else 
            {
                break;
            }
        }
    }
    public int getPointer()
    {
        return pointer;
    }
    public void setPointer(int value)
    {
        this.pointer = value;
    }

    public static <T> Set<T> convertArrayToSet(T array[])
    {
        // create a set from the Array
        return Arrays.stream(array).collect(
            Collectors.toSet());
    }
}
