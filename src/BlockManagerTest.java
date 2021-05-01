public class BlockManagerTest {


    public static void main(String[] args) {
        BlockManagerTest test = new BlockManagerTest();
        test.smallBoard();
    }

    private void smallBoard(){
        BlockManager smallBoard = new BlockManager(3,3, 4);
        String board = smallBoard.toString();
        System.out.print(board);
        System.out.println("Objects on Screen: " + smallBoard.counter );
        System.out.println("piece " + smallBoard.pieceGenerator() );
    }

    private void bigBoard() {
        BlockManager bigBoard = new BlockManager(7,7, 4);
        String board = bigBoard.toString();
        System.out.println("Test second block manager");
        System.out.print(board);
        System.out.println("Objects on Screen: " + bigBoard.counter );
    }
}
