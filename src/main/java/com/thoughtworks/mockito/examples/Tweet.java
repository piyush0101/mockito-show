package com.thoughtworks.mockito.examples;

public class Tweet {

    private String user;
    private String text;

    public Tweet(String user, String tweet) {
        this.user = user;
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

}
