package ma.enset.commercantservice.Service;

import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Consumed;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.StreamListener;
import org.springframework.kafka.streams.StreamsBuilderFactoryBean;
import org.springframework.kafka.streams.KStreamBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@EnableKafkaStreams
@Service
public class KafkaStreamAnalyticsService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaStreamAnalyticsService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @StreamListener("transaction-topic")
    public void processTransactions(KStream<String, String> transactionsStream) {
        transactionsStream.foreach((key, value) -> {
            // Ici, vous pouvez ajouter la logique d'analytique (par exemple, calculer des sommes,
            // agréger des données, détecter des comportements anormaux, etc.)
            System.out.println("Transaction reçue : " + value);
        });
    }
}

