package fooddeliveryjh.domain;

import fooddeliveryjh.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="notificationLogs", path="notificationLogs")
public interface NotificationLogRepository extends PagingAndSortingRepository<NotificationLog, Long>{

}
