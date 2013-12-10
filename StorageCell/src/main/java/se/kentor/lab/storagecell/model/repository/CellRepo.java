package se.kentor.lab.storagecell.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import se.kentor.lab.storagecell.model.entity.CellEntity;

/**
 * @author muqkha
 *
 */
public interface CellRepo extends JpaRepository<CellEntity, Long> {
	
	List<CellEntity> findByOccupiedIsFalse();
	
	List<CellEntity> findByOccupiedIsTrue();
	
}
