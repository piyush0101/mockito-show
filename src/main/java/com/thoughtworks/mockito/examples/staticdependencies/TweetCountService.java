package com.thoughtworks.mockito.examples.staticdependencies;

import com.thoughtworks.mockito.examples.Tweet;

import java.util.List;

public class TweetCountService {

    public int countTweetsFrom(String user) {
        List<Tweet> tweets = TweetDownloader.downloadTweets();
        int numberOfTweets = 0;
        for (Tweet tweet : tweets) {
            if (tweet.getUser().equals(user)) {
                numberOfTweets++;
            }
        }
        return numberOfTweets;
    }
}
