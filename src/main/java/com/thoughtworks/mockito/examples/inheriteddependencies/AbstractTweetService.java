package com.thoughtworks.mockito.examples.inheriteddependencies;

import com.thoughtworks.mockito.examples.Tweet;

import java.util.List;

public class AbstractTweetService {

    protected List<Tweet> tweets;

    public AbstractTweetService() {
       tweets = TweetDownloader.downloadTweets();
    }

    public void persistTweets(String user, int numberOfTweets) {
        TweetPersister.persistTweets();
    }

}
