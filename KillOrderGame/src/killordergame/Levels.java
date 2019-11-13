package killordergame;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author ryanperretta
 */
public class Levels {
    
    //Scanner that takes commands from the user
    Scanner user = new Scanner(System.in);
    
    //Variable that stores the user's choice for some options
    public int choice;
    
    //Variable that indicates whether the user passed or faild a level
    public boolean passOrFail = false;
    
    //Variable that indicates the players health
    public int hp = 100;
    
    //Records the amount of levels completed, does not include levels passed by
    // a level code
    public int levelsCompleted = 0;
    
    //Variable that keeps track of the players score
    public int score = 0;
    
    //Variable that keeps track of time at certain tasks
    public int time;
    
    //Timer object
    Timer timer;
    
    //interval variable for the timer
    int interval;
    
    /**
     * 
     * @param levelCode if the user has played before a level code may be 
     *                  entered to bypass previously played level
     */
    public Levels(int levelCode){
        
        //true or false variable
        boolean trueFalse = true;
        
        //tests the levelCode to see if it matches any given
        while(trueFalse){
            switch(levelCode){
            
                case 0: level1theVillage();
                        trueFalse = false;
                        break;
            
                case 57234: level2theBerg();
                            trueFalse = false;
                            break;
                        
                case 63901: level3backToTheVillage();
                            trueFalse = false;
                            break;
                        
                case 79152: level4theGirl();
                            trueFalse = false;
                            break;
            
                default: System.out.println("Not a valid option try again: ");
                     
            
            }
        }
        
    }
    
    /**
     * 
     * @return the player's score 
     */
    public int getScore(){
        
        //adds 10 points for every unit of health left
        score += hp * 10;
        
        score += levelsCompleted*1000;
        
        return score;
    }
    
    public void chooseAnOption(int choices){
        
        //User entry
        choice = user.nextInt();
        
        //will increment if the choice matches a valid option
        int count = 0;
        
        for(int i = 1; i <= choices; i++){
            if(i==choice)
                count++;
        }
        
        if(count == 0){
            
            System.out.print("Enter an option between 1 and "+ choices+"...");
            chooseAnOption(choices);
            
        }
        
    }
    
    /**
     * 
     * @return String that displays health
     */
    public String getHealth(){
        
        String healthDisplay ="HP/";
        
        for(int i = 0; i < hp/10; i++){
            healthDisplay += "*";
        }
        
        healthDisplay += "\n";
        
        return healthDisplay;
    }
    
    /**
     * 
     * @return integer that displays the time
     */
    public final int setInterval(){
        if(interval == 1)
            timer.cancel();
        return --interval;
    }
    
    public void timer(int inter){
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = inter;
        System.out.print(interval+" ");
        TimerTask task = new TimerTask(){
            public void run(){
                
                    System.out.print(setInterval()+ " ");
                
        }
        };
        timer.scheduleAtFixedRate(task, delay, period);
    }
    
    public void level1theVillage(){
        
        //Includes New characters and some background information
        System.out.print("\n\nLevel 1 - The Village:\n\n"
                + "Characters:\n"
                + "Trina - Your girlfriend, that you knew before the sun flares"
                + " from school\n"
                + "Alec - Ex-soldier who often acts as the proctector of your "
                + "group\n"
                + "Lana - Alec's friend from their days as soldiers\n"
                + "Toad - Short and stout boy about your age that you met after"
                + " the flares\n"
                + "Misty - Toad's best friend, short with red and brown hair\n"
                + "Darnell - Good friend of everyone in the group\n"
                + "Deedee - Young girl that the group meets in Level 4,\nshe "
                + "was abandoned by her family\n\n"
                + "After a nice talk with Trina up on the mountain in "
                + "your favorite spot,\nyou hear a noise overhead. You look up "
                + "and see a Berg with men hanging over \nthe edge of the back "
                + "door with guns in hand.\nDarts start flying in every "
                + "direction and people are dropping left and right, including."
                + "\nyour friend Darnell.\n"
                + getHealth()
                + "\nYou have two options:\n"
                + "\t1. Run to safety\n"
                + "\t2. Run to assist your friends first\n\n"
                + "Your Choice: ");
        
        //Evaluates choice to make sure there is no errors
        chooseAnOption(2);
        
        //Looks at the choices and prints the according statement
        switch(choice){
            case 1: System.out.println("\tYou make it to safety behind one of "
                    + "the wooden huts.\n\tYou wonder where your firends are "
                    + "and if they are ok.");
                    break;
            case 2: System.out.println("\tIn the attempt to find and help your "
                    + "friends\n\tyou are grazed by one of the darts on your neck"
                    + ".\n\tYou begin to bleed from your neck and by the time you"
                    + " find\n\tyour friends you are feeling ill from the blood "
                    + "loss.\n\t-Lose 50HP-\n");
                    hp -= 50;
                    break;
        }
        System.out.println(getHealth());
        
        System.out.println("After getting to safety you see Alec run over to "
                + "you.\nHe has in his hands 2 guns with grappling hooks on the"
                + " ends.\nHe yells to you to grab one of them and get onto "
                + "the Berg.\nAlec quickly shoots his hook onto the Berg and "
                + "shortly after he is on top.\nYou quickly follow suit and are"
                + " sent flying through the air when the Berg lifts off.\nYou "
                + "need to reach the button that reels you into the Berg.\n");
        System.out.println("You have three options:\n"
                + "\t1.Let go of the rope while you're still relatively close "
                + "to the ground\n"
                + "\t2. Wait to see if Alec will be able to pull you in\n"
                + "\t3. Take one hand off and try to reach for the button\n\n"
                + "Your choice: (You have 15 seconds to decide!)");
        
        timer(15);
        
        chooseAnOption(3);
        
        switch(choice){
            
            case 1: System.out.println("\tThat was not a smart choice, you hit "
                    + "mutliple branches\n\ton the way down.\n\t-Lose 100HP-");
                    hp -= 100;
                    break;
                    
            case 2: System.out.println("\tAlec could not pull you up in time;"
                    + "\n\tyour hands slipped, and you fell.\n\t-Lose 100HP-");
                    hp -= 100;
                    break;
                    
            case 3: System.out.println("\tAfter a bit of struggling you manage "
                    + "to press\n\tthe button and reel yourself onto the back "
                    + "of the ship.");
                    break;
            
        }
        System.out.println(getHealth());
        if(hp == 0){
            System.out.println("YOU DIED\nGAME OVER");
            System.exit(0);
        }
        else{
            System.out.println("CONGRATULATIONS\nEND OF LEVEL 1\nLEVEL CODE: "
                    + "57234");
            levelsCompleted++;
            level2theBerg();
        }
        
    }
    
    public void level2theBerg(){
        
        //health refilled after level1
        hp = 100;
        System.out.println("\n\nHealth reset");
        
        System.out.print("Level 2 - The Berg:\n\n"
                + "You are now on the Berg with Alec.  There are still enemies "
                + "\nin the cockpit.  You and Alec enter the cockpit after \n"
                + "taking down the door.  The pilot is there.\n\n"
                + "You have two choices:\n"
                + "\t1. Subdue the pilot and try to land the Berg yourself\n"
                + "\t2. Keep the pilot alive and try to convince them to turn "
                + "\n\tthe Berg around\n\n"
                + "Your choice: ");
        
        chooseAnOption(2);
        
        switch(choice){
            
            case 1: System.out.println("\tYou successfully subdue the pilot and"
                    + " try to land the Berg yourself.\n\tNeither you nor Alec "
                    + "can fly the Berg with any success.\n\tYou decide to land"
                    + " the Berg immediately.\n\tThankfully you do so "
                    + "successfully.");
                    break;
                    
            case 2: System.out.println("\tYou let the pilot live, bad choice. "
                    + "She pulls a lever\n\tthat shuts down the Berg's engines."
                    + " The Berg starts hurtling\n\ttowards the ground. Nothing"
                    + " you can do can stop it.\n\tYou crash land in the forest"
                    + " below.\n\t-Lose 100HP-");
                    hp -= 100;
                    break;
            
        }
        System.out.println(getHealth());
        if(hp == 0){
            System.out.println("YOU DIED\nGAME OVER");
            System.exit(0);
        }
        else{
            System.out.println("CONGRATULATIONS\nEND OF LEVEL 1\nLEVEL CODE: "
                    + "63091");
            levelsCompleted++;
            level3backToTheVillage();
        }
        
    }
    
    public void level3backToTheVillage(){
        
        //reset hp after level 3
        hp = 100;
        System.out.println("\n\nHealth reset");
        
        System.out.print("Level 3 - Back To the Village\n\n"
                + "After a few days of walking and some rest, Alec and Mark "
                + "make it\nback to the camp. The smell of death hits you like"
                + " immediately.\nNo one is around although you feel like there"
                + " are a million\neyes peering at you through the windows. "
                + "Finally, you find\nTrina who appears very dirty. She leads "
                + "you to a hut,\ninside someone was screaming. It was Darnell"
                + ", as you get\nclose you here him muttering about his head "
                + "in between screams.\nLana walks over once she realizes her "
                + "friends had returned.\nEveryone knows that something must be"
                + " done about Darnell.\n\n"
                + "You have two choices:\n"
                + "\t1. Leave Darnell to die\n"
                + "\t2. Have someone in your group kill darnell to end his "
                + "suffering\n\n"
                + "Your choice: ");
        
        chooseAnOption(2);
        
        switch(choice){
            
            case 1: System.out.println("\tDarnell continues to scream in agony"
                    + "\n\tand as you leave you feel guilty for\n\tleaving him "
                    + "to suffer.");
                    break;
                    
            case 2: System.out.print("\tNow that you have decided to kill "
                    + "Darnell,\n\tyou must decide who will do it.\n\n"
                    + "You have four choices:\n"
                    + "\t1. You"
                    + "\n\t2. Lana"
                    + "\n\t3. Alec"
                    + "\n\t4. Trina"
                    + "\n\nYour choice: ");
                    chooseAnOption(4);
                    if(choice == 1)
                        System.out.println("\tAlthough you were not feeling up "
                                + "to it\n\tyou know that someone must do it so"
                                + " you volunteer\n\tyourself to do it.");
                    else if(choice == 2)
                        System.out.println("\tLana is ex-military nurse, she "
                                + "has seen\n\tdeath before. She sees it as "
                                + "necessary\n\tfor Darnell's sake, and does it"
                                + " with little regret.");
                    else if(choice == 3)
                        System.out.println("\tAlec is ex-military, he is "
                                + "probably the best\n\tchoice for the task at"
                                + " hand. He ends it\n\tquickly all you could "
                                + "hear were a few thunks.");
                    else
                        System.out.println("\tTrina is not as strong as the "
                                + "others. She is\n\tnot able to do it even "
                                + "when you selected her.\n\tAlec goes into the"
                                + " hut and does it for\n\ther. The group is "
                                + "visibly disappointed by your decision.");
                    break;
        }
        getHealth();
        System.out.println("\nCONGRATULATIONS\nEND OF LEVEL 1\nLEVEL CODE: "
                    + "79152");
        levelsCompleted++;
        level4theGirl();
        
    }
    
    public void level4theGirl(){
        
        //Health Reset
        hp = 100;
        System.out.println("Health reset");
        
        System.out.print("\nLevel 4 - The Forest\n\n"
                + "Before you leave the village you meet up with Misty and Toad"
                + "\nMisty becomes infected with the same disease that you saw "
                + "\nin Darnell. Everyone keeps their distance, but Toad is "
                + "\nvery torn because Misty is his best friend. Misty "
                + "\neventually told you to leave to not get infected as well."
                + "\nToad decides to stay behind. After leaving and walking "
                + "\ntowards a location marked by a map found on a workpad in "
                + "\nthe Berg, you stumble across another village. It reeks of "
                + "\nthe same stench that filled your own village prior. You "
                + "\nwalk through to see if you can find anything useful, but"
                + "\ninstead find a small girl, much younger than herself. She "
                + "\nsaid that her parents went crazy and left her."
                + "\n\nYou have two choices:"
                + "\n\t1. Take the girl along with you"
                + "\n\t2. Leave the girl behind because she may be sick"
                + "\n\nYour choice: ");
        
        chooseAnOption(2);
        
        switch(choice){
            
            case 1: System.out.println("\tThe girl's name is Deedee she is "
                    + "\n\tafraid, but grateful that you took her along.");
                    break;
            
            case 2: System.out.println("\tEvery one of your friends is against"
                    + "\n\tyour decision they decide to take the girl and leave"
                    + "\n\tyou behind. That was cold dude...\n\nGAME OVER");
                    System.exit(0);
                    break;
            
        }
        
        levelsCompleted++;
        
        System.out.println("\nYour score: " + getScore());
        
        System.out.println("\n\nWell this is awkward... the game isn't really "
                + "finished yet so go away.");
        
    }
    
}
