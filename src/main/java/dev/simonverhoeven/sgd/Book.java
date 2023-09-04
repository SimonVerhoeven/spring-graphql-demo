package dev.simonverhoeven.sgd;

import java.util.Arrays;
import java.util.List;

public record Book (String id, String isbn, String name, int pageCount, String summary, String publicationDate, String authorId) {

    private static final List<Book> books = Arrays.asList(
            new Book("a8950574-a399-4f42-a168-31f59c0079a5", "9780132350884", "Clean Code", 464, "A handbook of agile software craftsmanship.", "2008-08-11", "a535fe2f-7d06-41bd-bbff-c802e42a8b06"),
            new Book("c0ead32f-e5a5-43cb-afc8-39689bd02c38", "9780596007126", "Head First Design Patterns", 694, "A guide to design patterns in software development.", "2004-10-25", "1e37f5f5-8a2d-439c-9b2a-5ed62d933fad"),
            new Book("fec79ccb-c91c-44ba-be0a-3d921ce1d4d4", "9781491901632", "JavaScript: The Good Parts", 176, "Exploring the best parts of JavaScript.", "2008-05-30", "92672828-f10e-488f-af03-ba3d4137d455"),
            new Book("28804aed-d6b4-4f66-aee9-5d3685944649", "9780132937608", "Java: The Complete Reference", 1312, "Comprehensive guide to the Java programming language.", "2011-12-05", "19f94cca-fa7a-497d-8b70-76be0ba30f0c"),
            new Book("0fffa5a8-b832-459a-973d-b2895abc0505", "9781449319274", "Eloquent JavaScript", 472, "A modern introduction to programming with JavaScript.", "2011-12-05", "ea2ed949-b11a-4e4d-9094-dac54b1c4cc9")
    );

    public static Book getById(String id) {
        return books.stream()
                .filter(book -> book.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}

