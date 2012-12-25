package com.thoughtworks.mockito.examples.thinairdependencies;

import com.thoughtworks.mockito.examples.Tweet;
import com.thoughtworks.mockito.examples.TweetDownloader;
import com.thoughtworks.mockito.examples.TweetPersister;
import com.thoughtworks.mockito.examples.inversionofcontrol.*;
import com.thoughtworks.mockito.examples.thinairdependencies.TweetCountService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class TweetCountServiceTestThinAir {

    @BeforeClass
    public void runBeforeClass() {

    }

    @Before
    public void runBeforeEveryTest() {

    }


    @Test
    public void shouldReturnZeroTweetsForAPersonWithoutAnyTweets() {
        TweetCountService tweetCountService = spy(new TweetCountService());
        TweetDownloader downloader = mock(TweetDownloader.class);
        TweetPersister persister = mock(TweetPersister.class);

        Tweet tweet1 = new Tweet("piyush", "mockito is awesome!");
        Tweet tweet2 = new Tweet("kate", "i love spying with mockito ;)");

        doReturn(downloader).when(tweetCountService).createTweetDownloader();
        doReturn(persister).when(tweetCountService).createTweetPersister();

        com.thoughtworks.mockito.examples.inversionofcontrol.TweetCountService service = new com.thoughtworks.mockito.examples.inversionofcontrol.TweetCountService(downloader, persister);
        int numberOfTweets = service.countTweetsFrom("cece");

        assertEquals(0, numberOfTweets);
    }
}
