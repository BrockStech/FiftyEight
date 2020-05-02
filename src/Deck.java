import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Deck
{
    private List<Card> cards;

    public Deck()
    {
        this.cards = new ArrayList<Card>();
        createDeck();
    }

    private void createDeck()
    {
        int cardIndex = 0;
        for (int suitIndex = 0; suitIndex < 4; suitIndex++)
        {
            for (int valueIndex = 0; valueIndex < 13; valueIndex++)
            {
                cards.add(new Card(suitIndex, valueIndex));
                cardIndex++;
            }
        }
    }

    public void print()
    {
        for (Card card : cards)
        {
            System.out.print(card.print() + "\n");
        }
    }

    public void shuffle()
    {
        Collections.shuffle(cards);
    }
}
