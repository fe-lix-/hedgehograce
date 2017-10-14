package com.felix.hedgehogracerules;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Player {
    @Id
    private UUID uuid;
    private String name;

    public Player(String name) {
        this.uuid = UUID.randomUUID();
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString()
    {
        return "Player(" + uuid.toString() + ") - " + name;
    }
}
