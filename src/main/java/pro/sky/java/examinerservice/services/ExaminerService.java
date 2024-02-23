package pro.sky.java.examinerservice.services;

import pro.sky.java.examinerservice.repository.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> qetQuestions(int amount);
}
