public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    public String getSymbol() {
        return "Q";
    }

    //Королева
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine == line || toColumn == column || (Math.abs(line - toLine) == Math.abs(column - toColumn))) {
            //Проверка наличия фигур на пути
            int lineOrient = Integer.compare(toLine, line); // Направление по строкам
            int columnOrient = Integer.compare(toColumn, column); // Направление по столбцам
            int curLine = line + lineOrient;
            int curColumn = column + columnOrient;
            while (curLine != toLine || curColumn != toColumn) {
                if (chessBoard.board[curLine][curColumn] != null) {
                    return false;
                }
                curColumn += columnOrient;
                curLine += lineOrient;
            }
            // Если далее находится фигура
            if (chessBoard.board[toLine][toColumn] != null) {
                // Проверка цвета фигуры, своих не ест
                return !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor());
            } else return true;
        } else return false;
    }
}
