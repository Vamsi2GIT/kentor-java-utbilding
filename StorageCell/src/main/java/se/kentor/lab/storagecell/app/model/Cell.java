/**
 * 
 */
package se.kentor.lab.storagecell.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author muqkha
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Cell {
	
	@XmlElement
	private String id;
	@XmlElement
	private int width;
	@XmlElement
	private String location;
	@XmlElement
	private boolean occupied;
	
	@XmlElement
	private List<Box> boxes = new ArrayList<Box>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.occupied = isOccupied;
	}

	public List<Box> getBoxes() {
		return boxes;
	}

	public void setBoxes(List<Box> boxes) {
		this.boxes = boxes;
	}
	
	
}
