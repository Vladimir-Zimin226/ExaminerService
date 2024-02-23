package pro.sky.java.examinerservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidQuestionRequestException extends RuntimeException {
    public InvalidQuestionRequestException(int amount, int size) {
super(String.format("Requested amount %d more then current size %d ", amount, size));
    }
}
