package com.thoughtworks.mockito.examples.staticdependencies;

import com.thoughtworks.mockito.examples.Tweet;

import java.util.List;

public class TweetCountService {

    private TweetDownloaderWrapper wrapper;

    public TweetCountService(TweetDownloaderWrapper wrapper) {
        this.wrapper = wrapper;
    }

    public int countTweetsFrom(String user) {
        List<Tweet> tweets = wrapper.downloadTweets();
        int numberOfTweets = 0;
        for (Tweet tweet : tweets) {
            if (tweet.getUser().equals(user)) {
                numberOfTweets++;
            }
        }
        TweetPersister.persistTweets(user, numberOfTweets);
        return numberOfTweets;
    }

    private class TweetDownloaderWrapper {
        public List<Tweet> downloadTweets() {
            return TweetDownloader.downloadTweets();
        }
    }
}
