package tw.com.mitake.request;

import com.google.gson.annotations.SerializedName;

public class PostTimelineEventRequest extends BaseRequest {
    @SerializedName("data")
    private RequestData requestData = new RequestData();

    @Override
    public QmiUrl getQmiUrl() {
        return QmiUrl.POST_TIMELINE_EVENT;
    }

    @Override
    public Data getData() {
        return requestData;
    }

    public static class RequestData extends Data {
        private String message;

        @SerializedName("event_type")
        private String eventType;

        public String getMessage() {
            return message;
        }

        public RequestData setMessage(String message) {
            this.message = message;

            return this;
        }

        public String getEventType() {
            return eventType;
        }

        public RequestData setEventType(String eventType) {
            this.eventType = eventType;

            return this;
        }
    }
}