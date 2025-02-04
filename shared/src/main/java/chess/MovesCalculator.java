package chess;

import java.util.ArrayList;
import java.util.Collection;

public interface MovesCalculator {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition);
}
