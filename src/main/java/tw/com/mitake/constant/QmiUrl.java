package tw.com.mitake.constant;

import tw.com.mitake.Qmi;

public enum QmiUrl {
    POST_TIMELINE_EVENT(HttpMethod.POST, "events"),
    GET_TIMELINE_EVENTS(HttpMethod.GET, "events"),
    POST_CHATROOM_EVENT(HttpMethod.POST, "chats");

    private HttpMethod method;
    private String url;

    QmiUrl(HttpMethod method, String url) {
        this.method = method;
        this.url = String.format(Qmi.baseUrl, url);
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }
}
