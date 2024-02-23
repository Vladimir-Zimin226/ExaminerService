package pro.sky.java.examinerservice.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.examinerservice.repository.Question;
import pro.sky.java.examinerservice.repository.QuestionRepository;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service("mathService")
public class MathQuestionServiceImpl implements QuestionService {

    private final Random random = new Random();

    private final QuestionRepository questionRepository;

    public MathQuestionServiceImpl(@Qualifier("mathRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
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
        return Set.copyOf(questionRepository.getAll());
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questionList = List.copyOf(questionRepository.getAll());
        return questionList.get(random.nextInt(questionList.size()));
    }

    @Override
    public int getSize() {
        return questionRepository.getAll().size();
    }
}
