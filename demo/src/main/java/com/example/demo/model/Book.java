package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class Book {
    private final UUID id;

    @NotBlank(message = "Book name cannot be blank")
    private final String bookName;

    @NotBlank(message = "Author cannot be blank")
    private final String author;

    @NotBlank(message = "Year cannot be blank")
    private final String year;

    @NotBlank(message = "Publisher cannot be blank")
    private final String publisher;

    @NotBlank(message = "Pages cannot be blank")
    private final String pages;

    public Book(@JsonProperty("id") UUID id,
                @JsonProperty("bookName") String bookName,
                @JsonProperty("author") String author,
                @JsonProperty("year") String year,
                @JsonProperty("publisher") String publisher,
                @JsonProperty("pages") String pages) {
        this.id = UUID.randomUUID();
        this.bookName = bookName;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.pages = pages;
    }

    public UUID getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPages() {
        return pages;
    }

}
