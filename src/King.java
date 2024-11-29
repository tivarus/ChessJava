public class King extends ChessPiece {

    private static int kingLineW;
    private static int kingColumnW;
    private static int kingLineB;
    private static int kingColumnB;

    public void updatePosition(int line, int column) {
        if (this.color.equals("White")) {
            kingLineW = line;
            kingColumnW = column;
        } else {
            kingLineB = line;
            kingColumnB = column;
        }
    }

    public static int getKingLineW() {
        return kingLineW;
    }

    public static int getKingColumnW() {
        return kingColumnW;
    }

    public static int getKingLineB() {
        return kingLineB;
    }

    public static int getKingColumnB() {
        return kingColumnB;
    }

    public King(String color) {
        super(color);
        if (color.equals("White")) {
            kingLineW = 0;
            kingColumnW = 4;
        } else {
            kingLineB = 7;
            kingColumnB = 4;
        }
    }

    public String getSymbol() {
        return "K";
    }

    //Король
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1) {
            if (chessBoard.board[toLine][toColumn] != null) {
                // Проверка цвета фигуры, своих не ест
                return !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor());
            } else return true;
        } else return false;
    }

    public static boolean isUnderAttack(ChessBoard board, int line, int column, String kingColor) {
        // Проверяем все возможные позиции для атакующих фигур
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j] != null && !board.board[i][j].getColor().equals(kingColor)) {
                    if (board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false; // Позиция не под атакой
    }
}
