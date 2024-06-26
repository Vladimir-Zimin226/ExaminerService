package pro.sky.java.examinerservice.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.examinerservice.repository.Question;
import pro.sky.java.examinerservice.repository.QuestionRepository;

import java.util.*;

@Service("javaService")
public class JavaQuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public JavaQuestionServiceImpl(@Qualifier("javaRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    private Random random = new Random();

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public boolean add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public boolean add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public boolean remove(String question, String answer) {
        return questionRepository.remove(new Question(question, answer));
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        return List.copyOf(questionRepository.getAll()).get(random.nextInt(questionRepository.getAll().size()));
    }

    @Override
    public int getSize() {
        return questionRepository.getAll().size();
    }
}
