package pro.sky.java.examinerservice.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
@Repository("javaRepository")
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> questions;

    public JavaQuestionRepository() {
        questions = new HashSet<>();
    }

    @PostConstruct
    public void init() {
        add(new Question("Является ли мап коллекцией?", " нет "));
        add(new Question("Сколько байт занимает int?", " 4 "));
        add(new Question("Когда создали Java?", " 1995 "));
        add(new Question("Через какой метод нужно сравнивать объекты?", " equals "));
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
