package tw.com.mitake;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.com.mitake.response.PostTimelineEventResponse;

public class QmiTest {
    private Qmi qmi;

    @Before
    public void setup() {
        qmi = Qmi.init(System.getenv("QMI_TOKEN"));
    }

    @Test
    public void testPostToTimeline() {
        PostTimelineEventResponse response = qmi.postToTimeline("Hello World from Qmi OpenAPI for Java library");

        Assert.assertNotNull(response.getEventId());
    }
}