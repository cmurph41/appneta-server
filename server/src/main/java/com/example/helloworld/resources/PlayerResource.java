package com.example.helloworld.resources;
import com.example.helloworld.core.Player;
import com.example.helloworld.db.PlayerDAO;

import io.dropwizard.hibernate.UnitOfWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

@Path("/players")
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerResource.class);

    private final PlayerDAO template;

    public PlayerResource(PlayerDAO template) {
        this.template = template;
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    public Optional<Player> findById(@PathParam("id") Long id) {
        return template.findById(id);
    }

    @GET
    @UnitOfWork
    public List<Player> findAll() {
        return template.findAll();
    }
}
