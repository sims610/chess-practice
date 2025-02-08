package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KnightMovesCalculator implements MovesCalculator{
    private ChessBoard board;
    private ChessPosition myPosition;

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        this.board = board;
        this.myPosition = myPosition;
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        Collection<ChessMove> knightMoves = new ArrayList<>();
        if (inBounds(knightMoves, row+2, col-1)) {
            knightMoves.add(new ChessMove(myPosition, new ChessPosition(row+2, col-1), null));
        }
        if (inBounds(knightMoves, row+2, col+1)) {
            knightMoves.add(new ChessMove(myPosition, new ChessPosition(row+2, col+1), null));
        }
        if (inBounds(knightMoves, row+1, col+2)) {
            knightMoves.add(new ChessMove(myPosition, new ChessPosition(row+1, col+2), null));
        }
        if (inBounds(knightMoves, row-1, col+2)) {
            knightMoves.add(new ChessMove(myPosition, new ChessPosition(row-1, col+2), null));
        }
        if (inBounds(knightMoves, row-2, col+1)) {
            knightMoves.add(new ChessMove(myPosition, new ChessPosition(row-2, col+1), null));
        }
        if (inBounds(knightMoves, row-2, col-1)) {
            knightMoves.add(new ChessMove(myPosition, new ChessPosition(row-2, col-1), null));
        }
        if (inBounds(knightMoves, row-1, col-2)) {
            knightMoves.add(new ChessMove(myPosition, new ChessPosition(row-1, col-2), null));
        }
        if (inBounds(knightMoves, row+1, col-2)) {
            knightMoves.add(new ChessMove(myPosition, new ChessPosition(row+1, col-2), null));
        }
        return knightMoves;
    }

    Boolean inBounds(Collection<ChessMove> knightMoves,int row, int col) {
        int min = 1;
        int max = 8;
        if (min <= row && row <= max) {
            if (min <= col && col <= max) {
                return isValid(knightMoves, row, col);
            }
        } else {
            return false;
        }
        return false;
    }

    Boolean isValid(Collection<ChessMove> knightMoves, int row, int col) {
        if (board.getPiece(new ChessPosition(row, col)) != null) {
            if (board.getPiece(new ChessPosition(row, col)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                knightMoves.add(new ChessMove(myPosition, new ChessPosition(row, col), null));
                return false;
            } else return false;
        }
        return true;
    }
}
