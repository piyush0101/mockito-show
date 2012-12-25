package com.thoughtworks.mockito.examples.thinairdependencies;

import com.thoughtworks.mockito.examples.Tweet;
import com.thoughtworks.mockito.examples.TweetDownloader;
import com.thoughtworks.mockito.examples.TweetPersister;
import org.junit.Test;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TweetCountServiceTestThinAir {

    @Test
    public void shouldReturnZeroTweetsForAPersonWithoutAnyTweets() {
        TweetCountService tweetCountService = spy(new TweetCountService());
        TweetDownloader downloader = mock(TweetDownloader.class);
        TweetPersister persister = mock(TweetPersister.class);

        Tweet tweet1 = new Tweet("piyush", "mockito is awesome!");
        Tweet tweet2 = new Tweet("kate", "i love spying with mockito ;)");

        doReturn(downloader).when(tweetCountService).createTweetDownloader();
        doReturn(persister).when(tweetCountService).createTweetPersister();

        when(downloader.downloadData()).thenReturn(asList(tweet1, tweet2));

        int numberOfTweets = tweetCountService.countTweetsFrom("cece");

        assertEquals(0, numberOfTweets);
    }

    @Test
    public void shouldReturnASingleTweetForAUserWithASingleTweet() {
        TweetCountService tweetCountService = spy(new TweetCountService());
        TweetDownloader downloader = mock(TweetDownloader.class);
        TweetPersister persister = mock(TweetPersister.class);

        Tweet tweet1 = new Tweet("piyush", "mockito is awesome!");
        Tweet tweet2 = new Tweet("kate", "i love spying with mockito)");

        doReturn(downloader).when(tweetCountService).createTweetDownloader();
        doReturn(persister).when(tweetCountService).createTweetPersister();

        when(downloader.downloadData()).thenReturn(asList(tweet1, tweet2));

        int numberOfTweets = tweetCountService.countTweetsFrom("piyush");

        assertEquals(1, numberOfTweets);
    }

    @Test
    public void shouldReturnMultipleTweetsForAUserWithMultipleTweets() {
        TweetCountService tweetCountService = spy(new TweetCountService());
        TweetDownloader downloader = mock(TweetDownloader.class);
        TweetPersister persister = mock(TweetPersister.class);

        Tweet tweet1 = new Tweet("piyush", "mockito is awesome!");
        Tweet tweet2 = new Tweet("piyush", "coding is my favorite stress buster!");
        Tweet tweet3 = new Tweet("kate", "i love spying with mockito)");

        doReturn(downloader).when(tweetCountService).createTweetDownloader();
        doReturn(persister).when(tweetCountService).createTweetPersister();

        when(downloader.downloadData()).thenReturn(asList(tweet1, tweet2, tweet3));

        int numberOfTweets = tweetCountService.countTweetsFrom("piyush");

        assertEquals(2, numberOfTweets);
    }
}
