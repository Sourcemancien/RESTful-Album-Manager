package test.restful.album.workflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import test.restful.album.library.entity.Album;
import test.restful.album.library.entity.AlbumType;


@Path("/albums")
public class AlbumService {
	private static Map<Integer,Album> albums = new HashMap<Integer,Album>();
	
	//creation static d'objets initiaux
	static {
		Album album1 = new Album();
		album1.setName("Short single");
		album1.setReleaseDate(new Date());
		album1.setType(AlbumType.SINGLE);
		album1.setCdNumber(1);
		albums.put(album1.getId(), album1);
		
		Album album2 = new Album();
		album2.setName("Hotel");
		album2.setReleaseDate(new Date());
		album2.setType(AlbumType.ALBUM);
		album2.setCdNumber(2);
		albums.put(album2.getId(), album2);
	}
	

	/**
	 * Récupérer un album à partir de sa référence
	 * @param id Référence de l'album
	 * @return Un album sous forme de conteneur JSON
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Album getAlbum(@PathParam("id")int id){
		//TODO add exception handling
		return albums.get(id);
	}
	
	
	/**
	 * Récupérer la liste de tout les albums enregistrés
	 * @return Une liste d'album sous forme de conteneur JSON
	 */
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Album> getAlbums(){
		List<Album> list = new ArrayList<Album>();
		
		Set<Integer> keyset = albums.keySet();
		for (int key : keyset) {
			list.add(albums.get(key));
		}
		
		return list;
	}
	
	
	/**
	 * Ajouter un nouvel album
	 * @param newAlbum Le nouvel album à intégrer
	 * @return un format JSON de l'album créé
	 */
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Album addAlbum(Album newAlbum){ //TODO add an author //TODO exception handling
		
		Album album = new Album();
		
		album.setName(newAlbum.getName());
		album.setReleaseDate(newAlbum.getReleaseDate());
		album.setCdNumber(newAlbum.getCdNumber());
		album.setType(newAlbum.getType());
		//TODO handle authors
		
		albums.put(album.getId(), album);
		return album;
	}
	
	
	
	
}
