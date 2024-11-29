public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }
    public String getSymbol() {
        return "H";
    }
    //Конь
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn)
    {
        if(Math.abs(line - toLine) + Math.abs(column - toColumn) == 3 &&
                toLine != line && toColumn != column) {
            // Если далее находится фигура
            if (chessBoard.board[toLine][toColumn] != null) {
                // Проверка цвета фигуры, своих не ест
                return !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor());
            } else return true;
        } else return false;
    }
}
