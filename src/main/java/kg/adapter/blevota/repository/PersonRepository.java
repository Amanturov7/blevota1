package kg.adapter.blevota.repository;

import kg.adapter.blevota.document.Sensor;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PersonRepository extends ElasticsearchRepository<Sensor, String> {
}
