package com.thoughtworks.mockito.examples.thinairdependencies;

import com.thoughtworks.mockito.examples.Tweet;
import com.thoughtworks.mockito.examples.TweetDownloader;
import com.thoughtworks.mockito.examples.TweetPersister;

import java.util.List;

public class TweetCountService {

    public int countTweetsFrom(String user) {
        TweetDownloader downloader = createTweetDownloader();
        TweetPersister persister = createTweetPersister();
        List<Tweet> tweets = downloader.downloadData();
        int numberOfTweets = 0;
        for (Tweet tweet : tweets) {
            if (tweet.getUser().equals(user)) {
                numberOfTweets++;
            }
        }
        persister.persistTweets(user, numberOfTweets);
        return numberOfTweets;
    }

    protected TweetPersister createTweetPersister() {
        return new TweetPersister();
    }

    protected TweetDownloader createTweetDownloader() {
        return new TweetDownloader();
    }
}
