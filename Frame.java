import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    MainPanel mainPanel;
    BackPanel backPanel;
    static JButton[] buttons;
    static final int buttonNumber = 30;
    static JButton startButton;
    static JButton resetButton;
    static boolean mouse;
    static boolean draw;
    static JLabel instructions;
    static Color green = new Color(56, 218, 62);
    static Color c = new Color(56, 144, 147);

    public Frame() {
        super("BFS Path Finder");
        this.setSize(600 ,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        setMainPanel();
        setBackPanel();

        setStartButton();
        setResetButton();

        mouse = false;
        draw = true;

        this.add(mainPanel);
        this.add(backPanel);
        this.setVisible(true);
    }

    private void setMainPanel() {
        mainPanel = new MainPanel();
        mainPanel.setBounds(0, 0, 600, 600);
        mainPanel.setLayout(null);
        addButtons();
    }

    private void setBackPanel() {
        backPanel = new BackPanel();
        backPanel.setBounds(0, 600, 600, 100);
        backPanel.setLayout(null);
        backPanel.setBackground(Color.GRAY);

        setInstructions();
        backPanel.add(instructions);
    }

    public void setInstructions() {
        instructions = new JLabel();
        instructions.setBounds(230, 5, 360, 50);
        instructions.setForeground(Color.BLACK);
        instructions.setFont(new Font("Helvetica", Font.ITALIC, 13));
        instructions.setText("Shortest Path between top left and bottom right node");
        instructions.setBorder(BorderFactory.createLineBorder(Color.BLACK ,2));
        instructions.setHorizontalAlignment(JLabel.CENTER);
    }

    public static void changeLabelTextToNoPath() {
        instructions.setFont(new Font("Helvetica", Font.ITALIC, 15));
        instructions.setText("No Path");
    }

    public static void changeLabelTextToOriginal() {
        instructions.setFont(new Font("Helvetica", Font.ITALIC, 13));
        instructions.setText("Shortest Path between top left and bottom right node");
    }

    private void addButtons() {
        buttons = new JButton[900];

        for(int i = 0; i < Frame.buttons.length; i++) {
                buttons[i] = new JButton();
        }

        for(int i = 0; i < 30; i++) {
            for(int j = 0; j < 30; j++) {
                buttons[i * 30 + j].setBounds(j * 20, i * 20, 20, 20);
            }
        }

        for(int i = 0; i < Frame.buttons.length; i++) {
            buttons[i].setFocusable(false);
            buttons[i].setOpaque(true);
            buttons[i].setBackground(c);
            buttons[i].addMouseListener(new ButtonMouseListener());
            mainPanel.add(buttons[i]);
        }
    }

    private void setStartButton() {
        startButton = new JButton();
        startButton.setBounds(10, 5, 100, 50);
        startButton.setFocusable(false);
        startButton.setFont(new Font("Helvetica", Font.ITALIC, 20));
        startButton.setText("Start");
        startButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        startButton.setForeground(Color.BLACK);
        startButton.setBackground(Color.GRAY);
        backPanel.add(startButton);
        startButton.addActionListener(new StartButtonListener());
    }

    private void setResetButton() {
        resetButton = new JButton();
        resetButton.setBounds(120, 5, 100, 50);
        resetButton.setFocusable(false);
        resetButton.setFont(new Font("Helvetica", Font.ITALIC, 20));
        resetButton.setText("Reset");
        resetButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        resetButton.setForeground(Color.BLACK);
        resetButton.setBackground(Color.GRAY);
        resetButton.addActionListener(new ResetButtonListener());
        backPanel.add(resetButton);
    }
}