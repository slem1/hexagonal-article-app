package fr.sle.article.infrastructure.secondary.publisher.base;


import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.ByteArraySerializer;

import java.util.Properties;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

public class KafkaProducerFactory {

    private KafkaProducerFactory (){};

    public static KafkaProducer<byte[],byte[]> create(String bootstrapServers, String clientId,
                                                      String kafkaSslTruststoreLocation,
                                                      String kafkaSslTruststorePassword) {
        Properties props = new Properties();

        props.put(BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(KEY_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);
        props.put(VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);
        props.put(ACKS_CONFIG, "all");
        props.put(CLIENT_ID_CONFIG, clientId);

        props.setProperty(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, kafkaSslTruststoreLocation);
        props.setProperty(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, kafkaSslTruststorePassword);
        props.setProperty(SslConfigs.SSL_ENABLED_PROTOCOLS_CONFIG, "TLSv1.2");
        props.setProperty(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
        props.setProperty(SaslConfigs.SASL_MECHANISM, "PLAIN");

        return new KafkaProducer<>(props);
    }

    public static KafkaProducer<byte[],byte[]> create(String bootstrapServers, String clientId) {
        Properties props = new Properties();

        props.put(BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(KEY_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);
        props.put(VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);
        props.put(ACKS_CONFIG, "all");
        props.put(CLIENT_ID_CONFIG, clientId);
        return new KafkaProducer<>(props);
    }

}

