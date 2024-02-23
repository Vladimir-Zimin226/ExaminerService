package pro.sky.java.examinerservice.services;

import pro.sky.java.examinerservice.repository.Question;

import java.util.Collection;
import java.util.Set;

public interface QuestionService {

    boolean add(String question, String answer);

    boolean add(Question question);

    boolean remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();

    int getSize();

}
