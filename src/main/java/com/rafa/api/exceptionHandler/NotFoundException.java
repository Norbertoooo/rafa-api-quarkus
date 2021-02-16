package com.rafa.api.exceptionHandler;

import java.io.Serializable;

public class NotFoundException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;

    public NotFoundException() {
        super();
    }
}
