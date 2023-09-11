package dev.simonverhoeven.sgd;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class AuthorController {

    @QueryMapping("authorById")
    public Author findAuthor(@Argument String id) {
        return Author.getById(id);
    }

    @MutationMapping("addAuthor")
    public Author createAuthor(
            @Argument String firstName,
            @Argument String lastName,
            @Argument String shortBio

    ) {
        Author author = new Author(UUID.randomUUID().toString(), firstName, lastName, shortBio, "");
        Author.addAuthor(author);
        return author;
    }
}
