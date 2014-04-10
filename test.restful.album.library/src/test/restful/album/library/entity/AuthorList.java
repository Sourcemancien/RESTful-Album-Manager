package test.restful.album.library.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Objet conteneur pour sérialiser/désérialiser les collections d'objets Person
 *
 */
@XmlRootElement(name="author_list")
public class AuthorList {

	private List<Person> authors;
	
	
	
	public AuthorList(){
		this.setAuthors(new ArrayList<Person>());
	}


	@XmlElement
	public List<Person> getAuthors() {
		return authors;
	}



	public void setAuthors(List<Person> authors) {
		this.authors = authors;
	}
	
	
	
	public void addAuthor(Person author){
		this.authors.add(author);
	}
	
	
}
