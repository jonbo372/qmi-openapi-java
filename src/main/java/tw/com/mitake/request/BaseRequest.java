package tw.com.mitake.request;

import tw.com.mitake.constant.QmiUrl;

public abstract class BaseRequest {
    public abstract QmiUrl getQmiUrl();
    public abstract Data getData();

    public static class Data {
    }
}
