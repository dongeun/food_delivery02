package mallkde.domain;

import mallkde.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="deliveryOrderProcessings", path="deliveryOrderProcessings")
public interface DeliveryOrderProcessingRepository extends PagingAndSortingRepository<DeliveryOrderProcessing, Long>{

}
