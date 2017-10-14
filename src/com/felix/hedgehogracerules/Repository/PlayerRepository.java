package com.felix.hedgehogracerules.Repository;

import com.felix.hedgehogracerules.Player;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.UUID;

public class PlayerRepository {
    public void addPlayer(Player player)
    {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );

        EntityManager entitymanager = emfactory.createEntityManager( );
        entitymanager.getTransaction().begin();

        entitymanager.persist(player);
        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();
    }

    public Player getPlayer(String id)
    {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
        EntityManager entitymanager = emfactory.createEntityManager();

        return entitymanager.find(Player.class, id);
    }
}
