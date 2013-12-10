package se.kentor.lab.storagecell.app.rs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import se.kentor.lab.storagecell.app.model.Cell;
import se.kentor.lab.storagecell.service.IStorageCellService;

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

	@Override
	public List<Cell> getAvailableCells() {
		return iStorageCellServ.getAvailableCells();
	}

	@Override
	public List<Cell> getAllOccupiedCells() {
		return iStorageCellServ.getOccupiedCells();
	}
	
	public void init() {
		iStorageCellServ.prepareCellStorage();
	}
	

}
