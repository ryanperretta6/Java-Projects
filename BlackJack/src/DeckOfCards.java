
import java.util.*;

/**
 *
 * @author perretta.ryan
 */
public class DeckOfCards {
    
    private Stack<Card> deck = new Stack<Card>();
    private Random rand = new Random();
    private int cardsLeft = 52;
    
    /**
     * Creates full deck of 52 cards in order
     * @param values numerical values of the card
     * @param types name of the cards
     * @param suits one of four suits the cards could be
     */
    public DeckOfCards(int[] values, String[] types, String[] suits){
        
        //creates the original deck of cards
        for(int i = 0; i < suits.length; i++){
            deck.push(new Card("Ace", suits[i]));
            for(int j = 0; j < types.length; j++){
                deck.push(new Card(values[j], types[j], suits[i]));
            }//end inner loop
        }//end outer loop
        
    }
    
    /**
     * Shuffles the stack of cards
     */
    public void shuffle(){
        
        Card[] unshuffled = new Card[52];
        Card[] shuffled = new Card[52];
        
        for(int i = 0; i < unshuffled.length; i++){
            unshuffled[i] = deck.pop();
        }
        
        int random, count = 52;
        while(unshuffled[0]!=null){
            random = rand.nextInt(count);
            shuffled[count-1] = unshuffled[random];
            unshuffled = fillEmpty(random, unshuffled);
            count--;
        }
        
        for(int i = 0; i < shuffled.length; i++){
            deck.push(shuffled[i]);
        }
        
    }
    
    /**
     * Fills the spot of a card that has already been shuffled
     * @param random random index value
     * @param ray array filled with cards
     * @return array with one less card in it
     */
    public Card[] fillEmpty(int random, Card[] ray){
        
        for(int i = random; i < ray.length-1; i++){
            ray[i] = ray[i+1];
            ray[i+1] = null;
        }
        
        return ray;
        
    }
    
    /**
     * Pops one card off of the top of the deck and returns to player
     * @return card off top of deck
     */
    public Card deal(){
        return deck.pop();
    }
    
}
