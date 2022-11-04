package fr.sle.article.infrastructure.primary.api;

import com.fasterxml.jackson.annotation.JsonGetter;
import fr.sle.article.common.domain.ArticleId;

import java.util.Objects;

class ArticleIdResponse {
    private String id;

    private ArticleIdResponse(String id) {
        this.id = id;
    }

    public static ArticleIdResponse of(ArticleId articleId){
        return new ArticleIdResponse(articleId.value());
    }

    @JsonGetter
    public String id() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleIdResponse that = (ArticleIdResponse) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ArticleIdResponse{" +
            "id='" + id + '\'' +
            '}';
    }
}
