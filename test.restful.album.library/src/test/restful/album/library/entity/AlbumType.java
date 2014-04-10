package test.restful.album.library.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="album_type")
public enum AlbumType {
	SINGLE,
	ALBUM,
	BESTOF,
	COLLECTION;
}
