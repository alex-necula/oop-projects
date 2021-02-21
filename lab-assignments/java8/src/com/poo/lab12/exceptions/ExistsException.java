package com.poo.lab12.exceptions;

import java.io.Serial;

public class ExistsException extends Exception {

    @Serial
    private static final long serialVersionUID = -8368249553360028667L;

    public ExistsException(String message) {
        super(message);
    }

}
