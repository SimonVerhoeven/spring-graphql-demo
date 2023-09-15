package dev.simonverhoeven.sgd;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Controller
public class BookController {
    @QueryMapping
    public Book bookById(@Argument String id) {
        if ("raiseException".equalsIgnoreCase(id)) {
            throw new IllegalArgumentException("Raise exception for demo purposes");
        }
        return Book.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }

    @SubscriptionMapping("notifyNewBook")
    public Flux<Book> newBooks() {
        return Flux.fromIterable(
                List.of(
                        new Book("84b5a884-c234-4bec-be9d-951750038276", "978-0321146533", "Extreme Programming Explained", 240, "Introduction to Extreme Programming (XP) methodology.", "October 29, 2004", "a535fe2f-7d06-41bd-bbff-c802e42a8b06"),
                        new Book("636b1604-21d5-4b6c-97ae-93efa71031b5", "978-0321278654", "Test-Driven Development by Example", 240, "A guide to Test-Driven Development (TDD) practices.", "November 15, 2002", "a535fe2f-7d06-41bd-bbff-c802e42a8b06"),
                        new Book("1897256c-c523-48a8-be88-141626079c63", "978-0135974445", "Implementation Patterns", 176, "Patterns for writing clean, maintainable code.", "October 22, 2007", "a535fe2f-7d06-41bd-bbff-c802e42a8b06"),
                        new Book("9277ceb0-ae8f-4c8c-9934-d98e0f8d574e", "978-0201485677", "Smalltalk Best Practice Patterns", 224, "Best practices for programming in Smalltalk.", "November 21, 1996", "a535fe2f-7d06-41bd-bbff-c802e42a8b06"),
                        new Book("7811392e-acfb-4d2d-9c45-fda0087c778a", "978-0321509369", "Test-Driven Development: By Example (2nd Edition)", 240, "Updated edition of the TDD classic.", "October 17, 2022", "a535fe2f-7d06-41bd-bbff-c802e42a8b06"),
                        new Book("6c5635e6-7c8a-4eaa-b540-ac7f088402ad", "978-0201558024", "Planning Extreme Programming", 176, "A guide to planning in the XP methodology.", "November 22, 1999", "a535fe2f-7d06-41bd-bbff-c802e42a8b06"),
                        new Book("4ada5a12-d979-4f96-a090-2cbd6f3933cf", "978-0130676344", "Extreme Programming Explained: Embrace Change (2nd Edition)", 288, "Revised and updated edition of XP principles.", "November 18, 2004", "a535fe2f-7d06-41bd-bbff-c802e42a8b06"),
                        new Book("c8d7c976-df23-4d7f-bace-ef74dc0af08b", "978-0321336382", "Refactoring: Improving the Design of Existing Code", 464, "A classic on improving code design through refactoring.", "June 25, 1999", "a535fe2f-7d06-41bd-bbff-c802e42a8b06"),
                        new Book("dc49936f-29e9-494f-a7d3-5591ed99c006", "978-0201710915", "Contributing to Eclipse: Principles, Patterns, and Plug-Ins", 384, "Guidance on contributing to the Eclipse platform.", "April 8, 2003", "a535fe2f-7d06-41bd-bbff-c802e42a8b06")
                )
        ).delayElements(Duration.ofSeconds(2));

    }
}