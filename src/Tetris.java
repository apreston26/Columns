import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Tetris extends JFrame {

    int screenHeight = 650;
    int screenWidth = 650;
    int boxSize = screenWidth / ROW_SIZE;
    private static final int ROW_SIZE = 8;
    private static final int COLUMN_SIZE = 8;
    private static final int NUM_OF_BLOCK_TYPES = 3;
    String[][] gameBoard;

    public Tetris() {
        setTitle("Candy Crush");
        newGame();
        setSize(screenWidth,screenHeight);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void newGame() {
        JPanel gamePanel = new JPanel() {
            public void paintComponent(Graphics g) {
                BlockManager logic = new BlockManager(ROW_SIZE, COLUMN_SIZE, NUM_OF_BLOCK_TYPES);
                gameBoard = logic.blankBoard();
                for (int i = 0; i < ROW_SIZE; i++) {
                    for (int j = 0; j < COLUMN_SIZE; j++) {
                        if (gameBoard[i][j].equals(".")) {
                            g.drawRect(i * boxSize  , j * boxSize, boxSize, boxSize);
                        }

                    }
                }
            }
        };
        getContentPane().add(gamePanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new Tetris();

    }


}
