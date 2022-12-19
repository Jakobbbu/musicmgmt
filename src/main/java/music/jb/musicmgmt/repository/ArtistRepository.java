package music.jb.musicmgmt.repository;

import music.jb.musicmgmt.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    List<Artist> findArtistByNameContainsIgnoreCase(String key);

    void deleteArtistById(Long id);

}
