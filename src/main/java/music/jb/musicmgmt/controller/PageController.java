package music.jb.musicmgmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    private final Logger LOG = LoggerFactory.getLogger(PageController.class);

    @GetMapping("/index")
    public void getHomePage() {
        LOG.info("controler called");
    }
}
