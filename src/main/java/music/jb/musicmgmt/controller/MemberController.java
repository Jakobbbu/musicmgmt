package music.jb.musicmgmt.controller;

import jakarta.validation.Valid;
import music.jb.musicmgmt.model.Member;
import music.jb.musicmgmt.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("member")
public class MemberController {

    private final Logger LOG = LoggerFactory.getLogger(MemberController.class);
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/get-edit-member-form")
    public String getEditMemberForm(@RequestParam(name = "id") Long memberId, Model model) {
        LOG.info("Getting member form for member with id " + memberId);
        if(!model.containsAttribute("member")) {
            model.addAttribute("member", memberService.getMemberById(memberId));
        }
        model.addAttribute("memberAction", "update-member");
        return "forms/member-form";
    }

    @PostMapping("/update-member")
    public String updateMember(@Valid Member member, BindingResult result, RedirectAttributes redirectAttributes) {
        LOG.info("UPDATING member with id" + member.getId());
        if(result.hasErrors()) {
            LOG.error("ERRORS in edited member fields");
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.member", result);
            redirectAttributes.addFlashAttribute("member", member);
            return "redirect:/member/get-edit-member-form?id=" + member.getId();
        }
        LOG.info("Saving changes on member with id " + member.getId());
        Member savedMember = memberService.saveMember(member);
        return "redirect:/artist/get-members?id=" + savedMember.getArtist().getId();
    }

    @GetMapping("/get-add-member-form")
    public String getAddMemberForm(Model model, @RequestParam(name = "aid") Long artistId) {
        LOG.info("Getting member form for new member");
        if(!model.containsAttribute("member")) {
            model.addAttribute("member", new Member());
        }
        if(!model.containsAttribute("artistId")) {
            model.addAttribute("artistId", artistId);
        }
        model.addAttribute("memberAction", "add-new-member");
        return "forms/member-form";
    }

    @PostMapping ("/add-new-member")
    public String addMember(@RequestParam Long aid, @Valid Member member, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            LOG.error("ERRORS in new member fields");
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.member", result);
            redirectAttributes.addFlashAttribute("member", member);
            return "redirect:/member/get-add-member-form?aid=" + aid;
        }
        memberService.saveMemberForArtist(member, aid);
        LOG.info("Added new member with name " + member.getName());
        return "redirect:/artist/get-members?id=" + aid;
    }

    @PostMapping("/delete-member")
    public String deleteArtist(Member member){
        LOG.info("Deleting member with id:"  + member.getId());
        Long artistId = memberService.getMemberById(member.getId()).getArtist().getId();
        memberService.removeMember(member);
        return "redirect:/artist/get-members?id=" + artistId;
    }

}
