package tw.com.mitake.request;

public abstract class BaseRequest {
    public abstract QmiUrl getQmiUrl();
    public abstract Data getData();

    public static class Data {
    }
}
