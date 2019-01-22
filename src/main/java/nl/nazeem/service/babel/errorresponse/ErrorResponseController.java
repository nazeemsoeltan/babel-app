package nl.nazeem.service.babel.errorresponse;

import nl.nazeem.service.babel.message.EmptyMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorResponseController {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception exception) {
        return new ErrorResponse("Unable to handle request", exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmptyMessageException.class)
    public ErrorResponse handleEmptyMessageException(Exception exception) {
        return new ErrorResponse("Provided message is empty", exception.getMessage());
    }

}
