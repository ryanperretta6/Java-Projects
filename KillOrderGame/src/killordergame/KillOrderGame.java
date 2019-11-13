
package killordergame;

import java.util.Scanner;

/**
 *
 * @author ryanperretta
 * Date: April 2017
 */
public class KillOrderGame {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        //Scanner takes in commands from the user
        Scanner scan = new Scanner(System.in);
        
        //Welcome Message, Instructions, and background
        System.out.println("****Welcome to the Kill Order Game****\n"
                + "\tBy Ryan Perretta\n\n"
                + "\tInstructions:\n\tThis game is takes you through the story "
                + "of the Kill Order.\n\t"
                + "You will see the story through the ees of the Mark, the "
                + "protagonist.\n\t"
                + "Periodically the game will pause and either give you more "
                + "information on the book \n"
                + "\tor let you choose an option that will impact the outcome of "
                + "your character.\n");
        
        //Level Code
        int levelCode;
        
        //Level Code Entry
        System.out.print("If you are a returning player enter the level code "
                + "below(if none enter '0'): ");
        levelCode = scan.nextInt();
        
        //Object that accesses the Levels class to run the various levels in 
        //the game
        Levels obj = new Levels(levelCode);
        
    }
    
    
}
