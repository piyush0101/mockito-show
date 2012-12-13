package com.thoughtworks.mockito.examples.inversionofcontrol;

import com.thoughtworks.mockito.examples.Tweet;
import com.thoughtworks.mockito.examples.TweetDownloader;
import com.thoughtworks.mockito.examples.TweetPersister;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class TweetCountServiceTest {

    @Test
    public void shouldCountZeroTweetsForAUserWhichDoesNotHaveAnyTweets() {
        TweetDownloader downloader = mock(TweetDownloader.class);
        TweetPersister persister = mock(TweetPersister.class);

        Tweet tweet1 = new Tweet("piyush", "mockito is awesome!");
        Tweet tweet2 = new Tweet("kate", "i love spying with mockito ;)");

        doReturn(Arrays.asList(tweet1, tweet2)).when(downloader).downloadData();
        doNothing().when(persister).persistToDB();

        TweetCountService service = new TweetCountService(downloader, persister);
        int numberOfTweets = service.countTweetsFrom("cece");

        assertEquals(0, numberOfTweets);
    }

    @Test
    public void shouldCountOneTweetFromAUserWhoHasOneTweet() {
        TweetDownloader downloader = mock(TweetDownloader.class);
        TweetPersister persister = mock(TweetPersister.class);

        Tweet tweet1 = new Tweet("piyush", "mockito is awesome!");
        Tweet tweet2 = new Tweet("kate", "i love spying with mockito ;)");

        doReturn(Arrays.asList(tweet1, tweet2)).when(downloader).downloadData();
        doNothing().when(persister).persistToDB();

        TweetCountService service = new TweetCountService(downloader, persister);
        int numberOfTweets = service.countTweetsFrom("piyush");

        assertEquals(1, numberOfTweets);
    }

    @Test
    public void shouldCountMultipleTweetsFromAUserWhoHasMultipleTweets() {
        TweetDownloader downloader = mock(TweetDownloader.class);
        TweetPersister persister = mock(TweetPersister.class);

        Tweet tweet1 = new Tweet("piyush", "i prefer regular mockito!");
        Tweet tweet2 = new Tweet("kate", "i love spying with mockito ;)");
        Tweet tweet3 = new Tweet("kate", "its fun ;)");

        doReturn(Arrays.asList(tweet1, tweet2, tweet3)).when(downloader).downloadData();
        doNothing().when(persister).persistToDB();

        TweetCountService service = new TweetCountService(downloader, persister);
        int numberOfTweets = service.countTweetsFrom("kate");

        assertEquals(2, numberOfTweets);
    }
}
