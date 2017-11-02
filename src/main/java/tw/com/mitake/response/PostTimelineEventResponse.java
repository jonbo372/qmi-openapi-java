package tw.com.mitake.response;

import com.google.gson.annotations.SerializedName;

public class PostTimelineEventResponse extends BaseResponse {
    private PostTimelineEventResponseResponse response;

    public String getEventId() {
        return response.data.eventId;
    }

    public static class PostTimelineEventResponseResponse {
        private PostTimelineEventResponseData data;

        public static class PostTimelineEventResponseData {
            @SerializedName("event_id")
            private String eventId;
        }
    }
}