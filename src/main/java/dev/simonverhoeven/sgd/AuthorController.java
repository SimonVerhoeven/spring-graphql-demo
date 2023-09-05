package dev.simonverhoeven.sgd;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class AuthorController {

    @MutationMapping
    public Author addAuthor(
            @Argument String firstName,
            @Argument String lastName,
            @Argument String shortBio

    ) {
        Author author = new Author(UUID.randomUUID().toString(), firstName, lastName, shortBio, "");
        Author.addAuthor(author);
        return author;
    }
}
