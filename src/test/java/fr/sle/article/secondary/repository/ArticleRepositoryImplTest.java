package fr.sle.article.secondary.repository;

import fr.sle.article.UnitTest;
import fr.sle.article.common.domain.Article;
import fr.sle.article.common.domain.ArticleId;
import fr.sle.article.common.domain.ArticlesFixture;
import fr.sle.article.infrastructure.secondary.repository.ArticleRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@UnitTest
class ArticleRepositoryImplTest {

    @Test
    void shouldSaveAndGet() {
        ArticleRepositoryImpl articleRepository = new ArticleRepositoryImpl();

        ArticleId articleId = articleRepository.save(ArticlesFixture.articleReteNumberOfPages().author(),
                ArticlesFixture.articleReteNumberOfPages().title(),
                ArticlesFixture.articleReteNumberOfPages().content());

        Assertions.assertNotNull(articleId.value());

        Article article = articleRepository.get(articleId).get();

        Assertions.assertEquals(ArticlesFixture.articleReteNumberOfPages().title(), article.title());
        Assertions.assertEquals(ArticlesFixture.articleReteNumberOfPages().content(), article.content());
        Assertions.assertEquals(ArticlesFixture.articleReteNumberOfPages().author(), article.author());
    }
}
