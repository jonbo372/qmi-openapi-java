package tw.com.mitake.response;

import com.google.gson.annotations.SerializedName;
import tw.com.mitake.response.GetTimelineEventsResponse.GetTimelineEventsResponseResponse.GetTimelineEventsResponseData.GetTimelineEventsResponseEvent;

import java.util.List;

public class GetTimelineEventsResponse extends BaseResponse {
    private GetTimelineEventsResponseResponse response;

    public List<GetTimelineEventsResponseEvent> getEvents() {
        return response.data.events;
    }

    public static class GetTimelineEventsResponseResponse {
        private GetTimelineEventsResponseData data;

        public static class GetTimelineEventsResponseData {
            private List<GetTimelineEventsResponseEvent> events;

            public static class GetTimelineEventsResponseEvent {
                private String message;

                @SerializedName("event_id")
                private String eventId;

                @SerializedName("event_type")
                private String eventType;

                @SerializedName("created_time")
                private long createdTime;

                public String getMessage() {
                    return message;
                }

                public String getEventId() {
                    return eventId;
                }

                public String getEventType() {
                    return eventType;
                }

                public long getCreatedTime() {
                    return createdTime;
                }
            }
        }
    }
}