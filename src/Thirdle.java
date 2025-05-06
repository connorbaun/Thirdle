import java.util.*;
public class Thirdle
{
    public static String word;
    public static String[] options =
            {"cat","rat","hat","per", "her","let","pit","set","man","pat","cup",
            "net","nut","bet","sit"};

    public static Scanner scan = new Scanner(System.in);
    public static int guessesRemaining = 4;
    public static ArrayList<String> guesses = new ArrayList<String>();

    public static void main(String[] args)
    {
        Random r = new Random();
        int n = r.nextInt(0,options.length);
        word = options[n];
        playGame();
    }

    public static void playGame()
    {
        while(guessesRemaining > 0)
        {
            System.out.println("Type a 3 letter word. >>>");
            String entry = scan.nextLine();
            process(entry);
            printGuesses();
            if (entry.equalsIgnoreCase(word))
            {
                break;
            }

        }
        System.out.println("The word was " + word);
        if (guessesRemaining > -1)
        {
            System.out.println("YOU WIN");
        }
        else
        {
            System.out.println("You LOSE.");
        }
    }

    public static void process(String entry)
    {
        String added = "";
        //go thru each letter of player's guess, 1 by 1
        for (int i=0; i < entry.length(); i++)
        {
            //go thru each letter of the real word, 1 by 1
            for (int z = 0; z < word.length(); z++)
            {
                String c = entry.substring(i,i+1);
                String w = word.substring(z,z+1);
                //System.out.println("Guessed: " + c + " | " + "Word: " + w);
                boolean matched = entry.substring(i,i+1).equalsIgnoreCase(word.substring(z,z+1));
                //System.out.println("MATCH?" + matched);

                //if we see the letter appear...
                if (matched)
                {
                    //if the guess is spot on
                    if (i == z)
                    {
                        //System.out.println("EXACT MATCH AT " + i);
                        added += "["+entry.substring(i,i+1)+"]";
                        break;
                    }
                    else
                    //if the letter is SOMEWHERE but not the same place
                    {
                        //System.out.println("Letter at " + i + " appears somewhere else in word");
                        added += "/"+entry.substring(i,i+1)+"/";
                        break;
                    }
                }
                else if (z==2)
                {
                    added += entry.substring(i,i+1);
                }
            }
        }
        //System.out.println("ADDED: " + added);
        guesses.add(added);
        guessesRemaining--;
        System.out.println("Guesses Left: " + guessesRemaining);
    }

    public static void printGuesses()
    {
        for (String s : guesses)
        {
            System.out.println(s);
        }
    }
}
