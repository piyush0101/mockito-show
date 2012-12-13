package com.thoughtworks.mockito.examples.inheriteddependencies;

import com.thoughtworks.mockito.examples.Tweet;

import java.util.ArrayList;
import java.util.List;

public class TweetDownloader {

    public static List<Tweet> downloadTweets() {
        // full implementation actually connects to twitter and downloads tweets
        return new ArrayList<Tweet>();
    }
}
