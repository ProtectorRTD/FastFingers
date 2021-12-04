import Front.App;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        // String s1 = "Java";  
        // String s2 = "Java";  
        // String s3 = new String("Java");  
        // String s4 = new String("Java").intern();  
        // if(s1 == s2)
        // {
        //     System.out.println("1");
        // }
        // else if (s1 == s3 )
        // {
        //     System.out.println("2");
        // }
        // if(s1 == s4) System.out.println("3");
        // System.out.println((s1 == s2)+", String are equal."); 
        // System.out.println((s1 == s3)+", String are not equal.");
        // System.out.println((s1 == s4)+", String are equal."); 

        String str = new String("Welcome to JavaTpoint.");   
        String str1 = new String("Welcome to JavaTpoint");  
        System.out.println(str1.equals(str)); 
        App app = new App();
        
    }
}
