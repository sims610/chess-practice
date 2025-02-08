package chess;

import java.util.ArrayList;
import java.util.Collection;

public class QueenMovesCalculator implements MovesCalculator{
    private ChessBoard board;
    private ChessPosition myPosition;

    public QueenMovesCalculator(ChessBoard board, ChessPosition myPosition) {
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        this.board = board;
        this.myPosition = myPosition;
        Collection<ChessMove> queenMoves = new ArrayList<>();
        BishopMovesCalculator bishopCalc = new BishopMovesCalculator(board, myPosition);
        RookMovesCalculator rookCalc = new RookMovesCalculator(board, myPosition);
        Collection<ChessMove> bishopMoves = bishopCalc.pieceMoves(board, myPosition);
        Collection<ChessMove> rookMoves = rookCalc.pieceMoves(board, myPosition);
        queenMoves.addAll(bishopMoves);
        queenMoves.addAll(rookMoves);
        return queenMoves;
    }
}
