
import java.util.*;

/**
 *
 * @author perretta.ryan
 */
public class Dealer {
    
    private ArrayList<Card> hand = new ArrayList();
    private Random rand = new Random();
    private int sum = 0;
    
    /**
     * Creates dealer with a card in hand and a set of hard-coded guidelines
     * for play
     * @param one first card
     */
    public Dealer(Card one){
        addCard(one);
    }
    
    public int evaluate(){
        
        int randomVal;
        
        if(sum < 16)
            return 0;
        else if(sum > 16)
            return 1;
        else{
            randomVal = rand.nextInt(2);
            return randomVal;
        }
        
    }
    
    /**
     * Handles the ace for dealer whether ace will equal 1 or 11
     * @return value the ace will be
     */
    private int handleAce(){
        int aceValue;
        if(sum < 11){
            aceValue = 11;
        }
        else{
            aceValue = 1;
        }
        return aceValue;
    }
    
    /**
     * Adds new card to the dealer's hand
     * @param newCard card to be added to dealer's hand
     */
    public void addCard(Card newCard){
        hand.add(newCard);
        if(newCard.getType().contains("Ace"))
            sum += handleAce();
        else
            sum += newCard.getValue();
    }
    
    /**
     * @return first card in dealer's hand
     */
    public Card getFirstCard(){
        return hand.get(0);
    }
    
    /**
     * @return amount of cards in dealer's hand
     */
    public int getSizeOfHand(){
        return hand.size();
    }
    
    /**
     * @return sum of hand 
     */
    public int getSum(){
        return sum;
    }
    
    /**
     * Prints the dealer's hand
     */
    public void printHand(){
        System.out.println("Dealer's Hand:");
        for(int i = 0; i < hand.size(); i++)
            System.out.println("\t"+hand.get(i));
    }
    
    public void clearHand(){
        for(int i = hand.size(); i > 0; i--){
            hand.remove(i-1);
        }
    }
    
}
