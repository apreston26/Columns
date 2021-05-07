import java.util.Arrays;
import java.util.Random;

public class BlockManager {

    private final int numOfRows;
    private final int numOfCols;
    private int numOfBlocks;
    private Random random = new Random();
    String boardString;
    private String newPiece = "";
    String[][] board;
    boolean caseFound = false;
    String typeOfMatch;

    BlockManager(int rows, int cols, int blockTypes) {
        numOfRows = rows;
        numOfCols = cols;
        numOfBlocks = blockTypes;
    }

    /**
     * boardCreator is a method that creates the initial board of dots
     * @returns a blank board which is represented as a 2D array
     */
    public String[][] boardCreator() {
        board = new String[numOfRows][numOfCols];
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                board[i][j] = ".";
            }
        }
        return board;
    }

    /**
     * pieceGenerator is used to create all the pieces needed for varying
     * difficulties and I recommend for testing purposes to only use 2 or 3
     * pieces
     * @return newPiece is a single symbol that will be used to make a new piece
     */
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

    /**
     * piecePlacer is the second most crucial part of this program that would
     * place our pieces down on the board using pieceGenerator for the args.
     * @returns a newly updated board that will included a new piece
     */
    private String[][] piecePlacer() {
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                while (board[i][j].equals(".")) {
                    board[i][j] = pieceGenerator();
                }
            }
        }
        return this.board;
    }

    /**
     * This method is what keeps the board in check when a match has been found
     * @returns a newly checked board that will have moved any pieces that would
     * otherwise have an empty space between other pieces under it as well as
     * remove pieces that are matching 3 in any direction
     */
    private String[][] boardUpdater() {

        for (int a = 1; a < numOfRows - 1; a++) {
            for (int b = 1; b < numOfCols - 1; b++) {
                // Diagonal Matches
                if (board[a][b].equals(board[a + 1][b + 1]) &&
                        board[a][b].equals(board[a - 1][b - 1])) {
                    board[a][b] = ".";
                    board[a + 1][b + 1] = ".";
                    board[a - 1][b - 1] = ".";
                    caseFound = true;
                    typeOfMatch = "Diagonal Match";
                } else if (board[a][b].equals(board[a - 1][b + 1]) &&
                        board[a][b].equals(board[a + 1][b - 1])) {
                    board[a][b] = ".";
                    board[a - 1][b + 1] = ".";
                    board[a + 1][b - 1] = ".";
                    caseFound = true;
                    typeOfMatch = "Diagonal Match";
                } else {
                    caseFound = false;
                }
            }
        }
        //Horizontal Matches
        for (int c = 0; c < numOfRows; c++) {
            for (int d = 1; d < numOfCols - 1; d++) {
                if (board[c][d].equals(board[c][d - 1]) &&
                        board[c][d].equals(board[c][d + 1])) {
                    board[c][d] = ".";
                    board[c][d - 1] = ".";
                    board[c][d + 1] = ".";
                    caseFound = true;
                    typeOfMatch = "Horizontal Match";
                } else {
                    caseFound = false;
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
                    caseFound = true;
                    typeOfMatch = "Vertical Match";
                } else {
                    caseFound = false;
                }
            }
        }
        for (int g = numOfRows - 1; g > 0; g--) {
            for (int h = 0; h < numOfCols; h++) {

                while (board[g][h].equals(".") && !board[g - 1][h].equals(".")) {
                    board[g][h] = board[g - 1][h];
                    board[g - 1][h] = ".";
                    boardUpdater();
                }
            }
        }
        return board;
    }

    /**
     * blankBoard provides outside classes to create a blank board
     * @returns a new blank board that is properly formatted to make a board
     */
    public String[][] blankBoard() {
        board = boardCreator();
        boardString = Arrays.deepToString(board);
        boardString = boardString
                .replace("[[", " ")
                .replace(",", "")
                .replace("[", "")
                .replace("]", "\n");
        return board;
    }

    /**
     * This provides outside classes with a board that has a new piece inside it
     * @return a new board that is formatted along with a new piece
     */
    public String[][] printNewBoard() {
        board = piecePlacer();
        boardString = Arrays.deepToString(board);
        boardString = boardString
                .replace("[[", " ")
                .replace(",", "")
                .replace("[", "")
                .replace("]", "\n");
        return board;
    }

    /**
     * This provides outsides classes with a board that has been checked of
     * "floating" pieces and matching pieces
     * @return a new board that is formatted and checked of the specified
     * conditions
     */
    public String[][] printCheckedBoard() {
        board = boardUpdater();
        boardString = Arrays.deepToString(board);
        boardString = boardString
                .replace("[[", " ")
                .replace(",", "")
                .replace("[", "")
                .replace("]", "\n");
        return board;
    }

}
