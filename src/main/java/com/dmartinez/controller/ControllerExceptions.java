package com.dmartinez.controller;



import com.dmartinez.bussinessexception.BusinessException;
import com.dmartinez.models.dto.BasicResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptions {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<BasicResponseDTO> exception(BusinessException ex) {
        BasicResponseDTO basicResponseDto = new BasicResponseDTO();
        basicResponseDto.setResponse(ex.getMessage().trim());
        return new ResponseEntity<>(basicResponseDto, ex.getStatus());
    }

}
