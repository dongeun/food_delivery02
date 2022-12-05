package mallkde.domain;

import mallkde.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="checkOederAdresses", path="checkOederAdresses")
public interface CheckOederAdressRepository extends PagingAndSortingRepository<CheckOederAdress, Long>{

}
