package com.felix.hedgehogracerules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Player[] getDefaultPlayerSet()
    {
        Player[] players = {new Player("one"), new Player("two"), new Player("three")};

        return players;
    }

//    @Test
//    void testGameHasABoardUUID()
//    {
////        Game game = Game.createGame(
////                Board.getDefaultBoard(),
////                getDefaultPlayerSet()
////        );
//
//        assertNotNull(game.getBoard());
//    }

    @Test
    void testGameCannotHaveThreePlayers()
    {
        Player[] players = {new Player("one")};

        Throwable exception = assertThrows(InvalidGameException.class, ()->{
            Game.createGame(Board.getDefaultBoard(), players);
        });
    }
}