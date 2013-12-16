package se.kentor.lab.storagecell.core.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import se.kentor.lab.storagecell.app.model.Box;
import se.kentor.lab.storagecell.app.model.Cell;
import se.kentor.lab.storagecell.core.model.entity.CellEntity;
import se.kentor.lab.storagecell.core.model.repository.CellRepo;
import se.kentor.lab.storagecell.core.service.IStorageCellService;
import se.kentor.lab.storagecell.core.util.EntityBeanConverter;

/**
 * @author muqkha
 *
 */
@Service
@Transactional
public class StorageCellServiceImpl implements IStorageCellService {
	
	@Autowired
	private CellRepo cellRepo;
	
	@Value("${cell.maxNbr:50}")
	private int maxNbrOfCells;
	
	private static final String ALPHA_NUMERIC_STRING = "ÄÖÅABCDEFGHIJKLMNOPQRSTUVWXYZÅÖÄ0123456789";
	static Random random = new Random(System.currentTimeMillis());
	
	public static String genRandomAlphaNData(int count) {
		final StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
	private static int getRandomInt(int min, int max) {
	    return random.nextInt((max - min) + 1) + min;
	}
	 
	@Override
	public Cell getCell(Long id) {
		
		return null;
	}

	@Override
	public String createCellWithBoxes(Cell cell) {
		CellEntity cellEntity = EntityBeanConverter.toEntity(cell); 
		cellRepo.save(cellEntity);
		
		return cellEntity.getReferenceId();		
	}
	
	@Override
	public void prepareCellStorage() {
		System.out.println("Preparing data for the application!!!! " + maxNbrOfCells);
		
		for (int i = 0; i <  maxNbrOfCells; i++) {
			Cell cell = new Cell();
			cell.setLocation(genRandomAlphaNData(10));
			cell.setWidth(getRandomInt(10, 100));
			cell.setOccupied(random.nextBoolean());
			
			double count = Math.ceil(cell.getWidth() / 4);
			
			for (int j=0; j < count; j++) {
				Box box = new Box();
				box.setName(genRandomAlphaNData(5));
				cell.getBoxes().add(box);
			}
			
			createCellWithBoxes(cell);
		}
	}

	@Override
	public List<Cell> getAvailableCells() {
		return EntityBeanConverter.fromCellEntity(cellRepo.findByOccupiedIsFalse());
	}

	@Override
	public List<Cell> getOccupiedCells() {
		return EntityBeanConverter.fromCellEntity(cellRepo.findByOccupiedIsTrue());
	}

	@Override
	public List<Cell> getAllCells() {
		return EntityBeanConverter.fromCellEntity(cellRepo.findAll());
	}
	
		

}
