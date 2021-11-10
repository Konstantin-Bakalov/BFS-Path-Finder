import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Frame.resetButton) {
            for(int i = 0; i < Frame.buttons.length; i++) {
                Frame.buttons[i].setBackground(Frame.c);
                Frame.buttons[i].setEnabled(true);
                Frame.draw = true;
                Frame.changeLabelTextToOriginal();
            }
        }
    }
}