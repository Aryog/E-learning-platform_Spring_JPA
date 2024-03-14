package com.aryog.jpa;

import com.aryog.jpa.models.Author;
import com.aryog.jpa.models.Video;
import com.aryog.jpa.repositories.AuthorRepository;
import com.aryog.jpa.repositories.VideoRepository;
import com.github.javafaker.Faker;
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
			for (int i = 0; i < 50; i++) {
				Faker faker = new Faker();
				var author = Author.builder()
					.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(19,80))
						.email(faker.name().username()+"@gmail.com")
						.build();

				repository.save(author);
			}
//			var author = Author.builder()
//					.firstName("Yogesh")
//					.lastName("Aryal")
//					.age(21)
//					.email("aryog@gmail.com")
//					.build();
//
//			repository.save(author);
//			var video = Video.builder()
//					.name("abc")
//					.length(5)
//					.build();
//			videoRepository.save(video);

			// update using the id
			var author = Author.builder()
					.id(1)
					.firstName("Yogesh")
					.lastName("Aryal")
					.age(21)
					.email("yogesh@gmail.com")
					.build();

			repository.save(author);
			// repository.updateAuthor(22,1);

			repository.findByNamedQuery(20).forEach(System.out::println);

		};


	}
}
