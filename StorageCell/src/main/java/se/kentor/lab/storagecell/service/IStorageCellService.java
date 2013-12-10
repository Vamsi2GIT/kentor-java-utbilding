package se.kentor.lab.storagecell.service;

import java.util.List;

import se.kentor.lab.storagecell.app.model.Cell;

/**
 * @author muqkha
 *
 */
public interface IStorageCellService {
	
	Cell getCell(Long id);
	
	List<Cell> getAvailableCells();
	
	List<Cell> getOccupiedCells();
	
	List<Cell> getAllCells();
	
	String createCellWithBoxes(Cell cell);
	
	void prepareCellStorage();
	
	
}
