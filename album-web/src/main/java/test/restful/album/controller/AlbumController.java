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


@Controller
@RequestMapping("/album/*")
public class AlbumController {

	
	private static final String restPath = "http://127.0.0.1:8080/album-server/webresources/albums/";
	
	/**
	 * Consulter les informations d'un album en particulier
	 * Consomme un doc JSON provenant d'un web service REST
	 * @param id L'id du livre à consulter
	 */
	@RequestMapping(value = "details", method = RequestMethod.GET)
	public String getAlbum(@RequestParam(required=true) int id, Model model){
		// consommer RESTful Service JSON /album-server/webresources/albums/{id}
		RestTemplate rest = new RestTemplate();
		Album album = rest.getForObject(restPath + "{id}", Album.class, id);
		
		
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
		albums = rest.getForObject(restPath + "all", AlbumList.class).getListe();
		model.addAttribute("albums", albums);
	
		
		return "albums";
	}
	
	
	
	@RequestMapping("new")
	public String addAlbum(Model model){
		return "form/album";
	}
	
	
	@RequestMapping("insert")
	public String insert(Model model,
			@RequestParam("name") String name,
			@RequestParam("cdNumber") int cdNumber,
			@RequestParam("type") AlbumType type){
		// init rest
		RestTemplate rest = new RestTemplate();
		// set object to send
		Album album = new Album();
		album.setName(name);
		album.setReleaseDate(new Date());
		album.setCdNumber(cdNumber);
		album.setType(type);
		// send object throught POST request, and get the returned object
		album = rest.postForObject(restPath+"add", album, Album.class);
		// add object to Spring model
		model.addAttribute("album", album);
		return "album";
	}
	
	
}
