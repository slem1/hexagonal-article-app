package fr.sle.article.application;

import fr.sle.article.common.domain.*;
import fr.sle.article.common.domain.exception.UnknowAuthorException;

public interface ArticleApplicationService {
    Article get(ArticleId id);

    ArticleId publishNewArticle(AuthorId authorId, Title title, Content content) throws UnknowAuthorException;
}
