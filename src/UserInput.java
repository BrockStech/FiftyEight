import javax.swing.*;

public class UserInput
{
    private Object[] buttons;
    private String message;

    public UserInput(String message, String[] buttons)
    {
        this.buttons = buttons;
        this.message = message;
    }

    public int userInputDefault()
    {
        return JOptionPane.showOptionDialog(null, message, null, JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, buttons, null);
    }

}
