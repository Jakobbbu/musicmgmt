package music.jb.musicmgmt.model;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseModel extends AuditModel{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
