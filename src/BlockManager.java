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
    for (int i = 1; i < numOfRows - 1; i++) {
      for (int j = 1; j < numOfCols - 1; j++) {
        // Diagonal Matches
        if ( board[i][j].equals(board[i + 1][j + 1 ]) && board[i][j].equals(board[i - 1][j - 1])) {
          board[i][j] = ".";
          board[i + 1][j + 1] = ".";
          board[i - 1][j - 1] = ".";
//           Horizontal Matches
        } else if (board[i][j].equals(board[i][j - 1 ]) && board[i][j].equals(board[i][j + 1])) {
          board[i][j] = ".";
          board[i][j - 1] = ".";
          board[i][j + 1] = ".";

//             Vertical Matches
          } else if (board[i][j].equals(board[i - 1][j]) && board[i][j].equals(board[i + 1][j]) ) {
          board[i][j] = ".";
          board[i - 1][j] = ".";
          board[i + 1][j] = ".";
        }
      }
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

  public String printCheckedBoard() {
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
