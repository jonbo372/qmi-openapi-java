package tw.com.mitake;

import org.junit.Before;

public class QmiTest {
    private Qmi qmi;

    @Before
    public void setup() {
        qmi = Qmi.init(System.getenv("QMI_APIKEY"));
    }
}
