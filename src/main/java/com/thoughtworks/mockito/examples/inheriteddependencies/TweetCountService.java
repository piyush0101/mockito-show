package com.thoughtworks.mockito.examples.inheriteddependencies;

import com.thoughtworks.mockito.examples.Tweet;

public class TweetCountService extends AbstractTweetService {

    private TweetDownloaderHelper helper;

    public TweetCountService(TweetDownloaderHelper downloaderHelper) {
        super(downloaderHelper);
    }

    public TweetCountService() {
        super(new TweetDownloaderHelper());
    }

    public int countTweetsFrom(String user) {
        int numberOfTweets = 0;
        for (Tweet tweet : tweets) {
           if (tweet.getUser().equals(user)) {
               numberOfTweets++;
           }
        }
        return numberOfTweets;
    }
}
