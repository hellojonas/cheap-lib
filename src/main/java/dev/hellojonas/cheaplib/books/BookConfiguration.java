package dev.hellojonas.cheaplib.books;

import com.github.javafaker.Faker;
import dev.hellojonas.cheaplib.books.dto.BookSaveDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneId;

@Slf4j
@Configuration
public class BookConfiguration {

    private final BookService bookService;

    @Autowired
    BookConfiguration(BookService bookService){
        this.bookService = bookService;
    }


    public CommandLineRunner run() {
        Faker faker = new Faker();

        return args -> {
            int count = 20;
            while (count-- > 0) {

                BookSaveDTO newBook = new BookSaveDTO();
                newBook.setTitle(faker.book().title());
                newBook.setEdition(faker.number().numberBetween(1,5));
                newBook.setPages(faker.number().numberBetween(50L, 500L));
                newBook.setPublishedAt(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

                bookService.save(newBook);
            }
        };
    }
}
