public class BlockManagerTest {

  private static final int MIN_SIZE = 5;
  private static final int MAX_SIZE = 10;
  private static final int ROW_SIZE = (int) (Math.random() * (MAX_SIZE - MIN_SIZE)) + MIN_SIZE;
  private static final int COL_SIZE = (int) (Math.random() * (MAX_SIZE - MIN_SIZE)) + MIN_SIZE;
  private static final int NUM_OF_BLOCK_TYPES = 3;
  private static final int NUM_OF_TURNS = 10;

  public static void main(String[] args) {
    BlockManagerTest test = new BlockManagerTest();
    test.bigBoard();

  }

  private void smallBoard() {
    BlockManager smallBoard = new BlockManager(ROW_SIZE, COL_SIZE, NUM_OF_BLOCK_TYPES);
    String board = smallBoard.toString();
    System.out.println("Test first block manager");
    System.out.print(board);
    System.out.println("Objects on Screen: " + smallBoard.counter);
    System.out.println(smallBoard.pieceGenerator());
  }

  private void bigBoard() {
    BlockManager bigBoard = new BlockManager(ROW_SIZE, COL_SIZE, NUM_OF_BLOCK_TYPES);
    System.out.println("Test second block manager");
    System.out.println("Created empty game with " + ROW_SIZE + " rows, " +
        COL_SIZE + " cols, " + NUM_OF_BLOCK_TYPES + " block types");
    System.out.println(bigBoard.blankBoard());
    for (int i = 0; i < NUM_OF_TURNS - 1; i++) {
      System.out.println("Dropping new piece . . .");
      System.out.println(bigBoard.printNewBoard());
      System.out.println("Checking for columns . . .");
      System.out.println(bigBoard.printCheckedBoard());
    }
  }
}
