package test.restful.album.workflow;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import test.restful.album.library.entity.Album;
import test.restful.album.library.entity.AlbumList;
import test.restful.album.library.entity.AlbumType;
import test.restful.album.library.entity.Person;


@Path("/albums")
public class AlbumService {
	
	//handling sequence here avoid parameter objects incrementing it (like "newAlbum" in addAlbum function)
	private static int ALBUM_SEQUENCE = 0;
	private static Map<Integer,Album> albums = new HashMap<Integer,Album>();
	
	
	
	
	//creation static d'objets initiaux
	static {
		Album album1 = new Album();
		album1.setId(++ALBUM_SEQUENCE);
		album1.setName("Short single");
		album1.setReleaseDate(new Date());
		album1.setType(AlbumType.SINGLE);
		album1.setCdNumber(1);
		albums.put(album1.getId(), album1);
		
		
		Album album2 = new Album();
		album2.setId(++ALBUM_SEQUENCE);
		album2.setName("Hotel");
		album2.setReleaseDate(new Date());
		album2.setType(AlbumType.ALBUM);
		album2.setCdNumber(2);
		albums.put(album2.getId(), album2);
	}
	

	/**
	 * Returns the Album instance associated with the id value
	 * @param id Album key
	 * @return The album corresponding to the key
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public static Album getAlbum(@PathParam("id")int id){
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
	public static AlbumList getAlbums(){
		AlbumList list = new AlbumList();
		
		//filling a list with the content of the global hashmap
		Set<Integer> keyset = albums.keySet();
		for (int key : keyset) {
			list.addAlbum(albums.get(key));
		}
		
		return list;
	}
	
	
	/**
	 * Ajouter un nouvel album
	 * @param newAlbum Le nouvel album à intégrer
	 * @return un format JSON de l'album créé
	 */
	@POST
	@Path("/add/{author_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public static Album addAlbum(Album newAlbum, @PathParam("author_id") int author_id){ 
		//TODO add an author //TODO exception handling
		
		Album album = new Album();

		album.setId(++ALBUM_SEQUENCE);
		album.setName(newAlbum.getName());
		album.setReleaseDate(newAlbum.getReleaseDate());
		album.setCdNumber(newAlbum.getCdNumber());
		album.setType(newAlbum.getType());

		// handle authors
		Person author = AuthorService.getAuthor(author_id); //TODO get from service author
		album.setAuthor(author);
		//TODO add album to Author (beware json construction loop ?)
		
		albums.put(album.getId(), album);
		return album;
	}
	
	
	
	
}
