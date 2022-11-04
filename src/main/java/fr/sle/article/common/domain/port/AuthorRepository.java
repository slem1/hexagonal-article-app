package fr.sle.article.common.domain.port;

import fr.sle.article.common.domain.Author;
import fr.sle.article.common.domain.AuthorId;

import java.util.Optional;

public interface AuthorRepository {

    Optional<Author> get(AuthorId id);

}
