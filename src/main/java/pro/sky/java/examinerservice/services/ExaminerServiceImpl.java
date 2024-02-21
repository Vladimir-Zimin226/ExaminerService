package pro.sky.java.examinerservice.services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.examinerservice.exceptions.InvalidQuestionRequestException;
import pro.sky.java.examinerservice.repository.Question;

import java.util.*;
import java.util.logging.Logger;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaServices;
    private final QuestionService mathServices;

    private Random random = new Random();

    public void setRandom(Random random) {
        this.random = random;
    }

    public ExaminerServiceImpl(@Qualifier("javaService") QuestionService javaServices, @Qualifier("mathService") QuestionService mathServices) {
        this.javaServices = javaServices;
        this.mathServices = mathServices;
    }

    @Override
    public Collection<Question> qetQuestions(int amount) {
        List<QuestionService> serviceList = List.of(javaServices, mathServices);

        int size = serviceList.stream().mapToInt(QuestionService::getSize).sum();
        if (amount <= 0 || size < amount) {
            throw new InvalidQuestionRequestException(amount, size);
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(serviceList.get(random.nextInt(serviceList.size())).getRandomQuestion());
        }
        return questions;
    }
}
