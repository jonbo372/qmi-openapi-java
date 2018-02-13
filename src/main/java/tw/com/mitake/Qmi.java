package tw.com.mitake;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tw.com.mitake.request.GetTimelineEventsRequest;
import tw.com.mitake.request.PostChatroomEventRequest;
import tw.com.mitake.request.PostTimelineEventRequest;
import tw.com.mitake.response.GetTimelineEventsResponse;
import tw.com.mitake.response.PostChatroomEventResponse;
import tw.com.mitake.response.PostTimelineEventResponse;

import java.util.Arrays;

public class Qmi {
    private static final Logger LOG = LoggerFactory.getLogger(Qmi.class);
    private static final String FORMAT_URL = "%s/v2/open/%%s";

    public static String baseUrl;

    private static String token;
    private static boolean init;
    private static Qmi instance;
    private static QmiSender sender;

    private Qmi() {
    }

    public static Qmi init(String token) {
        return init(token, "https://ap.qmi.emome.net");
    }

    public static Qmi init(String token, String baseUrl) {
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

            Qmi.baseUrl = String.format(FORMAT_URL, baseUrl);
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

    public GetTimelineEventsResponse getEventsFromTimeline() {
        return (GetTimelineEventsResponse) sender.send(new GetTimelineEventsRequest(), GetTimelineEventsResponse.class);
    }

    public PostChatroomEventResponse postToChatroom(String message, String... users) {
        PostChatroomEventRequest request = new PostChatroomEventRequest();

        ((PostChatroomEventRequest.RequestData) request.getData()).getMessage().setContent(message);
        ((PostChatroomEventRequest.RequestData) request.getData()).getMessage().setType("text");
        ((PostChatroomEventRequest.RequestData) request.getData()).getUsers().addAll(Arrays.asList(users));

        return postToChatroom(request);
    }

    private PostChatroomEventResponse postToChatroom(PostChatroomEventRequest request) {
        return (PostChatroomEventResponse) sender.send(request, PostChatroomEventResponse.class);
    }
}
