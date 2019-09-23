package com.solarwindsmsp.chess;

public class ChessBoard {
    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];

    }

    public void Add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (xCoordinate < 0
                || xCoordinate > MAX_BOARD_WIDTH - 1
                || yCoordinate < 0
                || yCoordinate > MAX_BOARD_HEIGHT - 1) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        } else if (pieces[xCoordinate][yCoordinate] == null) {
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pieces[xCoordinate][yCoordinate] = pawn;
        } else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
    }

    // Not sure if this is for a legal board position for a pawn or it is just to check that the coordinates are within range; I did the latter.
    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return (xCoordinate >= 0
                && xCoordinate <= ChessBoard.MAX_BOARD_WIDTH - 1)
                && (yCoordinate >= 0
                && yCoordinate <= ChessBoard.MAX_BOARD_HEIGHT - 1);
    }
}
