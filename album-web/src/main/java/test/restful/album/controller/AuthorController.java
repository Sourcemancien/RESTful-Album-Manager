package test.restful.album.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import test.restful.album.library.entity.AuthorList;
import test.restful.album.library.entity.Person;


@Controller
@RequestMapping("/author/*")
public class AuthorController {
	
	private static final String authorPath = "http://127.0.0.1:8080/album-server/webresources/authors/";
	private static final String albumPath = "http://127.0.0.1:8080/album-server/webresources/albums/";
	
	
	@RequestMapping("details")
	public String getAuthor(Model model, @RequestParam("id") int id){
		RestTemplate rest = new RestTemplate();
		
		Person author = rest.getForObject(authorPath + "{id}", Person.class, id);
		
		model.addAttribute("author", author);		
		return "author";
	}
	
	
	@RequestMapping("list")
	public String getAuthors(Model model){
		RestTemplate rest = new RestTemplate();
		
		List<Person> authors = rest.getForObject(authorPath + "all", AuthorList.class).getAuthors();
		
		model.addAttribute("authors", authors);
		return "authors";
	}
	
	
	@RequestMapping("new")
	public String addAuthor(Model model){
		return "form/author";
	}
	
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertAuthor(Model model, 
			@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
			@RequestParam("pseudo") String pseudo){
		//set object
		Person author = new Person();
		author.setFirstname(firstname);
		author.setLastname(lastname);
		author.setPseudo(pseudo);
		
		//send object through json data transport
		RestTemplate rest = new RestTemplate();
		author = rest.postForObject(authorPath + "add", author, Person.class);
		
		//put the received object into the model
		model.addAttribute("author", author);
		return "author";
	}
}
