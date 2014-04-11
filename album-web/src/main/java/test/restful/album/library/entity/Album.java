package test.restful.album.library.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;


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
//	private static int ID_SEQUENCE = 0;
	
	private int id;
	private String name;
	private Date releaseDate;
	private int cdNumber;
	private AlbumType type;
	
	private int authorId;
	
	/*
	 * CONSTRUCTEUR
	 */
	public Album(){
//		this.id = ++Album.ID_SEQUENCE;
//		this.authors = new ArrayList<Person>();
	}

	
	/*
	 * GETTEURS & SETTEURS
	 */
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	
	public int getCdNumber() {
		return cdNumber;
	}


	public void setCdNumber(int cdNumber) {
		this.cdNumber = cdNumber;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public AlbumType getType() {
		return type;
	}



	public void setType(AlbumType type) {
		this.type = type;
	}


	public int getAuthorId() {
		return authorId;
	}


	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	
	

}
