import javax.swing.*;

public class UserInput
{
    private Object[] buttons;
    private String message;
    private String flippedCards;

    public UserInput(String flippedCards, String message, String[] buttons)
    {
        this.buttons = buttons;
        this.message = message;
        this.flippedCards = flippedCards;
    }

    public UserInput()
    {

    }

    public int userInputDefault()
    {
        return JOptionPane.showOptionDialog(null, flippedCards, message, JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, buttons, null);
    }

    public void showResult(String result)
    {
        JOptionPane.showConfirmDialog(null, result, "Result", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
    }
}
