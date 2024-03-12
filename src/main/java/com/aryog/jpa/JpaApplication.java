package com.aryog.jpa;

import com.aryog.jpa.models.Author;
import com.aryog.jpa.models.Video;
import com.aryog.jpa.repositories.AuthorRepository;
import com.aryog.jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {

		SpringApplication.run(JpaApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository repository, VideoRepository videoRepository){
		return args -> {
//			var author = Author.builder()
//					.firstName("Yogesh")
//					.lastName("Aryal")
//					.age(21)
//					.email("aryog@gmail.com")
//					.build();
//
//			repository.save(author);
			var video = Video.builder()
					.name("abc")
					.length(5)
					.build();
			videoRepository.save(video);
		};
	}
}
