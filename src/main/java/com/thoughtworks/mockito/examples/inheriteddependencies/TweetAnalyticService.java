package com.thoughtworks.mockito.examples.inheriteddependencies;

import com.thoughtworks.mockito.examples.Tweet;

public class TweetAnalyticService extends AbstractTweetService {

    public TweetAnalyticService(TweetDownloaderHelper downloadHelper) {
       super(downloadHelper);
    }

    public void doSentimentAnalysis(String user) {
        for (Tweet tweet : tweets) {
           // logic for analyzing sentiments of a user from her tweets
        }
    }

}
