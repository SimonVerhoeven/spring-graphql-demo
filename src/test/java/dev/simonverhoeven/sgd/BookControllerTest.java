package dev.simonverhoeven.sgd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;
import reactor.test.StepVerifier;

@GraphQlTest(BookController.class)
public class BookControllerTest {
    public static final String CLEAN_CODE_PAYLOAD = """
                {
                  "id": "a8950574-a399-4f42-a168-31f59c0079a5",
                  "name": "Clean Code",
                  "pageCount": 464,
                  "summary": "A handbook of agile software craftsmanship.",
                  "publicationDate": "2008-08-11",
                  "author": {
                    "id": "a535fe2f-7d06-41bd-bbff-c802e42a8b06",
                    "firstName": "Robert",
                    "lastName": "Martin",
                    "shortBio": "Author of 'Clean Code.'",
                    "linkedinUrl": "https://linkedin.com/in/robertmartin"
                  }
                }""";
    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void bookById() {
        this.graphQlTester
                .documentName("bookInfo")
                .variable("id", "a8950574-a399-4f42-a168-31f59c0079a5")
                .execute()
                .path("bookById")
                .matchesJson(CLEAN_CODE_PAYLOAD);
    }

    @Test
    void bookById_inline() {
        final String document = """
                {
                  bookById(id: "a8950574-a399-4f42-a168-31f59c0079a5") {
                    id
                    name
                    pageCount
                    summary
                    publicationDate
                    author {
                      id
                      firstName
                      lastName
                      shortBio
                      linkedinUrl
                    }
                  }
                }""";

        this.graphQlTester
                .document(document)
                .execute()
                .path("bookById")
                .matchesJson(CLEAN_CODE_PAYLOAD);
    }

    @Test
    void newBooks() {
        final String document = """
                subscription {
                  notifyNewBook {
                    id
                    isbn
                    name
                  }
                }
                """;

        final var bookFlux = this.graphQlTester.document(document)
                .executeSubscription()
                .toFlux("notifyNewBook", Book.class);

        StepVerifier.create(bookFlux)
                .expectNextCount(9)
                .verifyComplete();
    }

}
