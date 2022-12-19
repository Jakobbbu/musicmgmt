package music.jb.musicmgmt.repository;

import music.jb.musicmgmt.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findMembersByArtist_Id(Long id);

    void removeMemberById(Long id);

}
