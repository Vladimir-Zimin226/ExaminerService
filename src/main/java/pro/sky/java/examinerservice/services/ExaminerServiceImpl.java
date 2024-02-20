package pro.sky.java.examinerservice.services;

import org.slf4j.LoggerFactory;
import pro.sky.java.examinerservice.exceptions.InvalidQuestionRequestException;
import pro.sky.java.examinerservice.repository.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class ExaminerServiceImpl implements ExaminerService {

    QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> qetQuestions(int amount) {
        int size = questionService.getSize();
        if (amount <= 0 || size < amount) {
            throw new InvalidQuestionRequestException(amount, size);
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
