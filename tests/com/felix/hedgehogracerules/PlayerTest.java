package com.felix.hedgehogracerules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void testPlayerHaveDifferentUUID()
    {
        Player player1 = new Player("one");
        Player player2 = new Player("one");

        assertNotEquals(player1.getUuid(), player2.getUuid());
    }

    @Test
    void testPlayerCanBeNamed()
    {
        Player player = new Player("one");

        assertEquals("one", player.getName());
    }
}