package com.felix.hedgehogracerules;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Game {
    UUID board;
    List<UUID> players;

    public Game(UUID game, List<UUID> players) throws InvalidGameException
    {
        this.board = game;
        this.players = players;

        if (players.size() < 3) {
            throw new InvalidGameException();
        }
    }

    public UUID getBoard() {
        return board;
    }

    public static Game createGame(Board board, Player[] players) throws InvalidGameException
    {
        List<UUID> playersUUID = new ArrayList<UUID>();
        for (int i = 0; i < players.length; i++) {
            playersUUID.add(players[i].getUuid());
        }

        return new Game(board.getUuid(), playersUUID);
    }
}
