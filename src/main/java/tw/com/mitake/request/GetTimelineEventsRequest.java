package tw.com.mitake.request;

import tw.com.mitake.constant.QmiUrl;

public class GetTimelineEventsRequest extends BaseRequest {
    @Override
    public QmiUrl getQmiUrl() {
        return QmiUrl.GET_TIMELINE_EVENTS;
    }

    @Override
    public Data getData() {
        return null;
    }
}
