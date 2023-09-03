package dev.simonverhoeven.sgd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(BookController.class)
public class BookControllerTest {
    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void bookById() {
        this.graphQlTester
                .documentName("bookInfo")
                .variable("id", "a8950574-a399-4f42-a168-31f59c0079a5")
                .execute()
                .path("bookById")
                .matchesJson("""
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
                            }
                        """);
    }

}