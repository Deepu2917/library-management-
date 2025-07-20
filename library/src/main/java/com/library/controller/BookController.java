package com.library.controller;

import com.library.Model.Book;
import com.library.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
@Tag(name = "Book Controller", description = "APIs for managing books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    @Operation(summary = "Add a new book")
    public Book addBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping
    @Operation(summary = "Get all books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get book by ID")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update book by ID")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete book by ID")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Book with ID " + id + " deleted successfully.";
    }
}
