package se.kentor.lab.storagecell.app.model;

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
public class Box {
	
	@XmlElement
	private Long id;
	@XmlElement
	private String name;

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
	
	
}
