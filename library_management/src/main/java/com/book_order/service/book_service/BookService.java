package com.book_order.service.book_service;

import com.book_order.model.Book;
import com.book_order.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> finAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book finById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Book book) {
        bookRepository.delete(book);
    }
}
