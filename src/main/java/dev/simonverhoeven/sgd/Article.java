package dev.simonverhoeven.sgd;

import java.time.LocalDate;

public record Article(String id, String title, LocalDate publicationDate) {
}
