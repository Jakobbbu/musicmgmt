package music.jb.musicmgmt.controller;

import jakarta.validation.Valid;
import music.jb.musicmgmt.model.Artist;
import music.jb.musicmgmt.service.ArtistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * WebController is the main controller for website . . .
 *
 * @author Jakob.
 *
 */
@Controller
public class WebController {

    private final Logger LOG = LoggerFactory.getLogger(WebController.class);

    private final ArtistService artistService;

    public WebController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/home")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/artist/all-artists")
    public String getAllArtists(Model model) {
       model.addAttribute("artists", artistService.getAllArtist());
       return "tables/artist-table";
    }

    @GetMapping("/artist/search-for-artist")
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

    //editing artist
    @GetMapping("artist/get-edit-artist-form")
    public String getEditArtistForm(@RequestParam(name = "id") String artistId, Model model) {
        LOG.info("Getting artist form for artist with id " + artistId);
        model.addAttribute("artist", artistService.getArtistById(artistId));
        model.addAttribute("artistAction", "update-artist");
        model.addAttribute("formMethod", "post");
        return "forms/artist-form";
    }

    @PostMapping ("artist/update-artist")
    public String updateArtist(@Valid Artist artist, BindingResult result, Model model) {
        LOG.info("Getting artist form for artist with name " + artist.getName());
        if(result.hasErrors()) {
            model.addAttribute("artist", artistService.getArtistById(artist.getId()));
            model.addAttribute("artistAction", "update-artist");
            model.addAttribute("formMethod", "post");
            return "forms/artist-form";
        }
        return "redirect:/artist/all-artists";
    }

    @GetMapping("artist/get-add-artist-form")
    public String getAddArtistForm(Model model) {
        model.addAttribute("artist", new Artist());
        model.addAttribute("artistAction", "add-new-artist");
        model.addAttribute("formMethod", "post");
        return "forms/artist-form";
    }



    @PostMapping ("artist/add-new-artist")
    public String addArtist(@Valid Artist artist, BindingResult result, Model model) {
/*        model.addAttribute("artist", artistService.getArtistById(artistId));
        model.addAttribute("artist-action", "edit");*/
        if(result.hasErrors()) {
            model.addAttribute("artist", new Artist());
            model.addAttribute("artistAction", "add-new-artist");
            model.addAttribute("formMethod", "post");
            return "forms/artist-form";
        }
        LOG.info("added new artist with name " + artist.getName());
        return "redirect:/artist/all-artists";

    }

/*    @PostMapping("/editartist")
    public String editArtist(Artist artist, Model model) {
        return "index";
    }

    @PostMapping("/editartist")
    public String saveArtist(Artist artist, Model model) {
        return "index";
    }

    @GetMapping("/getReleases")
    public String getReleasesForArtist(Artist artist) {
        return "index";
    }

    @GetMapping("/getMembers")
    public String getMembersForArtist(Artist artist) {
        return "index";
    }

    @PostMapping("/addMembers")
    public String addMembersForArtist(Artist artist) {
        return "index";
    }*/

    //add releases
    //delete - method mapping
    //update -
}
