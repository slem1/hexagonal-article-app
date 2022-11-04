package fr.sle.article.application;

import fr.sle.article.common.domain.*;
import fr.sle.article.common.domain.exception.UnknowAuthorException;
import fr.sle.article.common.domain.port.ArticleRepository;
import fr.sle.article.common.domain.usecase.PublishNewArticleUseCase;
import org.springframework.stereotype.Service;

@Service
//@Transactional
public class ArticleApplicationServiceImpl implements ArticleApplicationService {
    private final PublishNewArticleUseCase publishNewArticleUseCase;

    private final ArticleRepository articleRepository;

    public ArticleApplicationServiceImpl(PublishNewArticleUseCase publishNewArticleUseCase, ArticleRepository articleRepository) {
        this.publishNewArticleUseCase = publishNewArticleUseCase;
        this.articleRepository = articleRepository;
    }

    @Override
    public Article get(ArticleId id) {
        return articleRepository.get(id).orElseThrow();
    }

    @Override
    public ArticleId publishNewArticle(AuthorId authorId, Title title, Content content) throws UnknowAuthorException {
        return publishNewArticleUseCase.publish(authorId, title, content);
    }
}
