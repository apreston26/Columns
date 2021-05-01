import java.util.Random;

public class BlockManagerTest {

    Random random = new Random();
    int minSize = 5;
    int maxSize = 10;
    int rowSize = (int) (Math.random() * (maxSize - minSize)) + minSize;
    int colSize = (int) (Math.random() * (maxSize - minSize)) + minSize;
    int numOfBlockTypes = 3;
    int numOfTurns = 10;

    public static void main(String[] args) {
        BlockManagerTest test = new BlockManagerTest();
        test.bigBoard();

    }

    private void smallBoard(){
        BlockManager smallBoard = new BlockManager(10, 10, numOfBlockTypes);
        String board = smallBoard.toString();
        System.out.println("Test first block manager");
        System.out.print(board);
        System.out.println("Objects on Screen: " + smallBoard.counter );
        System.out.println(smallBoard.pieceGenerator() );
    }

    private void bigBoard() {
        BlockManager bigBoard = new BlockManager(6, 4, numOfBlockTypes);
        System.out.println("Test second block manager");
        System.out.println("Created empty game with " + rowSize + " rows, " +
                colSize + " cols, " + numOfBlockTypes + " block types");
        System.out.println(bigBoard.blankBoard());
        for (int i = 0; i < numOfTurns - 1; i++) {

            System.out.println(bigBoard.printNewBoard());
        }
    }
}
