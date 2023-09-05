package dev.simonverhoeven.sgd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Author (String id, String firstName, String lastName, String shortBio, String linkedinUrl) {

    private static List<Author> authors = Stream.of(
            new Author("a535fe2f-7d06-41bd-bbff-c802e42a8b06", "Robert", "Martin", "Author of 'Clean Code.'", "https://linkedin.com/in/robertmartin"),
            new Author("1e37f5f5-8a2d-439c-9b2a-5ed62d933fad", "Eric", "Freeman", "Co-author of 'Head First Design Patterns.'", "https://linkedin.com/in/ericfreeman"),
            new Author("92672828-f10e-488f-af03-ba3d4137d455", "Douglas", "Crockford", "JavaScript expert and author.", "https://linkedin.com/in/douglascrockford"),
            new Author("19f94cca-fa7a-497d-8b70-76be0ba30f0c", "Herbert", "Schildt", "Experienced Java author.", "https://linkedin.com/in/herbertschildt"),
            new Author("ea2ed949-b11a-4e4d-9094-dac54b1c4cc9", "Marijn", "Haverbeke", "Author of 'Eloquent JavaScript.'", "https://linkedin.com/in/marijnhaverbeke")
    ).collect(Collectors.toCollection(ArrayList::new));

    public static Author getById(String id) {
        return authors.stream()
                .filter(author -> author.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static void addAuthor(Author author) {
        authors.add(author);
    }
}
