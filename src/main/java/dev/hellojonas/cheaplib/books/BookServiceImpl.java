package dev.hellojonas.cheaplib.books;

import dev.hellojonas.cheaplib.books.dto.BookSaveDTO;
import dev.hellojonas.cheaplib.books.dto.BookUpdateDTO;
import dev.hellojonas.cheaplib.dojo.PageModel;
import dev.hellojonas.cheaplib.dojo.PageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(@Valid BookSaveDTO bookData) {
        return bookRepository.save(bookData.toEntity());
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public PageModel<Book> findBooks() {
        Page<Book> books = bookRepository.findAll(PageRequest.of(1, 10));
        return new PageWrapper<>(books);
    }

    @Override
    public boolean deleteBook(Long id) {
        return false;
    }

    @Override
    public Book updateBook(@Valid BookUpdateDTO bookData) {
        return bookRepository.save(bookData.toEntity());
    }
}
