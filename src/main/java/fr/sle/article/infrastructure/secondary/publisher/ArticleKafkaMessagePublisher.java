package fr.sle.article.infrastructure.secondary.publisher;

import fr.sle.article.common.domain.Article;
import fr.sle.article.common.domain.port.ArticlePublisher;
import fr.sle.article.infrastructure.secondary.publisher.model.ArticlePublishedMessage;
import fr.sle.article.infrastructure.secondary.publisher.model.ArticlePublishedMessageAuthor;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static fr.sle.article.infrastructure.secondary.publisher.PublisherConfiguration.KAFKA_ARTICLE_PUBLISHER_QUALIFIER;

@Component
public class ArticleKafkaMessagePublisher implements ArticlePublisher {

    private final Producer<byte[],byte[]> producer;

    private final String topic;

    public ArticleKafkaMessagePublisher(@Qualifier(KAFKA_ARTICLE_PUBLISHER_QUALIFIER)
    Producer<byte[],byte[]> producer,
        @Value("article.out.topic") String topic){
        this.producer = producer;
        this.topic = topic;
    }

    @Override
    public void publishArticleCreation(Article article) {

        ArticlePublishedMessageAuthor authorMessage = ArticlePublishedMessageAuthor.newBuilder()
                .setId(article.author().id().value())
                .setName(article.author().name().value())
                .build();

        ArticlePublishedMessage articlePublishedMessage = ArticlePublishedMessage.newBuilder()
                .setAuthor(authorMessage)
                .setId(article.id().value())
                .setTitle(article.title().value())
                .setContent(article.content().value()).build();

        final ProducerRecord<byte[], byte[]> objectProducerRecord;
        try {
            objectProducerRecord = new ProducerRecord<>(topic, null, articlePublishedMessage.toByteBuffer().array());
        } catch (IOException e) {
            //dirty
            throw new RuntimeException(e);
        }
        producer.send(objectProducerRecord);
    }
}
