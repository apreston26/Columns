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


    private void newGame() {
        JPanel gamePanel = new JPanel() {
            public void paintComponent(Graphics g) {
                BlockManager logic = new BlockManager(ROW_SIZE, COLUMN_SIZE, NUM_OF_BLOCK_TYPES);
                gameBoard = logic.blankBoard();
                for (int i = 0; i < ROW_SIZE; i++) {
                    for (int j = 0; j < COLUMN_SIZE; j++) {
                        if (gameBoard[i][j].equals(".")) {
                            for (int c = 0; c < screenWidth; c += boxSize) {
                                for (int d = 0; d < screenHeight; d += boxSize)
                                    g.drawRect(c, d, boxSize, boxSize);
                            }
                        }
                    }
                }
            }
        };

        getContentPane().add(gamePanel, BorderLayout.CENTER);
    }

    private void setButton() {
        for (int i = 1; i < 6; i++) {
            add(new JButton("Button" + i));
        }
    }

    public static void main(String[] args) {
       Tetris tetris = new Tetris();
       tetris.createGUI();
    }

    private void createGUI() {
        setTitle("Candy Crush");
        setSize(screenWidth,screenHeight);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
