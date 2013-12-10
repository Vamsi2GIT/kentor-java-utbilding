package se.kentor.lab.storagecell.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author muqkha
 *
 */
@Entity(name = BoxEntity.TABLE_NAME)
@javax.persistence.Table(name = BoxEntity.TABLE_NAME)
public class BoxEntity implements Comparable<BoxEntity>{
	
	static final String TABLE_NAME = "box";
	static final String INDEX_NAME = "box_index";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", nullable = false, updatable = false, length = 64)
	private String name;
	
	@ManyToOne(optional=false)
    @JoinColumn(name="cell_id", updatable=false)
    private CellEntity cell;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CellEntity getCell() {
		return cell;
	}

	public void setCell(CellEntity cell) {
		this.cell = cell;
	}

	@Override
	public boolean equals(Object r) {
		if (this == r) {
			return true;
		}
		final Long id = getId();
		if (id != null && r instanceof BoxEntity) {
			return id.equals(((BoxEntity) r).getId());
		}
		return false;
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
	public int compareTo(BoxEntity other) {
		return this.getId().compareTo(other.getId());
	}

	
}
