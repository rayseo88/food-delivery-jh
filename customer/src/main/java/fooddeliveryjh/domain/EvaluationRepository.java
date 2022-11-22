package fooddeliveryjh.domain;

import fooddeliveryjh.domain.*;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="evaluations", path="evaluations")
public interface EvaluationRepository extends PagingAndSortingRepository<Evaluation, Integer>{
    Optional<Evaluation> findByOrderId(Long orderid);
}
