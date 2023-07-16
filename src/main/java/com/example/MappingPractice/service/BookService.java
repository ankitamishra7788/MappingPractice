package com.example.MappingPractice.service;

import com.example.MappingPractice.model.Book;
import com.example.MappingPractice.repository.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    IBookRepo bookRepo;

    public Iterable<Book> getAllBook(){
        return bookRepo.findAll();
    }

    public void addBook(Book book) {
        bookRepo.save(book);
    }

    public String updateBook(Long bookId, String bookPrice) {

        if(bookRepo.existsById(bookId)){
            bookRepo.updateBookPrice(bookPrice,bookId);
            return "Book Price  is Updated";
        }
        else{
            return "Book Id does not exist";
        }
    }

    public String deleteBook(Long bookId){
        if (bookRepo.existsById(bookId)){
            bookRepo.deleteBook(bookId);
            return "Book is deleted";
        }
        else{
            return "Book Id does not exists";
        }
    }
}
