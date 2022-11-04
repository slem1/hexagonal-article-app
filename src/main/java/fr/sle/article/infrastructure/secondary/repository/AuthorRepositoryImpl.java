package fr.sle.article.infrastructure.secondary.repository;

import fr.sle.article.common.domain.Author;
import fr.sle.article.common.domain.AuthorId;
import fr.sle.article.common.domain.PersonName;
import fr.sle.article.common.domain.port.AuthorRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    private Map<String, Author> db = new HashMap<>();

    public AuthorRepositoryImpl(){
        db.put("Cirstea", Author.builder()
                .authorId(new AuthorId("Cirstea"))
                .authorName(new PersonName("Horatiu Cirstea")).build());
    }

    @Override
    public Optional<Author> get(AuthorId id) {
        Objects.requireNonNull(id);
        return Optional.ofNullable(db.get(id.value()));
    }
}
