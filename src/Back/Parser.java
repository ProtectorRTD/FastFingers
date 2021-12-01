package Back;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

public class Parser 
{
    HashSet<String> list_words_ru;
    HashSet<String> list_words_eng;
    public Parser()
    {
        String filePath;
        filePath = "src/resources/russian.txt";
        list_words_ru = readAllBytesJava7(filePath);
        filePath = "src/resources/english.txt";
        list_words_eng = readAllBytesJava7(filePath);
        System.out.println("");//dla debuga
    }
    private static HashSet<String> readAllBytesJava7(String filePath) 
    {
        HashSet <String> result = new HashSet<>();
        String fileName=filePath;
        try
        {
           FileReader inputFile = new FileReader(fileName);
           BufferedReader bufferReader = new BufferedReader(inputFile);
           String line;
           line = bufferReader.readLine();
           while ((line = bufferReader.readLine()) != null)
            {
                result.add(line);
            }
           bufferReader.close();
        }
        catch(Exception e)
        {
           System.out.println("Error while reading file line by line:" + e.getMessage());                      
        }
        return result;
    }
    public HashSet getListWordsRu()
    {
        return list_words_ru;
    }
    public HashSet getListWordsEng()
    {
        return list_words_eng;
    }

}
