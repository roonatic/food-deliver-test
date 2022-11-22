package fooddelivertest.infra;
import fooddelivertest.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class PayHistoryHateoasProcessor implements RepresentationModelProcessor<EntityModel<PayHistory>>  {

    @Override
    public EntityModel<PayHistory> process(EntityModel<PayHistory> model) {

        
        return model;
    }
    
}
