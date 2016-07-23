package com.gmail.at.ivanehreshi;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloWorld", eager = true)
public class HelloWorld {
    // counter will never reach above 2
    // because the bean instantiated every time the page is requested
    int counter = 1;
    String magic;

    public HelloWorld() {
        System.out.println("HelloWorld started!");
    }

    public String getMessage() {
        return "Hello World! Counter = " + counter++;
    }

    // although you will be redirected to another page on the server
    // but the url will be the same
    public String action() {
        return "receiver";
    }

    public String getMagic() {
        return magic;
    }

    public void setMagic(String magic) {
        this.magic = magic;
    }
}
