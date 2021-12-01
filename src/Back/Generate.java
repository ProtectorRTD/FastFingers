package Back;

import javax.swing.JTextArea;

//задача класса заполнить текстовое поле словами
public class Generate 
{
    private JTextArea words_area;
    public Generate(JTextArea words_area, String language) //language для генерации какого языка, взять из parses хэш таблицу и зарандомить в текст ареа
    {
        this.words_area = words_area;
    }

    private void takeFromTxt() //не забыть чтобы брал слова больше 3, ибо меньше трех там что-то страшное 
    {
        
    }
}
