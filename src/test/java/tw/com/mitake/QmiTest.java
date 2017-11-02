package tw.com.mitake;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.com.mitake.response.PostChatroomEventResponse;
import tw.com.mitake.response.PostTimelineEventResponse;

public class QmiTest {
    private Qmi qmi;

    @Before
    public void setup() {
        qmi = Qmi.init(System.getenv("QMI_TOKEN"));
    }

    @Test
    public void testPostToTimeline() {
        PostTimelineEventResponse response = qmi.postToTimeline("Hello World");

        Assert.assertEquals("建立成功", response.getMessage());
        Assert.assertNotNull(response.getEventId());
    }

    @Test
    public void testPostToChatroom() {
        PostChatroomEventResponse response = qmi.postToChatroom("Hello World", "uuid1", "uuid2");

        Assert.assertEquals("建立成功", response.getMessage());
    }
}