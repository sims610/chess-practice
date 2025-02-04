package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RookMovesCalculator implements MovesCalculator {
    private final ChessBoard board;
    private final ChessPosition myPosition;

    public RookMovesCalculator(ChessBoard board, ChessPosition myPosition) {
        this.board = board;
        this.myPosition = myPosition;
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> moves = new ArrayList<>();
        for (int i = myPosition.getRow(); i < 8;) {
            i++;
            if (board.getPiece(new ChessPosition(i, myPosition.getColumn())) != null) {
                ChessPiece otherPiece= board.getPiece(new ChessPosition(i, myPosition.getColumn()));
                ChessPiece myPiece = board.getPiece(myPosition);
                if (otherPiece.getTeamColor() != myPiece.getTeamColor()) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(i, myPosition.getColumn()), null));
                }
                break;
            }
            moves.add(new ChessMove(myPosition, new ChessPosition(i, myPosition.getColumn()), null));
        }
        for (int i = myPosition.getColumn(); i<8;) {
            i++;
            if (board.getPiece(new ChessPosition(myPosition.getRow(), i)) != null) {
                ChessPiece otherPiece= board.getPiece(new ChessPosition(myPosition.getRow(), i));
                ChessPiece myPiece = board.getPiece(myPosition);
                if (otherPiece.getTeamColor() != myPiece.getTeamColor()) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(), i), null));
                }
                break;
            }
            moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(), i), null));
        }
        for (int i = myPosition.getRow(); i > 1;) {
            i--;
            if (board.getPiece(new ChessPosition(i, myPosition.getColumn())) != null) {
                ChessPiece otherPiece= board.getPiece(new ChessPosition(i, myPosition.getColumn()));
                ChessPiece myPiece = board.getPiece(myPosition);
                if (otherPiece.getTeamColor() != myPiece.getTeamColor()) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(i, myPosition.getColumn()), null));
                }
                break;
            }
            moves.add(new ChessMove(myPosition, new ChessPosition(i, myPosition.getColumn()), null));
        }
        for (int i = myPosition.getColumn();i>1;) {
            i--;
            if (board.getPiece(new ChessPosition(myPosition.getRow(), i)) != null) {
                ChessPiece otherPiece= board.getPiece(new ChessPosition(myPosition.getRow(), i));
                ChessPiece myPiece = board.getPiece(myPosition);
                if (otherPiece.getTeamColor() != myPiece.getTeamColor()) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(), i), null));
                }
                break;
            }
            moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(), i), null));
        }
//        moves.add(new ChessMove(myPosition, new ChessPosition(5, 7), null));
        return moves;
    }
}
