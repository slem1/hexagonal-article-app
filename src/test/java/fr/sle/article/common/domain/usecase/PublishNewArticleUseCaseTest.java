package fr.sle.article.common.domain.usecase;

import fr.sle.article.UnitTest;
import fr.sle.article.common.domain.ArticleId;
import fr.sle.article.common.domain.ArticlesFixture;
import fr.sle.article.common.domain.AuthorsFixture;
import fr.sle.article.common.domain.exception.UnknowAuthorException;
import fr.sle.article.common.domain.port.ArticlePublisher;
import fr.sle.article.common.domain.port.ArticleRepository;
import fr.sle.article.common.domain.port.AuthorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.when;

@UnitTest
class PublishNewArticleUseCaseTest {

    @Test
    public void shouldPublishaNewArticle() throws UnknowAuthorException {

        ArticleRepository articleRepository = Mockito.mock(ArticleRepository.class);
        AuthorRepository authorRepository = Mockito.mock(AuthorRepository.class);
        ArticlePublisher articlePublisher = Mockito.mock(ArticlePublisher.class);

        PublishNewArticleUseCase publishNewArticleUseCase = new PublishNewArticleUseCase(articleRepository, authorRepository, articlePublisher);

        when(authorRepository.get(AuthorsFixture.authorHoratiuCirstea().id())).thenReturn(Optional.ofNullable(AuthorsFixture.authorHoratiuCirstea()));
        when(articleRepository.save(AuthorsFixture.authorHoratiuCirstea(),
                ArticlesFixture.articleReteNumberOfPages().title(), ArticlesFixture.articleReteNumberOfPages().content()))
                .thenReturn(ArticlesFixture.articleReteNumberOfPages().id());
        when(articleRepository.get(ArticlesFixture.articleReteNumberOfPages().id())).thenReturn(Optional.of(ArticlesFixture.articleReteNumberOfPages()));

        ArticleId articleId = publishNewArticleUseCase.publish(AuthorsFixture.authorHoratiuCirstea().id(),
                ArticlesFixture.articleReteNumberOfPages().title(),
                ArticlesFixture.articleReteNumberOfPages().content());

        Assertions.assertEquals(ArticlesFixture.articleReteNumberOfPages().id(), articleId);

        //add some verify code

    }

}
