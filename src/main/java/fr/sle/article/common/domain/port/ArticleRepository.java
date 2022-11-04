package fr.sle.article.common.domain.port;


import fr.sle.article.common.domain.*;

import java.util.Optional;

public interface ArticleRepository {

    /**
     * Create or update an article
     * @param author author
     * @param title title
     * @param content content
     * @return the updated article
     */
    ArticleId save(Author author, Title title, Content content);

    /**
     * Retrieve an article
     * @param id id of the article
     * @return the article
     */
    Optional<Article> get(ArticleId id);

}
