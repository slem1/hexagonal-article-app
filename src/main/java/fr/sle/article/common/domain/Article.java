package fr.sle.article.common.domain;

import fr.sle.article.error.domain.Assert;

import java.util.Objects;

public class Article {

  private final ArticleId id;
  private final Title title;
  private final Content content;
  private final Author author;
  private final Integer numberOfPages;

  public Article(ArticleBuilder builder) {
    Assert.field("id", Objects.requireNonNull(builder.id, "value is required").value()).notBlank();
    Assert.field("title", Objects.requireNonNull(builder.title).value()).notBlank().minLength(1);
    Assert.field("content", Objects.requireNonNull(builder.content).value()).notBlank().minLength(10);
    Objects.requireNonNull(builder.author, "author is required");
    this.id = builder.id;
    this.title = builder.title;
    this.content = builder.content;
    this.author = builder.author;

    //optional fields
    if (builder.numberOfPages != null) {
      Assert.field("numberOfPages", builder.numberOfPages).min(1);
      this.numberOfPages = builder.numberOfPages;
    } else {
      this.numberOfPages = null;
    }
  }

  public ArticleId id() {
    return id;
  }

  public Title title() {
    return title;
  }

  public Content content() {
    return content;
  }

  public Author author() {
    return author;
  }

  public Integer numberOfPages() {
    return numberOfPages;
  }

  @Generated
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Article article = (Article) o;
    return Objects.equals(id, article.id) && Objects.equals(title, article.title) && Objects.equals(content, article.content) && Objects.equals(author, article.author) && Objects.equals(numberOfPages, article.numberOfPages);
  }

  @Generated
  @Override
  public int hashCode() {
    return Objects.hash(id, title, content, author, numberOfPages);
  }

  @Generated
  @Override
  public String toString() {
    return "Article{" +
      "id=" + id +
      ", title=" + title +
      ", content=" + content +
      ", author=" + author +
      ", numberOfPages=" + numberOfPages +
      '}';
  }

  public void validateEligibilityForPublication() {
    verifyForPlagiarism();
    validateTitleLength();
    validateContentLength();
    checkPunctuation();
    checkGrammar();
    checkStyle();
  }

  private void checkStyle() {
  }

  private void checkGrammar() {
  }

  private void checkPunctuation() {
  }

  private void validateContentLength() {
  }

  private void validateTitleLength() {
  }

  private void verifyForPlagiarism() {
  }

  public static ArticleBuilder builder() {
    return new ArticleBuilder();
  }

  public static class ArticleBuilder implements ArticleArticleIdBuilder, ArticleTitleBuilder, ArticleContentBuilder, ArticleAuthorBuilder {

    private ArticleId id;
    private Title title;
    private Content content;
    private Author author;

    private Integer numberOfPages;

    private ArticleBuilder() {
    }

    @Override
    public ArticleTitleBuilder articleId(ArticleId articleId) {
      this.id = articleId;
      return this;
    }

    @Override
    public ArticleContentBuilder title(Title title) {
      this.title = title;
      return this;
    }

    @Override
    public ArticleAuthorBuilder content(Content content) {
      this.content = content;
      return this;
    }

    @Override
    public ArticleBuilder author(Author author) {
      this.author = author;
      return this;
    }

    public ArticleBuilder numberOfPages(Integer n) {
      this.numberOfPages = n;
      return this;
    }

    public Article build() {
      return new Article(this);
    }
  }

  public interface ArticleArticleIdBuilder {
    ArticleTitleBuilder articleId(ArticleId articleId);
  }

  public interface ArticleTitleBuilder {
    ArticleContentBuilder title(Title title);
  }


  public interface ArticleContentBuilder {
    ArticleAuthorBuilder content(Content content);
  }

  public interface ArticleAuthorBuilder {
    ArticleBuilder author(Author author);
  }

}
