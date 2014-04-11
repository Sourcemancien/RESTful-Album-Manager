package test.restful.album.library.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="person")
public class Person {
	
	private int id;
	private String firstname, lastname, pseudo;
	private List<Album> albums;
	
	
	public Person(){
		this.albums = new ArrayList<Album>();
	}

	
	@XmlElement
	public int getId(){
		return this.id;
	}

	
	public void setId(int id){
		this.id = id;
	}
	
	
	@XmlElement
	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@XmlElement
	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	@XmlElement
	public String getPseudo(){
		return this.pseudo;
	}
	
	
	public void setPseudo(String pseudo){
		this.pseudo = pseudo;
	}
	

	@XmlElement
	public List<Album> getAlbums() {
		return albums;
	}


	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	
	
	
	
}
