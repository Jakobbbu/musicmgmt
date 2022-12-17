package music.jb.musicmgmt.service;

import music.jb.musicmgmt.model.Artist;

import java.util.List;

public interface ArtistService {

    List<Artist> getAllArtist();

    List<Artist> searchForArtist(String key);

    Artist getArtistById(String id);

    void saveArtist(Artist artist);

}
