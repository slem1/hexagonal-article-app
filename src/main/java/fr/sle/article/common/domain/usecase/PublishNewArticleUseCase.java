package fr.sle.article.common.domain.usecase;

import fr.sle.article.common.domain.*;
import fr.sle.article.common.domain.exception.UnknowAuthorException;
import fr.sle.article.common.domain.port.ArticlePublisher;
import fr.sle.article.common.domain.port.ArticleRepository;
import fr.sle.article.common.domain.port.AuthorRepository;
import org.springframework.stereotype.Component;

@Component
public class PublishNewArticleUseCase {

    private final ArticleRepository articleRepository;
    private final AuthorRepository authorRepository;
    private final ArticlePublisher articlePublisher;

    public PublishNewArticleUseCase(ArticleRepository articleRepository, AuthorRepository authorRepository, ArticlePublisher articlePublisher) {
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
        this.articlePublisher = articlePublisher;
    }

    public ArticleId publish(AuthorId authorId, Title title, Content content) throws UnknowAuthorException {
        Author author = authorRepository.get(authorId).orElseThrow(UnknowAuthorException::new);
        final ArticleId save = articleRepository.save(author, title, content);
        final Article article = articleRepository.get(save).orElseThrow();
        article.validateEligibilityForPublication(); //throw exception if invalid, so abort transaction
        articlePublisher.publishArticleCreation(article);
        return article.id();

    }

}
