package music.jb.musicmgmt.restcontroller;

import music.jb.musicmgmt.dto.TrackDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest-service")
public class AppRestController {

    @PostMapping(path = "/add-track", produces = "application/json")
    public TrackDto addTrack(@RequestParam Long id) {
        TrackDto dto = new TrackDto();
        return dto;
    }

}
