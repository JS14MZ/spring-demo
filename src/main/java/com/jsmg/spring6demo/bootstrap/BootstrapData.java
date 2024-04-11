package com.jsmg.spring6demo.bootstrap;

import com.jsmg.spring6demo.domain.Author;
import com.jsmg.spring6demo.domain.Book;
import com.jsmg.spring6demo.repositories.AuthorRepository;
import com.jsmg.spring6demo.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author a1 = new Author();
        a1.setFirstName("Eric");
        a1.setLastName("Evans");

        Book b1 = new Book();
        b1.setTitle("Domain Driven Design");
        b1.setIsbn("123456");

        Author a2 = new Author();
        a2.setFirstName("Rod");
        a2.setLastName("Johnson");

        Book b2 = new Book();
        b2.setTitle("J2EE Development without EJB");
        b2.setIsbn("54757585");

        Author a1Saved = authorRepository.save(a1);
        Author a2Saved = authorRepository.save(a2);
        Book b1Saved = bookRepository.save(b1);
        Book b2Saved = bookRepository.save(b2);

        a1Saved.getBooks().add(b1Saved);
        a2Saved.getBooks().add(b2Saved);

        authorRepository.save(a1Saved);
        authorRepository.save(a2Saved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
    }
}
