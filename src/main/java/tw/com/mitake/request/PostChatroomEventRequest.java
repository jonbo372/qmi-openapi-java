package tw.com.mitake.request;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PostChatroomEventRequest extends BaseRequest {
    @SerializedName("data")
    private RequestData requestData = new RequestData();

    @Override
    public QmiUrl getQmiUrl() {
        return QmiUrl.POST_CHATROOM_EVENT;
    }

    @Override
    public Data getData() {
        return requestData;
    }

    public static class RequestData extends Data {
        private List<String> users = new ArrayList<String>();
        private Message message = new Message();

        public List<String> getUsers() {
            return users;
        }

        public RequestData setUsers(List<String> users) {
            this.users = users;

            return this;
        }

        public Message getMessage() {
            return message;
        }

        public RequestData setMessage(Message message) {
            this.message = message;

            return this;
        }

        public static class Message {
            private String type;
            private String content;

            public String getType() {
                return type;
            }

            public Message setType(String type) {
                this.type = type;

                return this;
            }

            public String getContent() {
                return content;
            }

            public Message setContent(String content) {
                this.content = content;

                return this;
            }
        }
    }
}