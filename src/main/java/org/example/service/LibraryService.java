package org.example.service;

import org.example.model.Book;
import org.example.model.Member;
import org.example.repository.BookRepository;
import org.example.repository.MemberRepository;

public class LibraryService {


    private final BookRepository bookRepository = new BookRepository();
    private final MemberRepository memberRepository = new MemberRepository();

    public void addBook(String id, String title, String author) {
        bookRepository.save(new Book(id, title, author));
        System.out.println("Book added: " + title);
    }

    public void registerMember(String id, String name) {
        memberRepository.save(new Member(id, name));
        System.out.println("Member registered: " + name);
    }

    public void issueBook(String bookId) {
        Book book = bookRepository.findById(bookId);
        if (book == null) {
            System.out.println("Book not found");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Book already issued");
            return;
        }
        book.setIssued(true);
        System.out.println("Book issued: " + book.getTitle());
    }

    public void returnBook(String bookId) {
        Book book = bookRepository.findById(bookId);
        if (book != null && book.isIssued()) {
            book.setIssued(false);
            System.out.println("Book returned: " + book.getTitle());
        }
    }

    public void displayBooks() {
        bookRepository.findAll().forEach(System.out::println);
    }
}