import java.util.Arrays;
import java.util.Random;

public class BlockManager {

    int numOfRows;
    int numOfCols;
    int numOfBlocks;
    int symbolNumber;
    int counter = 0;
    int pieceSize = 3;
    Random random = new Random();
    String boardString;
    String newPiece = "";

    BlockManager(int rows, int cols, int blockTypes) {
        numOfRows = rows;
        numOfCols = cols;
        numOfBlocks = blockTypes;
        symbolNumber = random.nextInt(4);
    }

    private String[][] boardCreator() {
        String[][] board = new String[numOfRows][numOfCols];
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                board[i][j] = ".";
                if (!board[i][j].equals(".")) {
                    counter++;
                }
            }
        }
        return board;
    }

    public String pieceGenerator() {
        for (int i = 0; i < pieceSize; i++) {
            int firstPiece = random.nextInt(pieceSize);
            switch (firstPiece) {
                case 0 -> newPiece += "a";
                case 1 -> newPiece += "b";
                case 2 -> newPiece += "c";

            }
        }
        return newPiece;
    }

    @Override
    public String toString() {
        boardString = Arrays.deepToString(boardCreator());
        boardString = boardString
                .replace("[[", " ")
                .replace(",", "")
                .replace("[", "")
                .replace("]", "\n");
        return boardString;

    }
}
