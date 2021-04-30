import java.util.Arrays;
import java.util.Random;

public class BlockManager {

    int numOfRows;
    int numOfCols;
    Random random = new Random();
    int symbolNumber = random.nextInt(4);
    int testNum;
    int counter = 0;

    BlockManager(int rows, int cols) {
        numOfRows = rows;
        numOfCols = cols;
        testNum = random.nextInt(rows);

    }

    private String[][] boardCreator() throws InterruptedException {
        String[][] board = new String[numOfRows][numOfCols];
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                board[i][j] = ".";



                // Symbol Generator
                if (symbolNumber == 0) {
                    board[testNum][0 + j] = "*";
                    Thread.sleep(50);
                } else if (symbolNumber == 1) {
                    board[testNum][0 + j] = "%";
                    Thread.sleep(50);
                } else if (symbolNumber == 2) {
                    board[testNum][0 + j] = "/";
                    Thread.sleep(50);
                } else if (symbolNumber == 3) {
                    board[testNum][0 + j] = "$";
                    Thread.sleep(50);
                } else {
                    board[testNum][0 + j] = "?";
                    Thread.sleep(50);
                }
                if (!board[i][j].equals(".")) {
                    counter++;
                }

            }
            System.out.println();
        }
        return board;
    }


    @Override
    public String toString() {
        String trimmedString = null;
        try {
            trimmedString = Arrays.deepToString(boardCreator());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        trimmedString = trimmedString
                .replace("[[", " ")
                .replace(",", "")
                .replace("[", "")
                .replace("]", "\n");
        return trimmedString;

    }
}
