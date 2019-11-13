
import java.util.*;


/**
 *
 * @author perretta.ryan
 * Date: May 2018
 */
public class BlackJack {
    
    static Scanner scan = new Scanner(System.in);
    static int winCount = 0, loseCount = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Arrays will store values to help create cards
        int[] values = {2,3,4,5,6,7,8,9,10,10,10,10};
        String[] types = {"Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        
        boolean validResponse = true;
        int rounds;
        
        do{
            //prompts user for amount of rounds
            System.out.println("Welcome to my Blackjack game!\n\nHow many "
                    + "rounds would you like to play? (max 21)");
            //gets the desired amount of rounds
            rounds = scan.nextInt();
            //tests if input is valid
            if(rounds > 0 && rounds <= 21)
                validResponse = true;
            else{
                validResponse = false;
                System.out.println("**Please enter an amount between 1 and 21."
                        + "**");
            }//end else
        }while(!validResponse);//end do-while
        
        //ArrayList that stores cards for the player
        ArrayList<Card> playerHand = new ArrayList();
        
        for(int i = 0; i < rounds; i++){
            
            //creates new deck object
            DeckOfCards cards = new DeckOfCards(values, types, suits);
            
            cards.shuffle();
            
            //prints the round number
            System.out.println("Round "+(i+1)+":");
            
            //deals first card to player
            playerHand.add(hit(cards));
            //deals first card to dealer
            Dealer cpu = new Dealer(hit(cards));
            
            //deals one more card to player and dealer face down
            playerHand.add(hit(cards));
            cpu.addCard(hit(cards));
            
            printPlayerHand(playerHand);
            System.out.println("The dealer was a dealt the "+cpu.getFirstCard()
                    +" and "+(cpu.getSizeOfHand()-1)+" more card.");
            
            int counter;
            do{
                
                //counts amount of times person does not hit
                counter = 0;
                
                if(getPlayerSum(playerHand) <= 21){
                    //asks user to hit or stay
                    System.out.println("Would you like to hit or stand?\n"
                            + "\t1. Hit\n\t2. Stand");
                    //gets response and tests if it is valid
                    int command;
                    do{
                        //user enters value corresponding to command
                        command = scan.nextInt();
                        if(command < 1 || command > 2)
                            System.out.println("Enter the number corresponding to "
                                    + "your desired action.");
                    }while(command < 1 || command > 2);//end do-while

                    if(command==1){
                        Card temp = hit(cards);
                        System.out.println("You were dealt the "+temp);
                        playerHand.add(temp);
                    }
                    else
                        counter++;
                    if(getPlayerSum(playerHand)>21){
                        String busted = (char)27 + "[31mYou busted!";
                        System.out.println(busted);
                        counter++;
                    }
                }//end if
                else
                    counter++;
                
                //Dealer's turn
                int dealerChoice = cpu.evaluate();
                if(dealerChoice==0){
                    System.out.println("Dealer chose to hit.");
                    cpu.addCard(hit(cards));
                }//end if
                else{
                    System.out.println("Dealer chose to stand.");
                    counter++;
                }//end else
                
            }while(counter < 2);//end do-while
            
            int playerSum = getPlayerSum(playerHand);
            printPlayerHand(playerHand);
            System.out.println("\tSum:  "+getPlayerSum(playerHand));
            int dealerSum = cpu.getSum();
            cpu.printHand();
            System.out.println("\tSum:  "+cpu.getSum());
            
            //1 = loss      2 = win     3 = tie
            int outcome = 1;
            
            if((playerSum>dealerSum && playerSum<=21)||(dealerSum>21 && 
                    playerSum<=21))
                outcome = 2;
            else if((playerSum==dealerSum)||(playerSum>21 && dealerSum>21))
                outcome = 3;
            
            switch(outcome){
                case(1):
                    String lostRound = (char)27 + "[31mYou lost this round.";
                    System.out.println(lostRound);
                    loseCount++;
                    break;
                case(2):
                    String wonRound = (char)27 + "[32mYou won this round.";
                    System.out.println(wonRound);
                    winCount++;
                    break;
                case(3):
                    String roundDraw = (char)27 + "[33mThis round was a draw.";
                    System.out.println(roundDraw);
                    break;
            }//end switch
            
            //clears formatting otherwise input will have color
            System.out.println((char)27 + "[0m");
            
            //clears the hands of the dealer and player
            clearPlayerHand(playerHand);
            cpu.clearHand();
            
        }//end for loop
        
        //creates colored strings for each scenario
        String wonMatch = (char)27 + "[36;45m    Congratulations you have won the match!!   ";
        String lostMatch = (char)27 + "[31;40m    You lost the match. Better Luck next time!    ";
        String matchDraw = (char)27 + "[33m    The match was a tie!    ";
        
        //prints corresponding message
        if(winCount>loseCount)
            System.out.println("\n"+wonMatch+"\n");
        else if(winCount<loseCount)
            System.out.println("\n"+lostMatch+"\n");
        else
            System.out.println("\n"+matchDraw+"\n");
        
    }//end main
    
    /**
     * Deals a single card to player or dealer
     * @param cards
     * @return 
     */
    public static Card hit(DeckOfCards cards){
        return cards.deal();
    }
    
    /**
     * Clears the players hand for a new round
     * @param hand player's hand
     */
    public static void clearPlayerHand(ArrayList<Card> hand){
        for(int i = hand.size(); i > 0; i--){
            hand.remove(i-1);
        }
    }
    
    /**
     * Prints the cards the player currently holds
     * @param hand player's hand
     */
    public static void printPlayerHand(ArrayList<Card> hand){
       
        System.out.println("Your Hand:");
        for(int i = 0; i < hand.size(); i++){
            System.out.println("\t"+hand.get(i));
        }
        
    }
    
    /**
     * Calculates sum of player's hand
     * @param hand player's hand
     * @return sum of player's hand
     */
    public static int getPlayerSum(ArrayList<Card> hand){
        
        int sum = 0;
        for(int i = 0; i < hand.size(); i++){
            if(hand.get(i).getType().contains("Ace") && (hand.get(i).getValue()==0)){
                System.out.println("Do you want the ace to equal 1 or 11?");
                int ace;
                do{
                    ace = scan.nextInt();
                    if(!(ace==1 || ace==11))
                        System.out.println("Enter either 1 or 11.");
                }while(!(ace==1 || ace==11));
                
                sum += ace;
                hand.get(i).giveAceValue(ace);
            }
            else
                sum += hand.get(i).getValue();
        }
        return sum;
    }
    
}
