package com.thoughtworks.mockito.examples.staticdependencies;

import com.thoughtworks.mockito.examples.Tweet;

import java.util.ArrayList;
import java.util.List;

public class TweetDownloader {

    public static List<Tweet> downloadTweets() {
        return new ArrayList<Tweet>();
    }
}
