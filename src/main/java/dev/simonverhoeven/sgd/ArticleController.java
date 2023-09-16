package dev.simonverhoeven.sgd;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Controller
public class ArticleController {

    @QueryMapping("getLatestArticle")
    public Article getNewArticle() {
        return new Article("f9dd96a8-02fa-48e9-9f74-751d709e5849", "Latest", LocalDate.now());
    }
}
