package fr.sle.article.common.domain;

public class ArticlesFixture {

    private ArticlesFixture(){

    }
    public static Article articleReteNumberOfPages(){
        Article.ArticleBuilder builder = Article.builder();

        return builder.articleId(new ArticleId("inria-00280938"))
                .title(new Title("Production Systems and Rete Algorithm Formalisation"))
                .content(new Content("""
                        The rete algorithm is a well-known algorithm for efficiently addressing the many
                        patterns/many objects match problem, and it has been widely used and imple-
                        mented in several applications, mainly production systems
                        """))
                .author(AuthorsFixture.authorHoratiuCirstea())
                .numberOfPages(21)
                .build();
    }
}
