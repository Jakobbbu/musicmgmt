package music.jb.musicmgmt.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Release extends BaseModel{

    private String title;

    private String releaseYear;

    @OneToMany(mappedBy = "release", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Track> trackList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;
}
