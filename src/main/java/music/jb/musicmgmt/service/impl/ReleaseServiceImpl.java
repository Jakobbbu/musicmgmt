package music.jb.musicmgmt.service.impl;

import jakarta.transaction.Transactional;
import music.jb.musicmgmt.model.Release;
import music.jb.musicmgmt.repository.ArtistRepository;
import music.jb.musicmgmt.repository.ReleaseRepository;
import music.jb.musicmgmt.service.ReleaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReleaseServiceImpl implements ReleaseService {

    private final ReleaseRepository releaseRepository;

    private final ArtistRepository artistRepository;

    public ReleaseServiceImpl(ReleaseRepository releaseRepository, ArtistRepository artistRepository) {
        this.releaseRepository = releaseRepository;
        this.artistRepository = artistRepository;
    }

    public List<Release> getReleasesForArtist(Long id) {
        return releaseRepository.findReleasesByArtist_Id(id);
    }

    @Override
    public Release getReleaseById(Long id) {
        return releaseRepository.getReferenceById(id);
    }

    @Override
    public Release saveRelease(Release release) {
        Optional<Long> optionalId = Optional.ofNullable(release.getId());
        if(optionalId.isPresent()) {
            Release og = releaseRepository.getReferenceById(optionalId.get());
            og.setTitle(release.getTitle());
            og.setReleaseYear(release.getReleaseYear());
            releaseRepository.save(og);
            return og;
        } else {
            releaseRepository.save(release);
            return release;
        }
    }

    @Override
    public Release saveReleaseForArtist(Release release, Long artistId) {
        release.setArtist(artistRepository.getReferenceById(artistId));
        return releaseRepository.save(release);
    }

    @Override
    @Transactional
    public void removeRelease(Release release) {
        releaseRepository.removeReleaseById(release.getId());
    }
}
