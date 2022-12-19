package music.jb.musicmgmt.service;

import music.jb.musicmgmt.model.Release;

import java.util.List;

public interface ReleaseService {

    List<Release> getReleasesForArtist(Long id);

    Release getReleaseById(Long id);

    Release saveRelease(Release release);

    Release saveReleaseForArtist(Release release, Long artistId);

    void removeRelease(Release release);

}
