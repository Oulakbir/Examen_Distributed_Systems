package ma.enset.commercantservice.Service;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.StreamListener;
import org.springframework.kafka.streams.StreamsBuilderFactoryBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@EnableKafkaStreams
@Service
public class KafkaStreamsProcessor {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaStreamsProcessor(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @StreamListener(target = "transaction-topic")
    public void processTransactionStream(KStream<String, String> transactionsStream) {
        transactionsStream
                .filter((key, value) -> {
                    // Appliquez ici vos critères d'analytique (par exemple, filtrer les transactions par montant)
                    return value.contains("CREDIT");
                })
                .mapValues(value -> {
                    // Transformez les données ici
                    return value.toUpperCase(); // Exemple : mettre en majuscule
                })
                .to("processed-transactions-topic");  // Publier le résultat dans un autre topic
    }
}

