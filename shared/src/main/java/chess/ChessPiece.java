package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    private final ChessGame.TeamColor pieceColor;
    private final PieceType type;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.pieceColor = pieceColor;
        this.type = type;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return pieceColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return type;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        return switch (type) {
            case BISHOP -> {
                BishopMovesCalculator bishopMoves = new BishopMovesCalculator(board, myPosition);
                yield bishopMoves.pieceMoves(board, myPosition);
            }
            case ROOK -> {
                RookMovesCalculator rookMoves = new RookMovesCalculator(board, myPosition);
                yield rookMoves.pieceMoves(board, myPosition);
            }
            case KING -> {
                KingMovesCalculator kingMoves = new KingMovesCalculator(board, myPosition);
                yield kingMoves.pieceMoves(board, myPosition);
            }
            case QUEEN -> {
                QueenMovesCalculator queenMoves = new QueenMovesCalculator(board, myPosition);
                yield queenMoves.pieceMoves(board, myPosition);
            }
            case KNIGHT -> {
                KnightMovesCalculator knightMoves = new KnightMovesCalculator();
                yield knightMoves.pieceMoves(board, myPosition);
            }
            case PAWN -> {
                PawnMovesCalculator pawnMoves = new PawnMovesCalculator();
                yield pawnMoves.pieceMoves(board, myPosition);
            }
        };

    }

    @Override
    public String toString() {
        return "ChessPiece{" +
                "pieceColor=" + pieceColor +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPiece that = (ChessPiece) o;
        return pieceColor == that.pieceColor && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceColor, type);
    }
}
