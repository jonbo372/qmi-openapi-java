package tw.com.mitake;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Qmi {
    private static final Logger LOG = LoggerFactory.getLogger(Qmi.class);

    private static boolean init;
    private static Qmi instance;

    private Qmi() {
    }

    public static Qmi init(String apiKey) {
        if (init) {
            return instance;
        }

        if (StringUtils.isEmpty(apiKey)) {
            init = false;

            throw new IllegalArgumentException("Please indicate apiKey");
        }

        if (instance == null) {
            instance = new Qmi();
        }

        init = true;

        return instance;
    }
}
