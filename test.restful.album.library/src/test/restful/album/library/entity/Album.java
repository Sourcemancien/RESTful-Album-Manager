package test.restful.album.library.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Modèle d'un album
 * - name
 * - releaseDate
 * - cdNumber
 * - type
 * - authors
 */
@XmlRootElement(name="album")
public class Album {
	
	/*
	 * ATTRIBUTS
	 */
	private static int ID_SEQUENCE = 0;
	
	private int id;
	
	private String name;
	private Date releaseDate;
	private int cdNumber;
	
	private AlbumType type;
	private List<Person> authors;
	
	/*
	 * CONSTRUCTEUR
	 */
	public Album(){
		this.id = ++Album.ID_SEQUENCE;
		this.authors = new ArrayList<Person>();
	}

	
	/*
	 * GETTEURS & SETTEURS
	 */
	
	@XmlElement
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@XmlElement
	public Date getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	
	@XmlElement
	public int getCdNumber() {
		return cdNumber;
	}


	public void setCdNumber(int cdNumber) {
		this.cdNumber = cdNumber;
	}


	@XmlElement
	public List<Person> getAuthors() {
		return authors;
	}


	public void setAuthors(List<Person> authors) {
		this.authors = authors;
	}


	@XmlElement
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	@XmlElement
	public AlbumType getType() {
		return type;
	}



	public void setType(AlbumType type) {
		this.type = type;
	}

	
	

}
