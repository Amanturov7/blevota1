package kg.adapter.blevota.repository;

import kg.adapter.blevota.document.Hydropost;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface HydropostRepository  extends ElasticsearchRepository<Hydropost, String>{

}


