package se.kentor.lab.storagecell.app.rs;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import se.kentor.lab.storagecell.app.model.Box;
import se.kentor.lab.storagecell.app.model.Cell;

/**
 * @author muqkha
 *
 */
@Path("/")
public interface IStorageCellWeb {

	@GET
    @Produces("application/json")
    @Path("/allCells")
    List<Cell> getAllCells();
    
    @GET
    @Produces("application/json")
    @Path("/allAvailableCells")
    List<Cell> getAvailableCells();
    
    @GET
    @Produces("application/json")
    @Path("/allOccupiedCells")
    List<Cell> getAllOccupiedCells();
    
    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    @Path("/cell/{id}")
    Cell getByCellId(@PathParam("id") Long id);
    
    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    @Path("/cell/{cellId}/boxes/{boxId}")
    Box getByBoxId(@PathParam("cellId") Long cellId, @PathParam("boxId") Long boxId);
}