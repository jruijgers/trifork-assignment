package com.salandur.triforkassignment;

import com.salandur.triforkassignment.domain.Author;
import com.salandur.triforkassignment.domain.Book;
import com.salandur.triforkassignment.repositories.AuthorsRepository;
import com.salandur.triforkassignment.repositories.BooksRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TriforkAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(TriforkAssignmentApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BooksRepository booksRepository, AuthorsRepository authorsRepository) {
        return (args) -> {
            Author terryPratchett = new Author();
            terryPratchett.setName("Terry Pratchett");
            authorsRepository.save(terryPratchett);

            Book colourOfMagic = new Book();
            colourOfMagic.setTitle("The Colour of Magic");
            colourOfMagic.setDescription("The Colour of Magic is a 1983 fantasy comedy novel by Terry Pratchett, and is the first book of the Discworld series.");
            colourOfMagic.setPrice(12.99);
            colourOfMagic.setCoverImage("https://upload.wikimedia.org/wikipedia/en/thumb/4/4d/The_Colour_of_Magic_%28cover_art%29.jpg/220px-The_Colour_of_Magic_%28cover_art%29.jpg");
            colourOfMagic.setAuthor(terryPratchett);
            booksRepository.save(colourOfMagic);

            Author stephenKing = new Author();
            stephenKing.setName("Stephen King");
            stephenKing.setPseudonym("Richard Bachman");
            authorsRepository.save(stephenKing);

            Book theShining = new Book();
            theShining.setTitle("The Shining");
            theShining.setPrice(15.99);
            theShining.setAuthor(stephenKing);
            booksRepository.save(theShining);
        };
    }
}
