# Test Java

“A nut for a jar of tuna” this is an example of a palindrome sentence. A palindrome sentence is those that can be spelled 
the same way forward an backward. Into the next table on the right side, write down the step-by-step 
(natural language, NO CODE) to determine if a sentence is a palindrome or not. On the left side list all the java 
functions you can use to solve this problem.

1. 

Step by step 

      1.Eliminate spaces in the sentence, so we can analyze as a word .
      2.Generate a reverse form of the word.
      3.Compare the reverse word with the word, if they’re the same then the sentence is palindrome.

Java Functions	Step - by - step or algorithm

        1.  String word = sentence.replaceAll("\\s+", "");
        2.  String reveseWord = new StringBuilder (word).reverse().toString();
        3.  return word.equalsIgnoreCase(reverseWord)


2.

You have a piggy bank, you can only insert coins of the following denomination.
50, 100, 200, 500 & 1000
Keeping in mind the previous description:
Represent the logic of a piggy bank using java code. means that you can insert but not remove coins.
You have the option to know how many coins are in the piggy bank.
You have the option to how many coins are by a specific denomination.
