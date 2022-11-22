package fooddeliveryjh.domain;

import fooddeliveryjh.domain.*;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="orders", path="orders")
public interface OrderRepository extends PagingAndSortingRepository<Order, Long>{
    Optional<Order> findById(Long orderid);
    Optional<Order> findByOrderId(Long OrderId);
}
