package music.jb.musicmgmt.service.impl;

import jakarta.transaction.Transactional;
import music.jb.musicmgmt.model.Member;
import music.jb.musicmgmt.repository.ArtistRepository;
import music.jb.musicmgmt.repository.MemberRepository;
import music.jb.musicmgmt.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final Logger LOG = LoggerFactory.getLogger(MemberService.class);
    private final MemberRepository memberRepository;

    private final ArtistRepository artistRepository;

    public MemberServiceImpl(MemberRepository memberRepository, ArtistRepository artistRepository) {
        this.memberRepository = memberRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Member> getMembersForArtist(Long id) {
        return memberRepository.findMembersByArtist_Id(id);
    }

    @Override
    public Member getMemberById(Long id) {
        return memberRepository.getReferenceById(id);
    }

    @Override
    public Member saveMember(Member member) {
        LOG.info("Saving member with name " + member.getName());
        Optional<Long> optionalId = Optional.ofNullable(member.getId());
        if(optionalId.isPresent()) {
            Member og = memberRepository.getReferenceById(optionalId.get());
            og.setName(member.getName());
            og.setDescription(member.getDescription());
            og.setActive(member.isActive());
            memberRepository.save(og);
            return og;
        } else {
            memberRepository.save(member);
            return member;
        }
    }

    @Override
    public void saveMemberForArtist(Member member, Long artistId) {
        member.setArtist(artistRepository.getReferenceById(artistId));
        memberRepository.save(member);
    }

    @Override
    @Transactional
    public void removeMember(Member member) {
        memberRepository.removeMemberById(member.getId());
    }
}
