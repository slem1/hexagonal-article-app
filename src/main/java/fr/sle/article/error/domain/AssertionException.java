package fr.sle.article.error.domain;

public class AssertionException extends RuntimeException {

  public AssertionException(String message) {
    super(message);
  }
}
