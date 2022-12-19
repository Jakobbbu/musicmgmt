package music.jb.musicmgmt.controller;

import jakarta.validation.Valid;
import music.jb.musicmgmt.model.Release;
import music.jb.musicmgmt.service.ReleaseService;
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
@RequestMapping("release")
public class ReleaseController {
    private final Logger LOG = LoggerFactory.getLogger(ReleaseController.class);

    private final ReleaseService releaseService;

    public ReleaseController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @GetMapping("/get-edit-release-form")
    public String getEditReleaseForm(@RequestParam(name = "id") Long releaseId, Model model) {
        LOG.info("Getting release form for release with id " + releaseId);
        if(!model.containsAttribute("release")) {
            model.addAttribute("release", releaseService.getReleaseById(releaseId));
        }
        model.addAttribute("releaseAction", "update-release");
        return "forms/release-form";
    }

    @PostMapping("/update-release")
    public String updateRelease(@Valid Release release, BindingResult result, RedirectAttributes redirectAttributes) {
        LOG.info("UPDATING release with id" + release.getId());
        if(result.hasErrors()) {
            LOG.error("ERRORS in edited release fields");
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.release", result);
            redirectAttributes.addFlashAttribute("release", release);
            return "redirect:/release/get-edit-release-form?id=" + release.getId();
        }
        LOG.info("Saving changes on release with id " + release.getId());
        Release savedRelease = releaseService.saveRelease(release);
        return "redirect:/artist/get-releases?id=" + savedRelease.getArtist().getId()  + "&name=" + savedRelease.getArtist().getName();
    }

    @GetMapping("/get-add-release-form")
    public String getAddReleaseForm(Model model, @RequestParam(name = "aid") Long artistId) {
        LOG.info("Getting release form for new release");
        if(!model.containsAttribute("release")) {
            model.addAttribute("release", new Release());
        }
        if(!model.containsAttribute("artistId")) {
            model.addAttribute("artistId", artistId);
        }
        model.addAttribute("releaseAction", "add-new-release");
        return "forms/release-form";
    }

    @PostMapping ("/add-new-release")
    public String addRelease(@RequestParam Long aid, @Valid Release release, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            LOG.error("ERRORS in new release fields");
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.release", result);
            redirectAttributes.addFlashAttribute("release", release);
            return "redirect:/release/get-add-release-form?aid=" + aid;
        }
        Release savedRelease = releaseService.saveReleaseForArtist(release, aid);
        LOG.info("Added new release with title " + release.getTitle());
        return "redirect:/artist/get-releases?id=" + aid + "&name=" + savedRelease.getArtist().getName();
    }

    @PostMapping("/delete-release")
    public String deleteRelease(Release release){
        LOG.info("Deleting release with id:"  + release.getId());
        Release releaseForRemoval = releaseService.getReleaseById(release.getId());
        releaseService.removeRelease(release);
        return "redirect:/artist/get-releases?id=" + releaseForRemoval.getArtist().getId()  + "&name=" + releaseForRemoval.getArtist().getName();
    }

}
