package fooddeliveryjh.domain;

import fooddeliveryjh.domain.*;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="storeOrders", path="storeOrders")
public interface StoreOrderRepository extends PagingAndSortingRepository<StoreOrder, Long>{
    Optional<StoreOrder> findByOrderId(Long orderid);
    Optional<StoreOrder> findById(Long orderid);
}
