package se.kentor.lab.storagecell.core.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import se.kentor.lab.storagecell.core.model.entity.BoxEntity;

/**
 * @author muqkha
 *
 */
public interface BoxRepo extends JpaRepository<BoxEntity, Long> {
	
	BoxEntity findByIdAndCellId(Long boxId, Long cellId);
}
