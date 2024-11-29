public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    public String getSymbol() {
        return "P";
    }

    //Пешка
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //ход вперед и конечное место не занято
        if(column == toColumn && chessBoard.board[toLine][toColumn] == null) {
            if (color.equals("White") && toLine - line == 2) {
                //шаг+2, возможен в первый ход пешки, если перед ней никого нет
                return line == 1 && toLine == 3 && chessBoard.board[toLine-1][toColumn] == null;
            } else if (color.equals("Black") && line - toLine == 2) {
                //шаг+2, возможен в первый ход пешки, если перед ней никого нет
                return line == 6 && toLine == 4 && chessBoard.board[toLine+1][toColumn] == null;
            } else //Шаг+1
                return ((color.equals("White") && toLine - line == 1) ||
                        (color.equals("Black") && line - toLine == 1));
        }
        //Пешка ест вперед по диагонали+1
        else if (Math.abs(column - toColumn) == 1 &&
                ((color.equals("White") && toLine - line == 1) ||
                    (color.equals("Black") && line - toLine == 1))) {
                // Если нет фигур для нападения
                if (chessBoard.board[toLine][toColumn] == null) {
                    return false;
                    // Проверка цвета фигуры, своих не ест
                } else return !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor());
        } else return false;
    }
}
