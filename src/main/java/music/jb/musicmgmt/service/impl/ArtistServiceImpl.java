package music.jb.musicmgmt.service.impl;

import jakarta.transaction.Transactional;
import music.jb.musicmgmt.model.Artist;
import music.jb.musicmgmt.repository.ArtistRepository;
import music.jb.musicmgmt.service.ArtistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final Logger LOG = LoggerFactory.getLogger(ArtistService.class);

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
        Optional<Long> optionalId = Optional.ofNullable(artist.getId());
        if(optionalId.isPresent()) {
            Artist og = artistRepository.getReferenceById(optionalId.get());
            og.setName(artist.getName());
            og.setDescription(artist.getDescription());
            artistRepository.save(og);
        } else {
            artistRepository.save(artist);
        }
    }

    @Override
    public Artist getArtistById(Long id) {
        try{
            return artistRepository.getReferenceById(id);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        throw new RuntimeException();
    }

    @Override
    public List<Artist> searchForArtist(String key) {
        return artistRepository.findArtistByNameContainsIgnoreCase(key);
    }

    @Override
    @Transactional
    public void removeArtist(Artist artist) {
        artistRepository.deleteArtistById(artist.getId());
    }
}
