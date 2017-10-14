package com.felix.hedgehogracerules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    void getDefaultBoard() {
        Board board = Board.getDefaultBoard();

        assertNotNull(board);
    }

    @Test
    void testBoardHasAUUID() {
        Board board1 = Board.getDefaultBoard();
        Board board2 = Board.getDefaultBoard();

        assertNotEquals(board1.getUuid(), board2.getUuid());
    }
}