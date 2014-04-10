package test.restful.album.workflow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import test.restful.album.library.entity.AuthorList;
import test.restful.album.library.entity.Person;


@Path("/authors")
public class AuthorService {
	
	private static Map<Integer, Person> authors = new HashMap<Integer,Person>();
	
	
	//creation statique d'objet initiaux (provisoire)
	static {
		Person person1 = new Person();
		person1.setFirstname("Richard Melville");
		person1.setLastname("Hall");
		person1.setPseudo("Moby");
		authors.put(person1.getId(), person1);
		
		Person person2 = new Person();
		person2.setFirstname("Alecia");
		person2.setLastname("Beth Moore");
		person2.setPseudo("P!nk");
		authors.put(person2.getId(), person2);
	}

	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public static Person getAuthor(@PathParam("id")int id){
		return AuthorService.authors.get(id);
	}
	
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public static AuthorList getAuthors(){
		AuthorList list = new AuthorList();
		Set<Integer> keyset = authors.keySet();
		
		for (Integer key : keyset) {
			list.addAuthor(authors.get(key));
		}
		
		return list;
	}
	
	
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static Person addAuthor(Person newAuthor){
		Person author = new Person();
		
		author.setFirstname(newAuthor.getFirstname());
		author.setLastname(newAuthor.getLastname());
		author.setPseudo(newAuthor.getPseudo());
		
		authors.put(author.getId(), author);
		
		return author;
	}
}
