package com.felix.hedgehograce;

import com.felix.hedgehogracerules.Player;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationPath("hedgehograce")
@Path("players")
public class HedgehogRace extends Application {
    @PersistenceContext
    private EntityManager entityManager;

    private Integer countPlayers() {
        Query query = entityManager.createQuery("SELECT COUNT(p.id) FROM Players p");
        return ((Long) query.getSingleResult()).intValue();
    }


    @SuppressWarnings("unchecked")
    private List<Player> findPersons(int startPosition, int maxResults, String sortFields, String sortDirections) {
        Query query = entityManager.createQuery("SELECT p FROM Players p ORDER BY " + sortFields + " " + sortDirections);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    public PaginatedListWrapper<Player> findPersons(PaginatedListWrapper<Player> wrapper) {
        wrapper.setTotalResults(countPlayers());
        int start = (wrapper.getCurrentPage() - 1) * wrapper.getPageSize();
        wrapper.setList(findPersons(start,
                wrapper.getPageSize(),
                wrapper.getSortFields(),
                wrapper.getSortDirections()));
        return wrapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedListWrapper<Player> listPersons(@DefaultValue("1")
                                                    @QueryParam("page")
                                                            Integer page,
                                                    @DefaultValue("id")
                                                    @QueryParam("sortFields")
                                                            String sortFields,
                                                    @DefaultValue("asc")
                                                    @QueryParam("sortDirections")
                                                            String sortDirections) {
        PaginatedListWrapper<Player> paginatedListWrapper = new PaginatedListWrapper<>();
        paginatedListWrapper.setCurrentPage(page);
        paginatedListWrapper.setSortFields(sortFields);
        paginatedListWrapper.setSortDirections(sortDirections);
        paginatedListWrapper.setPageSize(5);
        return findPersons(paginatedListWrapper);
    }
}
