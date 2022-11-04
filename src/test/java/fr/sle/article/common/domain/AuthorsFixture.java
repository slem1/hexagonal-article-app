package fr.sle.article.common.domain;

public class AuthorsFixture {

    private AuthorsFixture(){

    }

    public static Author authorHoratiuCirstea(){
        Author.AuthorBuilder builder = Author.builder();
        return builder
                .authorId(new AuthorId("HoratiuCirstea,"))
                .authorName(new PersonName("Horatiu Cirstea"))
                .build();
    }
}
