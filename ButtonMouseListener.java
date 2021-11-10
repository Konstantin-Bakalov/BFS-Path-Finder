import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonMouseListener implements MouseListener {
    @Override
    public void mousePressed(MouseEvent e) {
        Frame.mouse = true;
        for(int i = 0; i < Frame.buttons.length; i++) {
                if(e.getSource() == Frame.buttons[i] && Frame.mouse && Frame.draw && Frame.buttons[i].isEnabled()) {
                    Frame.buttons[i].setEnabled(false);
                    Frame.buttons[i].setBackground(Color.BLACK);
                }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(int i = 0; i < 900; i++) {
                if(e.getSource() == Frame.buttons[i]) {
                    if(e.getButton() == MouseEvent.BUTTON1 && Frame.draw && Frame.buttons[i].isEnabled()) {
                        Frame.buttons[i].setBackground(Color.BLACK);
                        Frame.buttons[i].setEnabled(false);
                    }
                }
            }
        }

    @Override
    public void mouseReleased(MouseEvent e) {
        Frame.mouse = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for(int i = 0; i < Frame.buttons.length; i++) {
                if(e.getSource() == Frame.buttons[i] && Frame.draw && Frame.mouse && Frame.buttons[i].isEnabled()) {
                    Frame.buttons[i].setEnabled(false);
                    Frame.buttons[i].setBackground(Color.BLACK);
                }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}