import javax.swing.*;
import java.awt.*;

public class Tetris extends JFrame {

    int screenHeight = 650;
    int screenWidth = 650;

    public Tetris() {
        JPanel gamePanel = new JPanel() {
            public void paintComponent(Graphics g) {
                BlockManager logic = new BlockManager(6, 6, 3);
                logic.blankBoard();
                if (logic.pieceGenerator().equals("a")) {

                }
            }
        };
        getContentPane().add(gamePanel,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Tetris tetris = new Tetris();
        tetris.createGUI();
    }

private void createGUI() {
    Tetris gameFrame = new Tetris();
    gameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    gameFrame.setTitle("Tetris");
    gameFrame.setSize(screenWidth,screenHeight);
    gameFrame.setVisible(true);
}



}
