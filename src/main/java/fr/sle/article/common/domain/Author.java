package fr.sle.article.common.domain;

import fr.sle.article.error.domain.Assert;

import java.util.Objects;

public class Author {

  private final AuthorId id;

  private final PersonName name;

  public Author(AuthorBuilder authorBuilder) {
    Assert.field("author", Objects.requireNonNull(authorBuilder.id).value()).notBlank().minLength(1);
    this.id = authorBuilder.id;
    Assert.field("author", Objects.requireNonNull(authorBuilder.name).value()).notBlank().minLength(1);
    this.name = authorBuilder.name;
  }

  @Generated
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Author author = (Author) o;
    return Objects.equals(id, author.id) && Objects.equals(name, author.name);
  }

  @Generated
  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Generated
  @Override
  public String toString() {
    return "Author{" +
      "id=" + id +
      ", name=" + name +
      '}';
  }

  public AuthorId id() {
    return id;
  }

  public PersonName name() {
    return name;
  }

  public static AuthorBuilder builder() {
    return new AuthorBuilder();
  }

  public static class AuthorBuilder implements AuthorAuthorId, AuthorName {

    private AuthorId id;
    private PersonName name;

    private AuthorBuilder() {
    }

    @Override
    public AuthorName authorId(AuthorId authorId) {
      this.id = authorId;
      return this;
    }

    @Override
    public AuthorBuilder authorName(PersonName personName) {
      this.name = personName;
      return this;
    }

    public Author build() {
      return new Author(this);
    }
  }

  public interface AuthorAuthorId {
    AuthorName authorId(AuthorId authorId);
  }

  public interface AuthorName {
    AuthorBuilder authorName(PersonName authorName);
  }
}
