package music.jb.musicmgmt.controller;

import music.jb.musicmgmt.model.Artist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    private final Logger LOG = LoggerFactory.getLogger(WebController.class);

    @GetMapping("/index")
    public String getHomePage(Model model) {
        LOG.info("controler called");

        List<Artist> artistList = new ArrayList<>();
        Artist artist = new Artist();
        artist.setDescription("super opis");
        artist.setName("alo stari");

        artistList.add(artist);

        model.addAttribute("artists", artistList);

        return "index";
    }
}
