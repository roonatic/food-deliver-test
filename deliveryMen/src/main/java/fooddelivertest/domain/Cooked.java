package fooddelivertest.domain;

import fooddelivertest.domain.*;
import fooddelivertest.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Cooked extends AbstractEvent {

    private Long id;
    private Long foodId;
    private Long orderId;
    private String status;





}
