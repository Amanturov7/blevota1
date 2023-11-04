package kg.adapter.blevota.repository;

import kg.adapter.blevota.document.WaterHydropost;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface WaterHydropostRepository extends ElasticsearchRepository<WaterHydropost, String> {
}
