package pro.sky.java.examinerservice.repository;

import java.util.Collection;

public interface QuestionRepository {

    boolean add(Question question);

    boolean remove(Question question);

    Collection<Question> getAll();
}
