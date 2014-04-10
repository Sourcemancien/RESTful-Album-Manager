package test.restful.album.library.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Objet conteneur pour la sérialisation et la désérialisation JSON
 *
 */
@XmlRootElement(name="album_list")
public class AlbumList {
	
	private List<Album> liste;
	
	
	public AlbumList(){
		setListe(new ArrayList<Album>());
	}

	
	@XmlElement
	public List<Album> getListe() {
		return liste;
	}


	public void setListe(List<Album> liste) {
		this.liste = liste;
	}
	
	
	
	public void addAlbum(Album album){
		this.liste.add(album);
	}
	

}
