import java.util.Arrays;
import java.util.Random;

public class BlockManager {

    int numOfRows;
    int numOfCols;
    int numOfBlocks;
    int symbolNumber;
    int counter = 0;
    Random random = new Random();
    String boardString;
    String newPiece = "";
    String[][] board;

    BlockManager(int rows, int cols, int blockTypes) {
        numOfRows = rows;
        numOfCols = cols;
        numOfBlocks = blockTypes;
        symbolNumber = random.nextInt(4);
    }

    public String[][] boardCreator() {
        board = new String[numOfRows][numOfCols];
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                board[i][j] = ".";
            }
        }
        return board;
    }

    public String pieceGenerator() {
        int firstPiece = random.nextInt(numOfBlocks);
        switch (firstPiece) {
            case 0 -> newPiece = "a";
            case 1 -> newPiece = "b";
            case 2 -> newPiece = "c";
            case 3 -> newPiece = "d";
            case 4 -> newPiece = "e";
            case 5 -> newPiece = "f";
        }
        return newPiece;
    }


    private String[][] boardUpdater(String[][] boardToUse, String pieceA,
                                    String pieceB, String pieceC) {
        int piecePlacement = random.nextInt(numOfCols);

            if (boardToUse[numOfRows - 1][piecePlacement].equals(".") &&
                    (boardToUse[numOfRows - 2][piecePlacement].equals(".")) &&
                    (boardToUse[numOfRows - 3][piecePlacement].equals("."))) {
                boardToUse[numOfRows - 1][piecePlacement] = pieceA;
                boardToUse[numOfRows - 2][piecePlacement] = pieceB;
                boardToUse[numOfRows - 3][piecePlacement] = pieceC;

            } else if (boardToUse[numOfRows - 4][piecePlacement].equals(".") &&
                (boardToUse[numOfRows - 5][piecePlacement].equals(".")) &&
                (boardToUse[numOfRows - 6][piecePlacement].equals("."))) {
                boardToUse[numOfRows - 4][piecePlacement] = pieceA;
                boardToUse[numOfRows - 5][piecePlacement] = pieceB;
                boardToUse[numOfRows - 6][piecePlacement] = pieceC;
            }
        return board;
    }

    public String blankBoard() {
        board = boardCreator();
        boardString = Arrays.deepToString(board);
        boardString = boardString
                .replace("[[", " ")
                .replace(",", "")
                .replace("[", "")
                .replace("]", "\n");
        return boardString;
    }

    public String printNewBoard() {
        board = boardUpdater(board, pieceGenerator(),
                pieceGenerator(), pieceGenerator());
        boardString = Arrays.deepToString(board);
        boardString = boardString
                .replace("[[", " ")
                .replace(",", "")
                .replace("[", "")
                .replace("]", "\n");
        return boardString;
    }


}
