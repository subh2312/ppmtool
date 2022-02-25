package com.subhankar.Domain;

import lombok.Data;

@Data
public class Errors {
    private int errorCode;
    private String message;
    private String fieldName;
}
