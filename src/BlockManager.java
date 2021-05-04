import java.util.Arrays;
import java.util.Random;

public class BlockManager {

    private final int numOfRows;
    private final int numOfCols;
    private int numOfBlocks;
    int counter = 0;
    private Random random = new Random();
    private String boardString;
    private String newPiece = "";
    private String[][] board;

    BlockManager(int rows, int cols, int blockTypes) {
        numOfRows = rows;
        numOfCols = cols;
        numOfBlocks = blockTypes;
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

    private String[][] piecePlacer(String pieceA,
                                   String pieceB, String pieceC) {
        int piecePlacement = random.nextInt(numOfCols);
        if (board[numOfRows - 1][piecePlacement].equals(".") &&
                (board[numOfRows - 2][piecePlacement].equals(".")) &&
                (board[numOfRows - 3][piecePlacement].equals("."))) {
            board[numOfRows - 1][piecePlacement] = pieceA;
            board[numOfRows - 2][piecePlacement] = pieceB;
            board[numOfRows - 3][piecePlacement] = pieceC;

        } else if (board[numOfRows - 4][piecePlacement].equals(".") &&
                (board[numOfRows - 5][piecePlacement].equals(".")) &&
                (board[numOfRows - 6][piecePlacement].equals("."))) {
            board[numOfRows - 4][piecePlacement] = pieceA;
            board[numOfRows - 5][piecePlacement] = pieceB;
            board[numOfRows - 6][piecePlacement] = pieceC;
        }
        return this.board;
    }

    private String[][] boardUpdater() {
        for (int a = 1; a < numOfRows - 1; a++) {
            for (int b = 1; b < numOfCols - 1; b++) {
                // Diagonal Matches
                if (board[a][b].equals(board[a + 1][b + 1]) &&
                        board[a][b].equals(board[a - 1][b - 1])) {
                    board[a][b] = ".";
                    board[a + 1][b + 1] = ".";
                    board[a - 1][b - 1] = ".";
                } else if (board[a][b].equals(board[a - 1][b + 1]) &&
                        board[a][b].equals(board[a + 1][b - 1])) {
                    board[a][b] = ".";
                    board[a - 1][b + 1] = ".";
                    board[a + 1][b - 1] = ".";
                }
            }
        }
        //Horizontal Matches
        for (int c = 0; c < numOfRows ; c++) {
            for (int d = 1; d < numOfCols - 1; d++) {
                if (board[c][d].equals(board[c][d - 1]) &&
                        board[c][d].equals(board[c][d + 1])) {
                    board[c][d] = ".";
                    board[c][d - 1] = ".";
                    board[c][d + 1] = ".";

                }
            }
        }
        //Vertical Matches
        for (int e = 1; e < numOfRows - 1; e++) {
            for (int f = 0; f < numOfCols; f++) {
                if (board[e][f].equals(board[e - 1][f]) &&
                        board[e][f].equals(board[e + 1][f])) {
                    board[e][f] = ".";
                    board[e - 1][f] = ".";
                    board[e + 1][f] = ".";
                }
            }
        }
            for (int g = numOfRows - 1; g > 0  ; g--) {
                for (int h = 0; h < numOfCols; h++) {

                    while (board[g][h].equals(".") && !board[g - 1][h].equals(".")) {
                        board[g][h] = board[g - 1][h];
                        board[g - 1][h] = ".";
                    }
                }
            }
            return board;
        }

        public String blankBoard () {
            board = boardCreator();
            boardString = Arrays.deepToString(board);
            boardString = boardString
                    .replace("[[", " ")
                    .replace(",", "")
                    .replace("[", "")
                    .replace("]", "\n");
            return boardString;
        }

        public String printNewBoard () {
            board = piecePlacer(pieceGenerator(),
                    pieceGenerator(), pieceGenerator());
            boardString = Arrays.deepToString(board);
            boardString = boardString
                    .replace("[[", " ")
                    .replace(",", "")
                    .replace("[", "")
                    .replace("]", "\n");
            return boardString;
        }

        public String printCheckedBoard () {
            board = boardUpdater();
            boardString = Arrays.deepToString(board);
            boardString = boardString
                    .replace("[[", " ")
                    .replace(",", "")
                    .replace("[", "")
                    .replace("]", "\n");
            return boardString;
        }

    }
