package com.jieqing.exceptions;

import java.io.IOException;

public class Account {

    public void deposit(float value) throws IOException {
        if (value <= 0)
            // have the caller of the method to handle err
            throw new IllegalArgumentException();
    }


}
