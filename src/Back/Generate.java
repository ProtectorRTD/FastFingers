package Back;

import java.util.HashSet;
import java.util.Random;

import javax.swing.JTextArea;

//задача класса заполнить текстовое поле словами
public class Generate 
{
    private JTextArea words_area;
    private Parser parser;
    private HashSet hashSet;
    private Random rand;
    public Generate(JTextArea words_area, String language, Parser parser) //language для генерации какого языка, взять из parses хэш таблицу и зарандомить в текст ареа
    {
        rand = new Random();
        this.words_area = words_area;
        this.parser = parser;
        takeLanguageInSet(language);
        generateWords();
    }
    private void takeLanguageInSet(String language)
    {
        if(language.equals("Русский Язык"))
        {
            hashSet = parser.getListWordsRu();
        }
        else
        {
            hashSet = parser.getListWordsEng();
        }
    }
    private void generateWords() //не забыть чтобы брал слова больше 3, ибо меньше трех там что-то страшное 
    {
        //в будущем мб сделать счестчик на количество слов 
        Object[] arr = hashSet.toArray();
        String text = "";
        for(int i = 0; i < 20; i ++ ) 
        {
           int random_number = rand.nextInt(hashSet.size()-1);
           text += (String)arr[random_number].toString();
           text += " ";
           
        }
        words_area.setText(text);
    }
}
