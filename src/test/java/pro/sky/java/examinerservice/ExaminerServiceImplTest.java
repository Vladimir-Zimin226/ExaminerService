package pro.sky.java.examinerservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.examinerservice.services.ExaminerService;
import pro.sky.java.examinerservice.services.ExaminerServiceImpl;
import pro.sky.java.examinerservice.services.QuestionService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static pro.sky.java.examinerservice.Constants.FULL_QUESTION1;
import static pro.sky.java.examinerservice.Constants.TEST_QUESTIONS_SET_2;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    QuestionService mock;

    @InjectMocks
    ExaminerServiceImpl out;

    @Test
    public void qetQuestionTest() {
        when(mock.getSize()).thenReturn(1);
        when(mock.getRandomQuestion()).thenReturn(FULL_QUESTION1);
        assertEquals(TEST_QUESTIONS_SET_2, out.qetQuestions(1));
    }

}
