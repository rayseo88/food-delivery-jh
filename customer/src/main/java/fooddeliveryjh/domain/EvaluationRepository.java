package fooddeliveryjh.domain;

import fooddeliveryjh.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="evaluations", path="evaluations")
public interface EvaluationRepository extends PagingAndSortingRepository<Evaluation, Integer>{

}
