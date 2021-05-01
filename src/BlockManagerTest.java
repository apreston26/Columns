public class BlockManagerTest {


    public static void main(String[] args) {
        BlockManagerTest test = new BlockManagerTest();
        test.bigBoard();
    }

    private void smallBoard(){
        BlockManager smallBoard = new BlockManager(3,3);
        String board = smallBoard.toString();
        System.out.print(board);
        System.out.println("Objects on Screen: " + smallBoard.counter );
    }

    private void bigBoard() {
        BlockManager bigBoard = new BlockManager(7,7);
        String board = bigBoard.toString();
        System.out.print(board);
        System.out.println("Objects on Screen: " + bigBoard.counter );
    }
}
