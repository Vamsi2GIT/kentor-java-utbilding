package se.kentor.lab.storagecell.app.rs;

import java.util.List;

import javax.ws.rs.WebApplicationException;

import org.springframework.beans.factory.annotation.Autowired;

import se.kentor.lab.storagecell.app.model.Box;
import se.kentor.lab.storagecell.app.model.Cell;
import se.kentor.lab.storagecell.core.service.IStorageCellService;

/**
 * @author muqkha
 *
 */
public class StorageCellWebImpl implements IStorageCellWeb {
	
	@Autowired
	private IStorageCellService iStorageCellServ;
	
	@Override
	public List<Cell> getAllCells() {
		return iStorageCellServ.getAllCells();
	}

	public void init() {
		iStorageCellServ.prepareCellStorage();
	}

	@Override
	public Cell getByCellId(Long id) {
		try {
			return iStorageCellServ.getCell(id);
		} catch (NullPointerException npE) {
			throw new WebApplicationException(400);
		}		
	}
	
	@Override
	public Box getByBoxId(Long cellId, Long boxId) {
		try {
			return iStorageCellServ.getBox(cellId, boxId);
		} catch (NullPointerException npE) {
			throw new WebApplicationException(400);
		}		
	}

	@Override
	public Cell getByCellIdWithBoxes(Long id) {
		try {
			return getByCellId(id);
		} catch (NullPointerException npE) {
			throw new WebApplicationException(400);
		}		
	}
	
}
