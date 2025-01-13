import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;

//Kafka producer implementation
public class SampleProducer {
    public SampleProducer(){

        Properties properties = new Properties();

        /*kafka server up and running as the kafka broker*/
        properties.put("bootstrap.servers", "localhost:9092");
        /*serialization will convert the produced request into a stream*/
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        /*Producer's request data will accept as records from the kafka server for a given topic*/
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("channel", "name", "selftuts");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);

        kafkaProducer.send(producerRecord);
        kafkaProducer.close();

    }
}
