package music.jb.musicmgmt.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArtistNotFoundException.class)
    public String userNotFoundException(ArtistNotFoundException ex) {
        return "error";
    }

}
