package chess;

import java.util.ArrayList;
import java.util.Collection;

public class BishopMovesCalculator implements MovesCalculator {

    private final ChessBoard board;
    private final ChessPosition myPosition;

    public BishopMovesCalculator(ChessBoard board, ChessPosition myPosition) {
        this.board = board;
        this.myPosition = myPosition;
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> bishopMoves = new ArrayList<>();
        int i = myPosition.getRow();
        int j = myPosition.getColumn();
        while (i < 8 && j < 8) {
            i++; j++;
            if (board.getPiece(new ChessPosition(i, j)) != null) {
                ChessPiece otherPiece= board.getPiece(new ChessPosition(i, j));
                ChessPiece myPiece = board.getPiece(myPosition);
                if (otherPiece.getTeamColor() != myPiece.getTeamColor()) {
                    bishopMoves.add(new ChessMove(myPosition, new ChessPosition(i, j), null));
                }
                break;
            }
            bishopMoves.add(new ChessMove(myPosition, new ChessPosition(i, j), null));
        }
        i = myPosition.getRow();
        j = myPosition.getColumn();
        while (i > 1 && j < 8) {
            i--; j++;
            if (board.getPiece(new ChessPosition(i, j)) != null) {
                ChessPiece otherPiece= board.getPiece(new ChessPosition(i, j));
                ChessPiece myPiece = board.getPiece(myPosition);
                if (otherPiece.getTeamColor() != myPiece.getTeamColor()) {
                    bishopMoves.add(new ChessMove(myPosition, new ChessPosition(i, j), null));
                }
                break;
            }
            bishopMoves.add(new ChessMove(myPosition, new ChessPosition(i, j), null));
        }
        i = myPosition.getRow();
        j = myPosition.getColumn();
        while (i < 8 && j > 1) {
            i++; j--;
            if (board.getPiece(new ChessPosition(i, j)) != null) {
                ChessPiece otherPiece= board.getPiece(new ChessPosition(i, j));
                ChessPiece myPiece = board.getPiece(myPosition);
                if (otherPiece.getTeamColor() != myPiece.getTeamColor()) {
                    bishopMoves.add(new ChessMove(myPosition, new ChessPosition(i, j), null));
                }
                break;
            }
            bishopMoves.add(new ChessMove(myPosition, new ChessPosition(i, j), null));
        }
        i = myPosition.getRow();
        j = myPosition.getColumn();
        while (i > 1 && j > 1) {
            i--; j--;
            if (board.getPiece(new ChessPosition(i, j)) != null) {
                ChessPiece otherPiece= board.getPiece(new ChessPosition(i, j));
                ChessPiece myPiece = board.getPiece(myPosition);
                if (otherPiece.getTeamColor() != myPiece.getTeamColor()) {
                    bishopMoves.add(new ChessMove(myPosition, new ChessPosition(i, j), null));
                }
                break;
            }
            bishopMoves.add(new ChessMove(myPosition, new ChessPosition(i, j), null));
        }
        return bishopMoves;
    }
}
