package com.library.service;


import com.library.Model.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book updateBook(Long id, Book updatedBook) {
        Book existing = bookRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setTitle(updatedBook.getTitle());
            existing.setAuthor(updatedBook.getAuthor());
            existing.setIsbn(updatedBook.getIsbn());
            existing.setPublicationYear(updatedBook.getPublicationYear());
            return bookRepository.save(existing);
        }
        return null;
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

