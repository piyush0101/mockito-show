package com.thoughtworks.mockito.examples.inversionofcontrol;

import com.thoughtworks.mockito.examples.Tweet;
import com.thoughtworks.mockito.examples.TweetDownloader;
import com.thoughtworks.mockito.examples.TweetPersister;

import java.util.List;

public class TweetCountService {

    private final TweetDownloader downloader;
    private final TweetPersister persister;

    public TweetCountService(TweetDownloader downloader, TweetPersister persister) {
        this.downloader = downloader;
        this.persister = persister;
    }

    public int countTweetsFrom(String user) {
        List<Tweet> tweets = downloader.downloadData();
        int numberOfTweets = 0;
        for (Tweet tweet : tweets) {
            if (tweet.getUser().equals(user)) {
                numberOfTweets++;
            }
        }
        return numberOfTweets;
    }
}
