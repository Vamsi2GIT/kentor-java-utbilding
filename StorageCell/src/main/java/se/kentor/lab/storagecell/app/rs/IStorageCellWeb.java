package se.kentor.lab.storagecell.app.rs;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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

}