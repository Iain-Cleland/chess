package com.solarwindsmsp.chess;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PawnTest {
    private ChessBoard chessBoard;
    private Pawn testSubject;

    @Before
    public void setUp() {
        chessBoard = new ChessBoard();
        testSubject = new Pawn(PieceColor.BLACK);
        testSubject.setChessBoard(chessBoard);
    }

    @Test
    public void testChessBoard_Add_Sets_XCoordinate() {
        chessBoard.Add(testSubject, 6, 3, PieceColor.BLACK);
        Assert.assertEquals(6, testSubject.getXCoordinate());
    }

    @Test
    public void testChessBoard_Add_Sets_YCoordinate() {
        this.chessBoard.Add(testSubject, 6, 3, PieceColor.BLACK);
        Assert.assertEquals(3, testSubject.getYCoordinate());
    }


    @Test
    public void testPawn_Move_IllegalCoordinates_Right_DoesNotMove() {
        chessBoard.Add(testSubject, 6, 3, PieceColor.BLACK);
        testSubject.move(MovementType.MOVE, 7, 3);
        Assert.assertEquals(6, testSubject.getXCoordinate());
        Assert.assertEquals(3, testSubject.getYCoordinate());
    }

    @Test
    public void testPawn_Move_IllegalCoordinates_Left_DoesNotMove() {
        chessBoard.Add(testSubject, 6, 3, PieceColor.BLACK);
        testSubject.move(MovementType.MOVE, 4, 3);
        Assert.assertEquals(6, testSubject.getXCoordinate());
        Assert.assertEquals(3, testSubject.getYCoordinate());
    }

    @Test
    public void testPawn_Move_LegalCoordinates_Forward_UpdatesCoordinates() {
        chessBoard.Add(testSubject, 6, 3, PieceColor.BLACK);
        testSubject.move(MovementType.MOVE, 6, 2);
        Assert.assertEquals(6, testSubject.getXCoordinate());
        Assert.assertEquals(2, testSubject.getYCoordinate());
    }

}
