package music.jb.musicmgmt.model;

import jakarta.persistence.*;

@Entity
public class Member extends BaseModel{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    private String name;

    private String description;

    private boolean active;

}
