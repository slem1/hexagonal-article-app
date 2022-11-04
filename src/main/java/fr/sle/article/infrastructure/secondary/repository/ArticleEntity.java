package fr.sle.article.infrastructure.secondary.repository;

import fr.sle.article.common.domain.*;

import java.util.Objects;

public class ArticleEntity {

    private final String id;

    private final String authorId;

    private final String authorName;

    private final String title;

    private final String content;

    public Article toArticle() {

        final Author author = Author.builder()
            .authorId(new AuthorId(authorId))
            .authorName(new PersonName(authorName))
            .build();

        return Article.builder()
            .articleId(new ArticleId(id))
            .title(new Title(title))
            .content(new Content(content))
            .author(author)
            .build();

    }

    public String id() {
        return id;
    }

    public String authorId() {
        return authorId;
    }

    public String title() {
        return title;
    }

    public String content() {
        return content;
    }

    public ArticleEntity(String id, String authorId, String authorName, String title, String content) {
        this.id = id;
        this.authorId = authorId;
        this.authorName = authorName;
        this.title = title;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArticleEntity that = (ArticleEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(authorId, that.authorId) && Objects.equals(title,
            that.title) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorId, title, content);
    }

    @Override
    public String toString() {
        return "ArticleEntity{" +
            "articleId='" + id + '\'' +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            '}';
    }
}
