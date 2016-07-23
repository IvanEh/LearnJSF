package com.gmail.at.ivanehreshi;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloWorld", eager = true)
public class HelloWorld {
    // counter will never reach above 2
    // because the bean instantiated every time the page is requested
    int counter = 1;

    public HelloWorld() {
        System.out.println("HelloWorld started!");
    }

    public String getMessage() {
        return "Hello World! Counter = " + counter++;
    }

    public String action() {
        return "empty";
    }
}
