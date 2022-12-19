package music.jb.musicmgmt.service;

import music.jb.musicmgmt.model.Member;

import java.util.List;

public interface MemberService {

    List<Member> getMembersForArtist(Long id);

    Member getMemberById(Long id);

    Member saveMember(Member member);

    void saveMemberForArtist(Member member, Long artistId);

    void removeMember(Member member);

}
