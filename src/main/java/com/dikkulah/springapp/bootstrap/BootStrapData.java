package com.dikkulah.springapp.bootstrap;

import com.dikkulah.springapp.model.Author;
import com.dikkulah.springapp.model.Book;
import com.dikkulah.springapp.model.Publisher;
import com.dikkulah.springapp.repositories.AuthorRepository;
import com.dikkulah.springapp.repositories.BookRepository;
import com.dikkulah.springapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Publisher bookPub = new Publisher();
        bookPub.setName("Kastamonu Yayınevi");
        bookPub.setCity("Kastamonu");
        bookPub.setState("Merkez");
        publisherRepository.save(bookPub);


        Author eric = new Author("Ufuk","Yılmaz");
        Book tarih = new Book("İstanbul","123123");
        eric.getBooks().add(tarih);
        tarih.getAuthors().add(eric);
        tarih.setPublisher(bookPub);
        bookPub.getBooks().add(tarih);
        authorRepository.save(eric);
        bookRepository.save(tarih);

        Author rod = new Author("rod","Jhonson");
        Book nnoEJB = new Book("J2EE Development ","123123213");
        rod.getBooks().add(nnoEJB);
        nnoEJB.getAuthors().add(rod);
        nnoEJB.setPublisher(bookPub);
        bookPub.getBooks().add(nnoEJB);


        authorRepository.save(rod);
        bookRepository.save(nnoEJB);

        System.out.println("Kayıtlı yayınevi sayısı:  "+publisherRepository.count());
        System.out.println("Kayıtlı yazar sayısı:  "+authorRepository.count());
        System.out.println("Kayıtlı kitap sayısı:  "+bookRepository.count());
        System.out.println("Yayınevi kitap sayısı:  "+bookPub.getBooks().size());

    }
}
