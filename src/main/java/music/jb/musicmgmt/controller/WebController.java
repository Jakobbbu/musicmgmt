package music.jb.musicmgmt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * WebController is the main controller for website . . .
 *
 * @author Jakob.
 *
 */
@Controller
public class WebController {

    @GetMapping("/home")
    public String getHomePage() {
        return "index";
    }

}
