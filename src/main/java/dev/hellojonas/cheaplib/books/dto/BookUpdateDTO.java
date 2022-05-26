package dev.hellojonas.cheaplib.books.dto;

import dev.hellojonas.cheaplib.books.Book;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class BookUpdateDTO {
    @NotBlank(message = "id cannot be empty")
    private Long id;
    private String title;
    private Long pages;
    private Integer edition;
    private LocalDate publishedAt;

    public Book toEntity() {
        Book book = new Book();
        book.setTitle(title);
        book.setPages(pages);
        book.setEdition(edition);
        book.setPublishedAt(publishedAt);

        return  book;
    }
}
