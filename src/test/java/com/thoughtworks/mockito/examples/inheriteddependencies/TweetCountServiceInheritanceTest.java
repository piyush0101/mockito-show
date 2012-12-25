package com.thoughtworks.mockito.examples.inheriteddependencies;

import com.thoughtworks.mockito.examples.Tweet;
import org.junit.Test;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TweetCountServiceInheritanceTest {

    @Test
    public void shouldReturnZeroTweetsForAUserWithNoTweets() {
        TweetDownloaderHelper downloadHelper = mock(TweetDownloaderHelper.class);
        TweetCountService tweetCountService = new TweetCountService(downloadHelper);

        Tweet tweet1 = new Tweet("piyush", "mockito is awesome!");
        Tweet tweet2 = new Tweet("piyush", "coding is my favorite stress buster!");
        Tweet tweet3 = new Tweet("kate", "i love spying with mockito)");

        when(downloadHelper.downloadTweets()).thenReturn(asList(tweet1, tweet2, tweet3));

        int numberOfTweets = tweetCountService.countTweetsFrom("cece");

        assertEquals(0, numberOfTweets);
    }

    @Test
    public void shouldReturnOneTweetForAUserWithASingleTweet() {
        TweetDownloaderHelper downloadHelper = mock(TweetDownloaderHelper.class);
        Tweet tweet1 = new Tweet("piyush", "mockito is awesome!");
        Tweet tweet3 = new Tweet("kate", "i love spying with mockito)");

        when(downloadHelper.downloadTweets()).thenReturn(asList(tweet1, tweet3));

        TweetCountService tweetCountService = new TweetCountService(downloadHelper);

        int numberOfTweets = tweetCountService.countTweetsFrom("piyush");

        assertEquals(1, numberOfTweets);
    }

    @Test
    public void shouldReturnMultipleTweetsForAPersonWithMultipleTweets() {
        TweetDownloaderHelper downloadHelper = mock(TweetDownloaderHelper.class);
        Tweet tweet1 = new Tweet("piyush", "mockito is awesome!");
        Tweet tweet2 = new Tweet("piyush", "coding is my favorite stress buster");
        Tweet tweet3 = new Tweet("kate", "i love spying with mockito)");

        when(downloadHelper.downloadTweets()).thenReturn(asList(tweet1, tweet2, tweet3));

        TweetCountService tweetCountService = new TweetCountService(downloadHelper);

        int numberOfTweets = tweetCountService.countTweetsFrom("piyush");

        assertEquals(2, numberOfTweets);
    }
}
