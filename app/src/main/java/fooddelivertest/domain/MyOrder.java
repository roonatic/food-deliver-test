package fooddelivertest.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="MyOrder_table")
@Data
public class MyOrder {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String status;
        private Long orderId;


}