package fr.sle.article.secondary.publisher;

import fr.sle.article.UnitTest;
import fr.sle.article.common.domain.ArticlesFixture;
import fr.sle.article.infrastructure.secondary.publisher.ArticleKafkaMessagePublisher;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

@UnitTest
class ArticleKafkaMessagePublisherTest {

    @Test
    public void publishArticleCreation(){
        final KafkaProducer kafkaProducer = Mockito.mock(KafkaProducer.class);

        final ArticleKafkaMessagePublisher articleKafkaMessagePublisher = new ArticleKafkaMessagePublisher(kafkaProducer, "topic-test");

        articleKafkaMessagePublisher.publishArticleCreation(ArticlesFixture.articleReteNumberOfPages());

        ArgumentCaptor<ProducerRecord> argumentCaptor = ArgumentCaptor.forClass(ProducerRecord.class);

        Mockito.verify(kafkaProducer).send(argumentCaptor.capture());

        Assertions.assertEquals("topic-test", argumentCaptor.getValue().topic());
        //some other assertions
    }

}
