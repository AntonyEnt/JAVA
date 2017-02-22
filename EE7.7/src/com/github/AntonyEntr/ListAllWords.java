package com.github.AntonyEntr;
import java.util.ArrayList;

/**
 * Makes an alphabetical list of all the words entered
 * by the user.  The list is written to a file.
 */
public class ListAllWords {
   
   
   public static void main(String[] args) {
      
      System.out.println("\nTypa any words as you want.\n When you've finished enter 'STOP'");
      	int lastSpace=0; // Used if the user enter several words at once 
      	String word = TextIO.getln();
      	System.out.println(word);
        ArrayList<String> wordList = new ArrayList<String>();
         while (!word.equals("STOP") ) {
        	lastSpace = 0;
            word = word.toLowerCase();  // convert word to lower case
            for (int i = 0 ; i < word.length() ; i++) {
            	
            	if (!Character.isLetter(word.charAt(i))){
            		
            		if ( wordList.indexOf(word.substring(lastSpace, i)) == -1) {
                     wordList.add(word.substring(lastSpace+1,i));
                     lastSpace = i;
                  }
            		
            		
            	}
            	
            }
            if ( wordList.indexOf(word) == -1) {
                  // This is a new word, so add it to the list
               wordList.add(word.substring(lastSpace,word.length()));
            }
            word = TextIO.getln();
            System.out.println(word);
         }
         System.out.println("Number of different words found in file:  " 
               + wordList.size());
         System.out.println();
         if (wordList.size() == 0) {
            System.out.println("No words found in file.");
            System.out.println("Exiting without saving data.");
            System.exit(0);
         }
         selectionSort(wordList); // sort the wordlist
         //Recording in a file chosen by the user
         System.out.println("Enter the filename you want to save your wordlist");
         String fileName = TextIO.getln(); //
         TextIO.writeFile(fileName); 
         TextIO.putln("You have entered " + wordList.size() + " differents words:\n");
         for (String w : wordList)
            TextIO.putln(w);
         System.out.println("\n\nSaved in " + fileName + "\n\n");
      }
   
   


   /**
    * Sorts a list of strings into lexicographical order, using
    * selection sort and treating the list much like an array.  In this 
    * program, the list only contains words made up of lower case
    * letters, so lexicographic order is the same as alphabetical order.
    * 
    *@param list is the list which has to be sorted
    */
   private static void selectionSort(ArrayList<String> list) {
      for (int top = list.size() - 1; top > 0; top--) {
         int indexOfBiggest = 0;
         for (int j = 0; j < top; j++) {
            String str = list.get(j);
            if (str.compareTo( list.get(indexOfBiggest) ) > 0) {
               indexOfBiggest = j;
            }
         }
         String temp = list.get(top);
         list.set( top, list.get(indexOfBiggest) );
         list.set( indexOfBiggest, temp );
      }
   }


   
} // end ListAllWords