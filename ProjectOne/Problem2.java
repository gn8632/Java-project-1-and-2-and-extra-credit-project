
import java.util.*;
public class Problem2 {

    public static void main(String[] args) {
        String [][] morse ={ //// stored morse table in 2d array
                {"A",".-"},{"B","-..."},{"C","-.-."},{"D","-.."},
                {"E","."},{"F","..-."},{"G","--."},{"H","...."},
                {"I",".."},{"J",".---"},{"K","-.-"},{"L",".-.."},
                {"M","--"},{"N","-."},{"O","---"},{"P",".--."},
                {"Q","--.-"},{"R",".-."},{"S","..."},{"T","-"},
                {"U","..-"},{"V","...-"},{"W",".--"},{"X","-..-"},
                {"Y","-.--"},{"Z","--.."},{"1",".----"},{"2","..---"},
                {"3","...--"},{"4","....-"},{"5","....."},{"6","-...."},
                {"7","--..."},{"8","---.."},{"9","----."},{"0","-----"}
        };

        Scanner input = new Scanner(System.in);

        //---------------------------------------------//
        System.out.println("Please enter a phrase:");
        String s= input.nextLine();

        System.out.println("MorseCode:");
        System.out.println(EnglishToMorse(s, morse));

        //----------------------------------------------//

        System.out.println("Please enter a Morse code:");
        String x= input.nextLine();

        System.out.println("Normal Text:");
        System.out.println(MorseToEnglish(x, morse));

    }

    //-----------------------------------------------------//
    //              converting to morse code               //
    //-----------------------------------------------------//

    //Change all characters to uppercase. 2d array hold only uppercase
    //characters. Create a temporary variable to add the morse code to a string.
    //create a for loop from index 0 to string.length() -> if any character is
    //a space then add three spaces to temporary variable. Otherwise, add the morse
    //code with one space. Finally, return the temporary variable.

    public static String EnglishToMorse(String s, String [][] arr){
        s = s.toUpperCase();
        String temp = "";
        for(int i=0; i < s.length(); i++){
            if(s.charAt(i)==' ')
                temp = temp + "   ";
            else
                temp = temp +( searchMorse(s.charAt(i), arr)+ " ");
        }
        return temp;
    }

    //This function search character (s) in 2d array. If s is found
    //return morse code from second index from table.
    public static String searchMorse(char s, String [][] arr){

        String x = "";
        for(int i=0; i < arr.length; i++){
            if(s == arr[i][0].charAt(0))
                x = arr[i][1];
        }
        return x;
    }

    //-----------------------------------------------------//
    //                Decoding morse code                  //
    //-----------------------------------------------------//

    //Step1: Split the string with three space. Three space
    // separate a word in morse code. Example: String s =
    // {"- ---    -... .    --- .-.    -. --- -    - ---    -... ."};
    //after splitting we have Temp = {- --- , -... . ,--- .-.} and so on.
    //And notice each words stored in an array of string.
    //Step2: The latter is separated by one space. We have to split temp
    //array at each index and add the value (latter) to a resulting string
    // with a space.
    //Step3: Finally return the result.
    public static String MorseToEnglish(String morse, String [][] arr){

        String result ="";
        String [] temp = morse.split("   ");
        for(int i=0; i < temp.length;i++) {
            String[] word = temp[i].split(" ");

            for(int j=0; j < word.length; j++){
                result = result + searchEnglish(word[j], arr);
            }
            result = result + " ";

        }
        return result;
    }


    //This function compares String S and array at second position.
    //Another word, compare morse code from table and string s.
    //if equals return the characters from table.

    public static String searchEnglish(String s, String [][] arr){
        String result ="";
        for(int i=0; i < arr.length; i++){
            if(s.equals(arr[i][1]))
                result = arr[i][0];
        }
        return result;
    }

}
