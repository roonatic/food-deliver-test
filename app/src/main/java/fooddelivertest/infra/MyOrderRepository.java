package fooddelivertest.infra;

import fooddelivertest.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="myOrders", path="myOrders")
public interface MyOrderRepository extends PagingAndSortingRepository<MyOrder, Long> {

    List<MyOrder> findByOrderId(Long orderId);


    void deleteByOrderId(Long orderId);

}
