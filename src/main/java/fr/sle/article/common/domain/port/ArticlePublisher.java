package fr.sle.article.common.domain.port;


import fr.sle.article.common.domain.Article;

public interface ArticlePublisher {

    void publishArticleCreation(Article article);

}
