package pro.sky.java.examinerservice.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.examinerservice.repository.Question;
import pro.sky.java.examinerservice.services.ExaminerServiceImpl;
import pro.sky.java.examinerservice.services.QuestionService;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static pro.sky.java.examinerservice.tests.Constants.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    private final QuestionService javaServiceMock = Mockito.mock(QuestionService.class);

    private final QuestionService mathServiceMock = Mockito.mock(QuestionService.class);

    private final ExaminerServiceImpl out = new ExaminerServiceImpl(javaServiceMock, mathServiceMock);

    @Test
    public void qetRandomQuestionTest() {
        when(javaServiceMock.getRandomQuestion()).thenReturn(new Question(QUESTION1, ANSWER1), new Question(QUESTION2, ANSWER2));

        when(mathServiceMock.getRandomQuestion()).thenReturn(new Question(QUESTION3, ANSWER3), new Question(QUESTION4, ANSWER4));

        when(javaServiceMock.getSize()).thenReturn(2);
        when(mathServiceMock.getSize()).thenReturn(2);

        Random randomMock = mock(Random.class);

        when(randomMock.nextInt(anyInt())).thenReturn(0, 1, 1, 0);

        out.setRandom(randomMock);

        Collection<Question> actual = out.qetQuestions(4);

        List<Question> expected = List.of(
                new Question(QUESTION1, ANSWER1),
                new Question(QUESTION3, ANSWER3),
                new Question(QUESTION4, ANSWER4),
                new Question(QUESTION2, ANSWER2));
        Assertions.assertIterableEquals(expected, actual);
    }
}
