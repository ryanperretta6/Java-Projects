
/**
 *
 * @author perretta.ryan
 */
public class Card {
    
    private int value;
    private String type;
    private String suit;
    
    /**
     * General constructor for the majority of cards
     * @param val numerical value of card
     * @param typeOfCard name of the card as a String
     * @param suitOfCard suit of the card
     */
    public Card(int val, String typeOfCard, String suitOfCard){
        value = val;
        type = typeOfCard;
        suit = suitOfCard;
    }
    
    /**
     * Constructor for an Ace, because the value will be determined later
     * @param typeOfCard
     * @param suitOfCard 
     */
    public Card(String typeOfCard, String suitOfCard){
        type = typeOfCard;
        suit = suitOfCard;
    }
    
    /**
     * @return value of the card
     */
    public int getValue(){
        return value;
    }
    
    /**
     * @return type of card
     */
    public String getType(){
        return type;
    }
    
    /**
     * @return suit of card
     */
    public String getSuit(){
        return suit;
    }
    
    /**
     * @return type followed by suit
     */
    public String toString(){
        return type+" of "+suit;
    }
    
    /**
     * Assigns the ace a value of 1 or 11
     * @param val 1 or 11
     */
    public void giveAceValue(int val){
        value = val;
    }
    
}
