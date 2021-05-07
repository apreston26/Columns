import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Tetris extends JFrame {

    int screenHeight = 700;
    int screenWidth = 700;
    int boxSize = screenWidth / ROW_SIZE;
    private static final int ROW_SIZE = 8;
    private static final int COLUMN_SIZE = 8;
    private static final int NUM_OF_BLOCK_TYPES = 4;
    String[][] gameBoard;

    public Tetris() {
        setTitle("Candy Crush");
        newGame();
        setSize(screenWidth, screenHeight);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void newGame()  {

        BlockManager logic = new BlockManager(ROW_SIZE, COLUMN_SIZE,
                NUM_OF_BLOCK_TYPES);
        gameBoard = logic.blankBoard();
        JPanel gamePanel = new JPanel() {
            public void paintComponent(Graphics g) {
                gameBoard = logic.printCheckedBoard();
                System.out.println(logic.boardString);
                for (int i = 0; i < ROW_SIZE; i++) {
                    for (int j = 0; j < COLUMN_SIZE; j++) {

                        switch (gameBoard[i][j]) {
                            case "." -> {
                                g.setColor(Color.BLACK);
                                g.drawRect(i * boxSize, j * boxSize,
                                        boxSize, boxSize);
                            }
                            case "a" -> {
                                g.setColor(Color.GREEN);
                                g.fillRect(i * boxSize, j * boxSize,
                                        boxSize, boxSize);
                            }
                            case "b" -> {
                                g.setColor(Color.RED);
                                g.fillRect(i * boxSize, j * boxSize,
                                        boxSize, boxSize);
                            }
                            case "c" -> {
                                g.setColor(Color.BLUE);
                                g.fillRect(i * boxSize, j * boxSize,
                                        boxSize, boxSize);
                            }
                            case "d" -> {
                                g.setColor(Color.YELLOW);
                                g.fillRect(i * boxSize, j * boxSize,
                                        boxSize, boxSize);
                            }

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
