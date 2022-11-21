package fooddeliveryjh.infra;
import fooddeliveryjh.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class EvaluationHateoasProcessor implements RepresentationModelProcessor<EntityModel<Evaluation>>  {

    @Override
    public EntityModel<Evaluation> process(EntityModel<Evaluation> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/givescore").withRel("givescore"));

        
        return model;
    }
    
}
