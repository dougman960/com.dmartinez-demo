package com.dmartinez.controller;



import com.dmartinez.bussinessexception.BusinessException;
import com.dmartinez.models.dto.BasicResponseDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptions {

    private static final Logger logger = LogManager.getLogger(ControllerExceptions.class);

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<BasicResponseDTO> handleDataAccessException(DataAccessException e) {
        logger.error(e.getMostSpecificCause().getMessage());
        BasicResponseDTO response = new BasicResponseDTO("Error when making requests to the database");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BasicResponseDTO> exception(BusinessException ex) {
        BasicResponseDTO basicResponseDto = new BasicResponseDTO();
        logger.error(ex.getMessage());
        basicResponseDto.setResponse(ex.getMessage());
        return new ResponseEntity<>(basicResponseDto, HttpStatus.NOT_FOUND);
    }

}
