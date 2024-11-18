//A few assumptions.......

//Words will be separated by spaces. 
//There can be punctuation in a word, we will only add/keep punctuation at the end of a string if it is at the end of a string.
//    for examples: Hello.==> Ellohay.    Good-bye! ==> Ood-byegay!    so... ==> osay...
import java.io.IOException;
import java.util.Scanner;
import java.net.URL;


public class Book
{
  
    private String bookText;

    public Book(String link)
    {
        readBook(link);
    }
  
    private void readBook(String link)
    {
        try
        {
            URL url = new URL(link);
            Scanner s = new Scanner(url.openStream());

            while(s.hasNext()) 
            {
              String text =  s.nextLine();
              bookText += text;
            }
        }
        catch(IOException ex)
        {
          ex.printStackTrace();
        }
    
    }
  
  
  
  
  
  
  
  public String pigLatin(String word)
  {
     String vowels = "aeiou";
     String first = word.substring(0, 1);
     String second = word.substring(1, 2);

    if(vowels.indexOf(first) >= 0) 
        return word + "yay";
    else if(vowels.indexOf(second) >= 0) 
      return word.substring(1) + first + "ay";
    
    else
      return word.substring(2) + first + second + "ay";
  }
  

  public int endPunctuation(String word)  //return the index of where the punctuation is at the end of a String. If it is all punctuation return 0, if there is no punctuation return -1
  {

    return -1;
  }

  public String translateWord(String word)    //to share with class
  {
    String convertedWord = "";

    return convertedWord;
  }

  public String translateSentence(String sentence)
  {
    String retSentence = "";

    int indexOfSpace = sentence.indexOf("");

    while(sentence.length() > 0)
    {  
      String word = sentence.substring(0,indexOfSpace);

      retSentence += translateWord(word);

      sentence = sentence.substring(indexOfSpace + 1);
      indexOfSpace = sentence.indexOf("");
    }

    return retSentence;
  }
}  
