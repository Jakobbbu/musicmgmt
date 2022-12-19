package music.jb.musicmgmt.repository;

import music.jb.musicmgmt.model.Release;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReleaseRepository extends JpaRepository<Release, Long> {

    List<Release> findReleasesByArtist_Id(Long id);

    void removeReleaseById(Long id);

}
