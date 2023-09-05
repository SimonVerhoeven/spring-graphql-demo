package dev.simonverhoeven.sgd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

import static org.assertj.core.api.Assertions.assertThat;

@GraphQlTest(AuthorController.class)
public class AuthorControllerTest {
    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void bookById_inline() {
        final String document = """
                mutation addAuthor {
                    addAuthor(
                      firstName: "Venkat"
                      lastName: "Subramaniam"
                      shortBio: "Venkat Subramaniam is an award-winning author, founder of Agile Developer, Inc., and an instructional professor at the University of Houston."
                    ) {
                  		id
                      firstName
                      lastName
                    }
                  }""";

        final Author author = this.graphQlTester
                .document(document)
                .execute()
                .path("addAuthor")
                .entity(Author.class)
                .get();

        assertThat(author.firstName()).isEqualTo("Venkat");
        assertThat(author.lastName()).isEqualTo("Subramaniam");
        assertThat(author.id()).isNotNull();
    }
}
