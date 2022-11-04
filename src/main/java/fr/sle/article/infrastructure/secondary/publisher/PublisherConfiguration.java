package fr.sle.article.infrastructure.secondary.publisher;

import fr.sle.article.infrastructure.secondary.publisher.base.KafkaProducerFactory;
import org.apache.kafka.clients.producer.MockProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.common.serialization.Serdes;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublisherConfiguration {

    public static final String KAFKA_ARTICLE_PUBLISHER_QUALIFIER = "kafkaArticlePublisher";

    @ConditionalOnProperty(value = "enable.kafka", havingValue = "true")
    @Bean(KAFKA_ARTICLE_PUBLISHER_QUALIFIER)
    public Producer<byte[], byte[]> kafkaProducer() {
        return KafkaProducerFactory.create("localhost:9093", "article-publisher");
    }

    @ConditionalOnProperty(value = "enable.kafka", havingValue = "false")
    @Bean(KAFKA_ARTICLE_PUBLISHER_QUALIFIER)
    public Producer<byte[], byte[]> mockkafkaProducer() {
        return new MockProducer(true, Serdes.ByteArray().serializer(), Serdes.ByteArray().serializer());
    }


}
