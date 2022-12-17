package music.jb.musicmgmt.service.impl;

import music.jb.musicmgmt.controller.WebController;
import music.jb.musicmgmt.model.Artist;
import music.jb.musicmgmt.repository.ArtistRepository;
import music.jb.musicmgmt.service.ArtistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final Logger LOG = LoggerFactory.getLogger(WebController.class);

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> getAllArtist() {
       return artistRepository.findAll();
    }

    @Override
    public void saveArtist(Artist artist) {
        LOG.info("Saving artist with name" + artist.getName());
        artistRepository.save(artist);
    }

    @Override
    public Artist getArtistById(String id) {
        try{
            Long longId = Long.parseLong(id);
            return artistRepository.getReferenceById(longId);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        throw new RuntimeException();
    }

    @Override
    public List<Artist> searchForArtist(String key) {
        return artistRepository.findArtistByNameContainsIgnoreCase(key);
    }
}
