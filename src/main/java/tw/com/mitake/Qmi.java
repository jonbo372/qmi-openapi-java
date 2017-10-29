package tw.com.mitake;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tw.com.mitake.request.PostTimelineEventRequest;
import tw.com.mitake.response.PostTimelineEventResponse;

public class Qmi {
    private static final Logger LOG = LoggerFactory.getLogger(Qmi.class);

    private static String token;
    private static boolean init;
    private static Qmi instance;
    private static QmiSender sender;

    private Qmi() {
    }

    public static Qmi init(String token) {
        if (init) {
            return instance;
        }

        if (StringUtils.isEmpty(token)) {
            init = false;

            throw new IllegalArgumentException("Please indicate token");
        }

        if (instance == null) {
            instance = new Qmi();
            sender = new QmiSender();
            Qmi.token = token;
        }

        init = true;

        return instance;
    }

    public static String getToken() {
        return token;
    }

    public PostTimelineEventResponse postToTimeline(String message) {
        PostTimelineEventRequest request = new PostTimelineEventRequest();

        ((PostTimelineEventRequest.RequestData) request.getData()).setMessage(message);
        ((PostTimelineEventRequest.RequestData) request.getData()).setEventType("post");

        return postToTimeline(request);
    }

    private PostTimelineEventResponse postToTimeline(PostTimelineEventRequest request) {
        return (PostTimelineEventResponse) sender.send(request, PostTimelineEventResponse.class);
    }
}
