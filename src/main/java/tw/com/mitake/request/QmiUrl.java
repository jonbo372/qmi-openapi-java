package tw.com.mitake.request;

public enum QmiUrl {
    POST_TIMELINE_EVENT(HttpMethod.POST, "events"),
    POST_CHATROOM_EVENT(HttpMethod.POST, "chats");

    public static final String BASE_URL = "https://ap.qmi.emome.net/v2/open/%s";

    private HttpMethod method;
    private String url;

    QmiUrl(HttpMethod method, String url) {
        this.method = method;
        this.url = String.format(BASE_URL, url);
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }
}
