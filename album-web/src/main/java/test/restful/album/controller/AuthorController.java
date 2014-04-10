package test.restful.album.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import test.restful.album.library.entity.AuthorList;
import test.restful.album.library.entity.Person;


@Controller
@RequestMapping("/author/*")
public class AuthorController {
	
	private static final String restPath = "http://127.0.0.1:8080/album-server/webresources/authors/";

	
	@RequestMapping("details")
	public String getAuthor(Model model, @RequestParam("id") int id){
		RestTemplate rest = new RestTemplate();
		
		Person author = rest.getForObject(restPath + "{id}", Person.class, id);
		
		model.addAttribute("author", author);		
		return "author";
	}
	
	
	@RequestMapping("list")
	public String getAuthors(Model model){
		RestTemplate rest = new RestTemplate();
		
		List<Person> authors = rest.getForObject(restPath + "all", AuthorList.class).getAuthors();
		
		model.addAttribute("authors", authors);
		return "authors";
	}
}
