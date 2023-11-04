package kg.adapter.blevota.repository;

import kg.adapter.blevota.document.WaterSystem;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface WaterSystemRepository  extends ElasticsearchRepository<WaterSystem, String> {
}
