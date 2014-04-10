package test.restful.album.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import test.restful.album.library.entity.Album;
import test.restful.album.library.entity.AlbumList;
import test.restful.album.library.entity.AlbumType;
import test.restful.album.library.entity.AuthorList;
import test.restful.album.library.entity.Person;


@Controller
@RequestMapping("/album/*")
public class AlbumController {

	
	private static final String albumPath = "http://127.0.0.1:8080/album-server/webresources/albums/";
	private static final String authorPath = "http://127.0.0.1:8080/album-server/webresources/authors/";
	
	/**
	 * Consulter les informations d'un album en particulier
	 * Consomme un doc JSON provenant d'un web service REST
	 * @param id L'id du livre à consulter
	 */
	@RequestMapping(value = "details", method = RequestMethod.GET)
	public String getAlbum(@RequestParam(required=true) int id, Model model){
		// consommer RESTful Service JSON /album-server/webresources/albums/{id}
		RestTemplate rest = new RestTemplate();
		Album album = rest.getForObject(albumPath + "{id}", Album.class, id);
		
		
		model.addAttribute("album", album);
		
		//TODO cas d'erreur : rediriger vers les albums (MappingException ?)
		
		return "album";
	}
	
	
	
	/**
	 * Consulter la liste de tous les albums enregistrés
	 * @return
	 */
	@RequestMapping("list")
	public String getAlbums(Model model){
		//consommer RESTful Service JSON /album-server/webresources/albums
		RestTemplate rest = new RestTemplate();
		List<Album> albums = new ArrayList<Album>();
		
		
		//alternative pour liste native ? : Arrays.asList((rest.getForObject(restPath + "/albums", Album[].class)))
		albums = rest.getForObject(albumPath + "all", AlbumList.class).getListe();
		model.addAttribute("albums", albums);
	
		
		return "albums";
	}
	
	
	
	@RequestMapping("new")
	public String addAlbum(Model model){
		// get authors list for new album form
		RestTemplate rest = new RestTemplate();
		List<Person> authors = new ArrayList<Person>();
		
		authors = rest.getForObject(authorPath + "all", AuthorList.class).getAuthors();
		
		model.addAttribute("authors", authors);
		
		return "form/album";
	}
	
	
	@RequestMapping("insert")
	public String insert(Model model,
			@RequestParam("name") String name, @RequestParam("cdNumber") int cdNumber,
			@RequestParam("type") AlbumType type, @RequestParam("author_id") int author_id ) {
		
		// init rest
		RestTemplate rest = new RestTemplate();
		// set object to send
		Album album = new Album();
		album.setName(name);
		album.setReleaseDate(new Date());
		album.setCdNumber(cdNumber);
		album.setType(type);
		// send object through POST request, and get the returned object
		album = rest.postForObject(albumPath+"add/{author_id}", album, Album.class, author_id);
		// add object to Spring model
		model.addAttribute("album", album);
		return "album";
	}
	
	
}
