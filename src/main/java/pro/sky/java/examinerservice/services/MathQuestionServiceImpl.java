package pro.sky.java.examinerservice.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
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
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Adding questions is not allowed for math questions");
    }

    @Override
    public boolean add(Question question) {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Adding questions is not allowed for math questions");
    }

    @Override
    public boolean remove(String question, String answer) {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Removing questions is not allowed for math questions");
    }

    @Override
    public Collection<Question> getAll() {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Getting all questions is not allowed for math questions");
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
