package se.kentor.lab.storagecell.model.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author muqkha
 * 
 */
@Entity(name = CellEntity.TABLE_NAME)
@javax.persistence.Table(name = CellEntity.TABLE_NAME)
public class CellEntity implements Comparable<CellEntity> {

	static final String TABLE_NAME = "cell";
	static final String INDEX_NAME = "cell_index";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "location", nullable = false, updatable = false, length = 64)
	private String location;

	@Column(name = "width", nullable = false, updatable = false, length = 64)
	private int width;
	
	@Column(name = "occupied", nullable = false, updatable = false, length = 64)
	private boolean occupied;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="cell", orphanRemoval=true, cascade=CascadeType.ALL)    
    private List<BoxEntity> boxEntities = new LinkedList<BoxEntity>();
	
	public List<BoxEntity> getBoxEntities() {
		return boxEntities;
	}
	
	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public void setBoxEntities(List<BoxEntity> boxEntities) {
		this.boxEntities = boxEntities;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean addBoxEntity(BoxEntity itemEntity) {
        if (itemEntity.getCell() == null) {
            itemEntity.setCell(this);
            return boxEntities.add(itemEntity);
        }
        return false;
    }
	
	@Override
	public boolean equals(Object r) {
		if (this == r) {
			return true;
		}
		final Long id = getId();
		if (id != null && r instanceof CellEntity) {
			return id.equals(((CellEntity) r).getId());
		}
		return false;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final Long id = getId();
		return (id == null) ? super.hashCode() : id.hashCode();
	}
/*
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}*/

	@Override
	public int compareTo(CellEntity other) {
		return this.getId().compareTo(other.getId());
	}

	public String getReferenceId() {
		return String.format("%s.%04d", "cell_", getId()); 
	}

}
