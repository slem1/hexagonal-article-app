package fr.sle.article.infrastructure.secondary.repository;

import fr.sle.article.common.domain.*;
import fr.sle.article.common.domain.port.ArticleRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
public class ArticleRepositoryImpl implements ArticleRepository {

    private Map<String, ArticleEntity> db = new HashMap<>();

    @Override
    public ArticleId save(Author author, Title title, Content content) {
        final String uid = UUID.randomUUID().toString();
        final ArticleEntity articleEntity = new ArticleEntity(uid, author.id().value(), author.name().value(), title.value(), content.value());
        db.put(uid, articleEntity);
        return new ArticleId(articleEntity.id());
    }

    @Override
    public Optional<Article> get(ArticleId id) {
        final ArticleEntity articleEntity = db.get(id.value());
        return Optional.ofNullable(articleEntity).map(ArticleEntity::toArticle);
    }
}
