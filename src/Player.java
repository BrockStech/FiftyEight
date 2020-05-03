import java.util.ArrayList;
import java.util.List;

public class Player
{
    private List<Card> hand;
    private int score;

    public Player()
    {
        hand = new ArrayList<Card>();
        score = 0;
    }

    public void setHand(List<Card> hand)
    {
        this.hand = hand;
    }

    public void showHand()
    {
        for (Card card : hand)
        {
            System.out.print(card.print() + "\n");
        }
    }
}
