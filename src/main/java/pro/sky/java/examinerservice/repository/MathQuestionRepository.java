package pro.sky.java.examinerservice.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository("mathRepository")
public class MathQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

    public MathQuestionRepository() {
        questions = new HashSet<>();
    }

    @PostConstruct
    public void init() {
        add(new Question("2 + 1", " 3 "));
        add(new Question("4 * 4", " 16 "));
        add(new Question("21 / 7", " 3 "));
    }

    public boolean add(Question question) {
        return questions.add(question);
    }
    public boolean remove(Question question) {
        return questions.remove(question);
    }
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }
}
