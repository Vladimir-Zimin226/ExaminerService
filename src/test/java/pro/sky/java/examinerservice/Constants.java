package pro.sky.java.examinerservice;

import pro.sky.java.examinerservice.repository.Question;

import java.util.Set;

public class Constants {

    public static final String QUESTION1 = "Какие типы переменных есть в Java?";
    public static final String QUESTION2 = "Что такое инкапсуляция?";
    public static final String QUESTION3 = "Что такое массив?";
    public static final String ANSWER1 = "int, String, float, double etc.";
    public static final String ANSWER2 = "Ограничение функционала программы для пользователя в зависимости от его потребностей";
    public static final String ANSWER3 = "Конструкция, хранящая в себе несколько элементов";

    public static final Question FULL_QUESTION1 = new Question(QUESTION1, ANSWER1);
    public static final Question FULL_QUESTION2 = new Question(QUESTION2, ANSWER2);
    public static final Question FULL_QUESTION3 = new Question(QUESTION3, ANSWER3);

    public static final Set<Question> TEST_QUESTIONS_SET_1 = Set.of(FULL_QUESTION1, FULL_QUESTION2, FULL_QUESTION3);
    public static final Set<Question> TEST_QUESTIONS_SET_2 = Set.of(FULL_QUESTION1);

    public static final String EMPTY_ANSWER = null;
}
