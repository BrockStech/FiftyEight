import java.util.Iterator;
import java.util.List;

public class StartGame
{
    private static List<Card> hand;
    private static Card currentCard;
    private static UserInput input;

    public static void main(String[] args)
    {
        Deck deck = new Deck();
        deck.shuffle();

        Player player = new Player();
        hand = deck.deal();
        player.setHand(hand);
        player.showHand();
        System.out.print("\n");
        flipCard(0);
        System.out.print(redBlack() + "\n");
        flipCard(1);
        System.out.print(highLow() + "\n");
        flipCard(2);
        System.out.print(betweenOutside(0, 1));
        flipCard(3);
        System.out.print(guessSuit() + "\n");
        flipCard(4);
        System.out.print(highLow());
        flipCard(5);
        System.out.print(betweenOutside(0,4) + "\n");
        flipCard(6);
        System.out.print(guessCardRange() + "\n");
        flipCard(7);
        System.out.print(guessValue() + "\n");
        System.out.print(isFiftyEight() + "\n");
    }

    public static void flipCard(int cardIndex)
    {
        currentCard = hand.get(cardIndex);
    }

    public static boolean redBlack()
    {
        return userInput("Red or Black?", new String[]{"Red", "Black"}) == 0 ?
                currentCard.isRed() : currentCard.isBlack();
    }

    public static boolean highLow()
    {
        return userInput("Higher or Lower than " + hand.get(0).printValue(), new String[]{"Higher", "Lower"}) == 0 ?
                higher() : lower();
    }

    public static boolean betweenOutside(int card1, int card2)
    {
        return userInput("In between or outside of " + hand.get(card1).printValue() + " & " + hand.get(card2).printValue(), new String[]{"In between", "Outside"}) == 0 ?
                between(card1, card2) : outside(card1, card2);
    }

    public static boolean guessSuit()
    {
        return userInput("What is the suit?", new String[]{"Hearts", "Diamonds", "Clubs", "Spades"}) == currentCard.getSuit();
    }

    public static boolean guessCardRange()
    {
        switch (userInput("What is the card range?",new String[]{"Low(2-5)", "Medium(6-10)", "High(Jack-Ace)"}))
        {
            case 1:
                return currentCard.isLow();
            case 2:
                return currentCard.isMedium();
            case 3:
                return currentCard.isHigh();
            default:
                return false;
        }
    }

    public static boolean guessValue()
    {
        return userInput("What is the card value?", new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"}) + 2 == currentCard.getValue();
    }

    public static boolean isFiftyEight()
    {
        int total = 0;
        for (Card card : hand)
        {
            total = total + capCardValue(card);
        }
        System.out.print(total + "\n");
        return 58 == total;
    }

    private static boolean higher()
    {
        return currentCard.getValue() > hand.get(0).getValue();
    }

    private static boolean lower()
    {
        return currentCard.getValue() < hand.get(0).getValue();
    }

    private static boolean between(int card1, int card2)
    {
        int firstCardValue = hand.get(card1).getValue();
        int secondCardValue = hand.get(card2).getValue();
        return Math.max(firstCardValue, secondCardValue) > currentCard.getValue()
                && Math.min(firstCardValue, secondCardValue) < currentCard.getValue();
    }

    private static boolean outside(int card1, int card2)
    {
        int firstCardValue = hand.get(card1).getValue();
        int secondCardValue = hand.get(card2).getValue();
        return Math.max(firstCardValue, secondCardValue) < currentCard.getValue()
                || Math.min(firstCardValue, secondCardValue) > currentCard.getValue();
    }

    private static int capCardValue(Card card)
    {
        return card.getValue() > 10 ? 10 : card.getValue();
    }

    private static int userInput(String message, String[] buttons)
    {
        input = new UserInput(message, buttons);
        return input.userInputDefault();
    }
}
