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
    @Path("/cells")
    List<Cell> getAllCells();
    
    @GET
    @Produces("application/json")
    @Path("/availableCells")
    List<Cell> getAvailableCells();
    
    @GET
    @Produces("application/json")
    @Path("/occupiedCells")
    List<Cell> getAllOccupiedCells();
    
    @GET
    @Produces("application/json")
    @Path("/{type}/{id}")
    Cell getByCellId(@PathParam("id") Long id);
    
    @GET
    @Produces("application/json")
    @Path("/{type}/{id}/boxes")
    Cell getByCellIdWithBoxes(@PathParam("id") Long id);
    
    @GET
    @Produces("application/json")
    @Path("/{type}/{cellId}/box/{boxId}")
    Box getByBoxId(@PathParam("cellId") Long cellId, @PathParam("boxId") Long boxId);
}