public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    public String getSymbol() {
        return "R";
    }

    //Ладья
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //Если ладья ходит не по вертикали и не по горизонтали
        if (toLine != line && toColumn != column) {
            return false;
        }
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
        if (chessBoard.board[toLine][toColumn] != null) {
            // Проверка цвета фигуры, своих не ест
            return !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor());
        } else return true;
    }
}
