package fooddelivertest.external;

import lombok.Data;
import java.util.Date;
@Data
public class StoreOrder {

    private Long id;
    private Long foodId;
    private Long orderId;
    private String status;
}


