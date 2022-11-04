package fr.sle.article.infrastructure.secondary.publisher;

import fr.sle.article.common.domain.Article;

class ArticleMessage {

    private final String title;

    private final String authorId;


    private ArticleMessage(String title, String authorId) {
        this.title = title;
        this.authorId = authorId;
    }

    public static ArticleMessage of(Article article){
        return new ArticleMessage(article.title().value(), article.author().id().value());
    }

}
