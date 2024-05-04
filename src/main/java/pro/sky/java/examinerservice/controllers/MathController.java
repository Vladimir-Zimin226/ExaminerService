package pro.sky.java.examinerservice.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.examinerservice.repository.Question;
import pro.sky.java.examinerservice.services.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/math")
public class MathController {

    private final QuestionService questionService;

    public MathController(@Qualifier("mathService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public void addQuestion(@RequestParam String question, @RequestParam String answer) {
        questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public void removeQuestion(@RequestParam String question, @RequestParam String answer) {
        questionService.remove(question, answer);
    }

    @GetMapping("/find")
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
}
