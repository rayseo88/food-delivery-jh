package fooddeliveryjh.infra;
import fooddeliveryjh.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class DeliveryHateoasProcessor implements RepresentationModelProcessor<EntityModel<Delivery>>  {

    @Override
    public EntityModel<Delivery> process(EntityModel<Delivery> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/accept").withRel("accept"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/deliveryConfirm").withRel("deliveryConfirm"));

        
        return model;
    }
    
}
