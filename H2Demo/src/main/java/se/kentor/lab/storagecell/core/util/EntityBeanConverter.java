package se.kentor.lab.storagecell.core.util;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import se.kentor.lab.storagecell.app.model.Box;
import se.kentor.lab.storagecell.app.model.Cell;
import se.kentor.lab.storagecell.core.model.entity.BoxEntity;
import se.kentor.lab.storagecell.core.model.entity.CellEntity;

/**
 * @author muqkha
 *
 */
public class EntityBeanConverter {
	
	// dozer mapper singleton instance
    private static Mapper mapper = new DozerBeanMapper();
    
	/**
	 * Maps XML JAXB object to an entity bean.
	 * 
	 * @param event the JAXB object.
	 * @return the entity bean.
	 */
	public static CellEntity toEntity(final Cell cell) {
		final CellEntity entity = copyProperties(cell, CellEntity.class);
		for (final Box item : cell.getBoxes()) {
			entity.addBoxEntity(copyProperties(item, BoxEntity.class));
		}

		return entity;
	}
	
	public static <T> T copyProperties(Object source, Class<T> targetSpec) {
        return mapper.map(source, targetSpec);
    }
	
	public static Cell fromEntity(final CellEntity cellEntity) {
		final Cell cell = copyProperties(cellEntity, Cell.class);

		copyGenericLists(cell.getBoxes(), cellEntity.getBoxEntities(), Box.class);

		return cell;
	}
	
	 /**
     * Copies lists items.
     * 
     * @param target the target list to add copies to.
     * @param source the source list.
     * @param targetSpec the target type
     * @return the target list.
     */
    public static <T, F> List<T> copyGenericLists(List<T> target, List<F> source, Class<T> targetSpec) {
        for (final F item : source) {
            target.add(copyProperties(item, targetSpec));
        }
        return target;
    }
    
    /**
	 * Maps list of BusinessEventEntity to RegisteredEvent list
	 * @param cellEntities
	 * @return List<RegisteredEvent>
	 */
	public static List<Cell> fromCellEntity(
			final List<CellEntity> cellEntities) {
		List<Cell> registeredEventList = new ArrayList<Cell>(cellEntities.size());
		for (final CellEntity bEEntity : cellEntities) {
			registeredEventList.add(fromEntity(bEEntity));

		}
		return registeredEventList;
	}
	
	
}
