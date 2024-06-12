package br.com.api.products.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class ResponseModel {
    
    private String message;
}
