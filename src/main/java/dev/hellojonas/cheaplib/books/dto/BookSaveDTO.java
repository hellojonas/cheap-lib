package dev.hellojonas.cheaplib.books.dto;

import dev.hellojonas.cheaplib.books.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveDTO {
    @NotBlank(message = "title cannot be empty")
    private String title;

    @NotBlank(message = "pages cannot be empty")
    private Long pages;

    private Integer edition;

    @NotBlank(message = "publishedAt cannot be empty")
    private LocalDate publishedAt;

    public Book toEntity() {
        Book b = new Book();
        b.setTitle(title);
        b.setPages(pages);
        b.setEdition(edition);
        b.setPublishedAt(publishedAt);

        return b;
    }
}
