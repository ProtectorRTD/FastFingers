package Back;

public class Stats 
{
    private int countchar;
    private int correctchar;
    private int mistakechar;
    private int correctword;
    private int mistakeword;
    public Stats()
    {
        correctchar = 0;
        correctchar = 0;
        mistakechar = 0;
        correctword = 0;
        mistakeword = 0;
    }
    public void addChar(int value)
    {
        countchar += value;
    }
    public void addCorrect(int value)
    {
        correctchar += value;
    }
    public void mistakeChar(int value)
    {
        mistakechar += value;
    }
}
