package com.solarwindsmsp.chess;

public class Pawn {
    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChesssBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
        if (!chessBoard.IsLegalBoardPosition(newX, newY))
            return;

        switch (movementType) {
            case MOVE:
                doMoveBasedOnColour(newX, newY);
                break;
            case CAPTURE:
                // Not implemented as not required for this test.
        }
    }

    private void doMoveBasedOnColour(int newX, int newY) {
        if (newX != xCoordinate) // Pawn can only move forward in the Y direction for non capture move.
            return;

        switch (pieceColor) {
            case BLACK:
                if (newY == yCoordinate - 1)
                    yCoordinate = newY;
                break;
            case WHITE:
                if (newY == yCoordinate + 1)
                    yCoordinate = newY;
        }
    }

    @Override
    public String toString() {
        return CurrentPositionAsString();
    }

    protected String CurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
}
