package com.felix.hedgehogracerules;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Board {
    private List<Case> cases;
    private UUID uuid;

    public Board(List<Case> cases) {
        this.uuid = UUID.randomUUID();
        this.cases = cases;
    }

    public UUID getUuid() {
        return uuid;
    }

    public static Board getDefaultBoard() {
        int[] defaultValues = {3, 2, 2, 1, 1, 1, 0, -1, -1, -1, -1};

        List<Case> cases = new ArrayList<Case>();
        for (int i = 0; i < defaultValues.length; i++) {
            cases.add(new Case(defaultValues[i]));
        }

        return new Board(cases);
    }
}
