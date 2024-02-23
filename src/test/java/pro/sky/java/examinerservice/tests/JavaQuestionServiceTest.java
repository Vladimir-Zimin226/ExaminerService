package pro.sky.java.examinerservice.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.examinerservice.repository.JavaQuestionRepository;
import pro.sky.java.examinerservice.repository.Question;
import pro.sky.java.examinerservice.services.JavaQuestionServiceImpl;

import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.java.examinerservice.tests.Constants.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    private JavaQuestionRepository repository;

    @InjectMocks
    private JavaQuestionServiceImpl out;

    @Test
    void shouldAddQuestion() {
        Question question = new Question(QUESTION1, ANSWER1);
        when(repository.add(question)).thenReturn(true, false);

        assertTrue(out.add(question));
        assertFalse(out.add(question));
    }

    @Test
    void shouldRemoveQuestion() {
        Question question = new Question(QUESTION1, ANSWER1);
        when(repository.remove(question)).thenReturn(true, false);

        assertTrue(out.remove(QUESTION1, ANSWER1));
        assertFalse(out.remove(QUESTION1, ANSWER1));
    }

    @Test
    void shouldGetAll() {
        Set<Question> questionSet = Set.of(
                new Question(QUESTION1, ANSWER1),
                new Question(QUESTION2, ANSWER2));
        when(repository.getAll()).thenReturn(questionSet);
        assertTrue(out.getAll().containsAll(questionSet));
    }

    @Test
    void shouldGetRandomQuestion() {
        Set<Question> questionSet = Set.of(
                new Question(QUESTION1, ANSWER1),
                new Question(QUESTION2, ANSWER2));
        when(repository.getAll()).thenReturn(questionSet);

        Random random = mock(Random.class, withSettings().withoutAnnotations());
        when(random.nextInt(anyInt())).thenReturn(0, 1);
        out.setRandom(random);


        assertEquals(new Question(QUESTION1, ANSWER1), out.getRandomQuestion());
        assertEquals(new Question(QUESTION2, ANSWER2), out.getRandomQuestion());
    }


}
