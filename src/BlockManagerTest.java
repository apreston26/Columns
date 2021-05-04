public class BlockManagerTest {

  private static final int MIN_SIZE = 6;
  private static final int MAX_SIZE = 10;
  private static final int ROW_SIZE = (int)
          (Math.random() * (MAX_SIZE - MIN_SIZE)) + MIN_SIZE;
  private static final int COL_SIZE = (int) (
          Math.random() * (MAX_SIZE - MIN_SIZE)) + MIN_SIZE;
  private static final int NUM_OF_BLOCK_TYPES = 3;
  private static final int NUM_OF_TURNS = 10;

  public static void main(String[] args) {
    BlockManagerTest test = new BlockManagerTest();
    test.secondBoard();
    test.firstBoard();
  }

  /**
   * A method that will check our BlockManager class for the first time
   */
  private void firstBoard() {
    BlockManager firstBoard = new
            BlockManager(ROW_SIZE, COL_SIZE, NUM_OF_BLOCK_TYPES);
    System.out.println("Test first block manager");
    System.out.println("Created empty game with " + ROW_SIZE + " rows, " +
            COL_SIZE + " cols, " + NUM_OF_BLOCK_TYPES + " block types");
    System.out.println(firstBoard.blankBoard());
    for (int i = 0; i < NUM_OF_TURNS - 1; i++) {
      System.out.println("Dropping new piece . . . ");
      System.out.println(firstBoard.printNewBoard());
      System.out.println("Checking for columns . . .");
      if (firstBoard.caseFound) {
        System.out.println(firstBoard.typeOfMatch + " has been found");
      } else {
        System.out.println("No matches have been found");
      }
      System.out.println(firstBoard.printCheckedBoard());
    }
  }

  /**
   * A method that will check our BlockManager class for the second time
   */
  private void secondBoard() {
    BlockManager secondBoard = new
            BlockManager(ROW_SIZE, COL_SIZE, NUM_OF_BLOCK_TYPES);
    System.out.println("Test second block manager");
    System.out.println("Created empty game with " + ROW_SIZE + " rows, " +
        COL_SIZE + " cols, " + NUM_OF_BLOCK_TYPES + " block types");
    System.out.println(secondBoard.blankBoard());
    for (int i = 0; i < NUM_OF_TURNS - 1; i++) {
      System.out.println("Dropping new piece . . . ");
      System.out.println(secondBoard.printNewBoard());
      System.out.println("Checking for columns . . .");
      if (secondBoard.caseFound) {
        System.out.println(secondBoard.typeOfMatch + " has been found");
      } else {
        System.out.println("No matches have been found");
      }
      System.out.println(secondBoard.printCheckedBoard());
    }
  }
}
