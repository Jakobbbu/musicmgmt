package music.jb.musicmgmt.controller;

import jakarta.validation.Valid;
import music.jb.musicmgmt.model.Artist;
import music.jb.musicmgmt.service.ArtistService;
import music.jb.musicmgmt.service.MemberService;
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

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("artist")
public class ArtistController {

    private final Logger LOG = LoggerFactory.getLogger(ArtistController.class);

    private final ArtistService artistService;
    private final MemberService memberService;
    private final ReleaseService releaseService;

    public ArtistController(ArtistService artistService, MemberService memberService, ReleaseService releaseService) {
        this.artistService = artistService;
        this.memberService = memberService;
        this.releaseService = releaseService;
    }

    @GetMapping("/all-artists")
    public String getAllArtists(Model model) {
       model.addAttribute("artists", artistService.getAllArtist());
       return "tables/artist-table";
    }

    @GetMapping("/search-for-artist")
    public String searchForArtist(String key, Model model) {
        if(!key.isBlank() && !key.isEmpty()) {
            List<Artist> artistList =  artistService.searchForArtist(key);
            if(!artistList.isEmpty()) {
                model.addAttribute("artists", artistList);
                return "tables/artist-table";
            }
        }
        return "index";
    }

    @GetMapping("/get-members")
    public String getMembersForArtist(@RequestParam Long id, @RequestParam(required = false) String name, Model model){
        model.addAttribute("members", memberService.getMembersForArtist(id));
        if(Optional.ofNullable(name).isPresent()) {
            model.addAttribute("artistId", id);
            model.addAttribute("artistName", name);
        }
        model.addAttribute("artistId", id);
        return "tables/members-table";
    }

    @GetMapping("/get-releases")
    public String getReleasesForArtist(@RequestParam Long id, @RequestParam String name, Model model) {
        model.addAttribute("releases", releaseService.getReleasesForArtist(id));
        model.addAttribute("artistId", id);
        model.addAttribute("artistName", name);
        return "tables/release-table";
    }

    @GetMapping("/get-edit-artist-form")
    public String getEditArtistForm(@RequestParam(name = "id") Long artistId, Model model) {
        LOG.info("Getting artist form for artist with id " + artistId);
        if(!model.containsAttribute("artist")) {
            model.addAttribute("artist", artistService.getArtistById(artistId));
        }
        model.addAttribute("artistAction", "update-artist");
        return "forms/artist-form";
    }

    @PostMapping ("/update-artist")
    public String updateArtist(@Valid Artist artist, BindingResult result, RedirectAttributes redirectAttributes) {
        LOG.info("UPDATING artist with id" + artist.getId());
        if(result.hasErrors()) {
            LOG.error("ERRORS in edited artist fields");
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.artist", result);
            redirectAttributes.addFlashAttribute("artist", artist);
            return "redirect:/artist/get-edit-artist-form?id=" + artist.getId();
        }
        LOG.info("Saving changes on artist with id " + artist.getId());
        artistService.saveArtist(artist);
        return "redirect:/artist/all-artists";
    }

    @GetMapping("/get-add-artist-form")
    public String getAddArtistForm(Model model) {
        LOG.info("Getting artist form for new artist");
        if(!model.containsAttribute("artist")) {
            model.addAttribute("artist", new Artist());
        }
        model.addAttribute("artistAction", "add-new-artist");
        return "forms/artist-form";
    }

    @PostMapping ("/add-new-artist")
    public String addArtist(@Valid Artist artist, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            LOG.error("ERRORS in new artist fields");
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.artist", result);
            redirectAttributes.addFlashAttribute("artist", artist);
            return "redirect:/artist/get-add-artist-form";
        }
        artistService.saveArtist(artist);
        LOG.info("added new artist with name " + artist.getName());
        redirectAttributes.addFlashAttribute("succesNotification", true);
        return "redirect:/artist/all-artists";
    }

    @PostMapping("/delete-artist")
    public String deleteArtist(Artist artist){
        LOG.info("Deleting artist:"  + artist.getId());
        artistService.removeArtist(artist);
        return "redirect:/artist/all-artists";
    }

}
