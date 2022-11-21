package fooddeliveryjh.infra;
import fooddeliveryjh.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@RestController
// @RequestMapping(value="/evaluations")
@Transactional
public class EvaluationController {
    @Autowired
    EvaluationRepository evaluationRepository;



    @RequestMapping(value = "evaluations/{id}/givescore",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Evaluation giveScore(@PathVariable(value = "id") Integer id, @RequestBody GiveScoreCommand giveScoreCommand, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /evaluation/giveScore  called #####");
            Optional<Evaluation> optionalEvaluation = evaluationRepository.findById(id);
            
            optionalEvaluation.orElseThrow(()-> new Exception("No Entity Found"));
            Evaluation evaluation = optionalEvaluation.get();
            evaluation.giveScore(giveScoreCommand);
            
            evaluationRepository.save(evaluation);
            return evaluation;
            
    }
    



}
