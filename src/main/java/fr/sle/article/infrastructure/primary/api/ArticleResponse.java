package fr.sle.article.infrastructure.primary.api;

import com.fasterxml.jackson.annotation.JsonGetter;
import fr.sle.article.common.domain.Article;

import java.util.Objects;

class ArticleResponse {

    private final String id;
    private final String title;
    private final String content;
    private final String author;
    private final Integer numberOfPages;


    ArticleResponse(String id, String title, String content, String author, Integer numberOfPages) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    @JsonGetter
    public String id() {
        return id;
    }

    @JsonGetter
    public String title() {
        return title;
    }

    @JsonGetter
    public String content() {
        return content;
    }

    @JsonGetter
    public String author() {
        return author;
    }

    @JsonGetter
    public Integer numberOfPages() {
        return numberOfPages;
    }

    public static ArticleResponse of(Article article){

        return new ArticleResponse(
                article.id().value(),
                article.title().value(),
                article.content().value(),
                article.author().id().value(),
                article.numberOfPages());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleResponse that = (ArticleResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(author, that.author) && Objects.equals(numberOfPages, that.numberOfPages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, author, numberOfPages);
    }

    @Override
    public String toString() {
        return "ArticleResponse{" +
                "value=" + id +
                ", title=" + title +
                ", value=" + content +
                ", author=" + author +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
