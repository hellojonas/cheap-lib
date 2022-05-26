package dev.hellojonas.cheaplib.books;

import dev.hellojonas.cheaplib.books.dto.BookSaveDTO;
import dev.hellojonas.cheaplib.books.dto.BookUpdateDTO;
import dev.hellojonas.cheaplib.dojo.PageModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface BookService {
    Book save(BookSaveDTO bookData);
    Optional<Book> findById(Long id);
    PageModel<Book> findBooks();
    boolean deleteBook(Long id);
    Book updateBook(BookUpdateDTO bookData);
}
