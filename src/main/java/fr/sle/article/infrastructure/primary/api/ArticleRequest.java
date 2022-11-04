package fr.sle.article.infrastructure.primary.api;

import fr.sle.article.common.domain.AuthorId;
import fr.sle.article.common.domain.Content;
import fr.sle.article.common.domain.Title;

import java.util.Objects;

class ArticleRequest {

    private String title;
    private String authorId;
    private String content;
    private Integer numberOfPages;

    //-- for jackson
    private ArticleRequest(){

    }

    public ArticleRequest(String title, String authorId, String content, Integer numberOfPages) {
        this.title = title;
        this.authorId = authorId;
        this.content = content;
        this.numberOfPages = numberOfPages;
    }

    public Title title(){
        return new Title(title);
    }

    public AuthorId authorId(){
        return new AuthorId(authorId);
    }

    public Content content(){
        return new Content(content);
    }

    public Integer getNumberOfPages(){
        return numberOfPages;
    }

    //private setters for jackson -------------------------
    private void setTitle(String title) {
        this.title = title;
    }

    private void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    private void setContent(String content) {
        this.content = content;
    }

    private void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleRequest that = (ArticleRequest) o;
        return Objects.equals(title, that.title) && Objects.equals(authorId, that.authorId) && Objects.equals(content, that.content) && Objects.equals(numberOfPages, that.numberOfPages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authorId, content, numberOfPages);
    }

    @Override
    public String toString() {
        return "ArticleRequest{" +
                "title='" + title + '\'' +
                ", authorId='" + authorId + '\'' +
                ", content='" + content + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
