package tw.com.mitake;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tw.com.mitake.constant.QmiUrl;
import tw.com.mitake.request.BaseRequest;
import tw.com.mitake.response.BaseResponse;
import tw.com.mitake.utils.JsonUtils;

import java.io.IOException;

public class QmiSender {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final Logger LOG = LoggerFactory.getLogger(QmiSender.class);
    private static final OkHttpClient CLIENT = new OkHttpClient();

    public BaseResponse send(BaseRequest request, Class<? extends BaseResponse> responseClass) {
        QmiUrl qmiUrl = request.getQmiUrl();
        Request req = null;

        switch (qmiUrl.getMethod()) {
            case POST:
                String jsonData = JsonUtils.toJson(request);

                RequestBody requestBody = RequestBody.create(JSON, jsonData);

                req = new Request.Builder().url(qmiUrl.getUrl() + "?token=" + Qmi.getToken()).post(requestBody).build();

                LOG.debug("RequestBody: {}", jsonData);
                LOG.debug("Request: {}", req.toString());

                break;
            case GET:
                req = new Request.Builder().url(qmiUrl.getUrl() + "?token=" + Qmi.getToken()).get().build();

                LOG.debug("Request: {}", req.toString());

                break;
        }

        BaseResponse res = null;

        try {
            Response response = CLIENT.newCall(req).execute();
            String responseBody = response.body().string();

            LOG.debug("ResponseBody: {}", responseBody);

            res = JsonUtils.fromJson(responseBody, responseClass);
        } catch (IOException e) {
            LOG.error("Caught Exception: ", e);
        }

        return res;
    }
}