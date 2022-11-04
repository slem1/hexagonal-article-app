package fr.sle.article.infrastructure.primary.api;

import fr.sle.article.application.ArticleApplicationService;
import fr.sle.article.common.domain.Article;
import fr.sle.article.common.domain.ArticleId;
import fr.sle.article.common.domain.exception.UnknowAuthorException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Adapter
 */
@RestController
@RequestMapping("/articles")
class ArticleEndpoint {

    private final ArticleApplicationService articleApplicationService;

    public ArticleEndpoint(ArticleApplicationService apiService) {
        this.articleApplicationService = apiService;
    }

    @GetMapping("/{articleId}")
    ArticleResponse get(@PathVariable("articleId") String articleId){
        final Article article = articleApplicationService.get(new ArticleId(articleId));
        return ArticleResponse.of(article);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ArticleIdResponse create(@RequestBody ArticleRequest articleRequest) throws UnknowAuthorException {
        final ArticleId articleId = articleApplicationService.publishNewArticle(articleRequest.authorId(), articleRequest.title(),
            articleRequest.content());
        return ArticleIdResponse.of(articleId);
    }
}
