package music.jb.musicmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MusicmgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicmgmtApplication.class, args);

	}

}
