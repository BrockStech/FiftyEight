public class Card
{
    private int suit;
    private int value;
    private String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public Card(int suit, int value)
    {
        this.suit = suit;
        this.value = value + 2;
    }

    public boolean isRed()
    {
        return suit < 2;
    }

    public boolean isBlack()
    {
        return suit >= 2;
    }

    public boolean isLow()
    {
        return value <= 5;
    }

    public boolean isMedium()
    {
        return value > 5 && value <= 10;
    }

    public boolean isHigh()
    {
        return value > 10;
    }

    public int getValue()
    {
        return value;
    }

    public int getSuit()
    {
        return suit;
    }

    public String print()
    {
        return values[value - 2] + " of " + suits[suit];
    }

    public String printValue()
    {
        return values[value - 2];
    }
}