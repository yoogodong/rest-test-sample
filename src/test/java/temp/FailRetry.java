package temp;

import org.testng.annotations.Test;
import temp.listener.Retry;

import static org.testng.Assert.fail;

/**
 * Created by Yonggao.Dong on 16/5/17.
 */


public class FailRetry {
    int count = 0;

    @Test(retryAnalyzer = Retry.class)
    public void retryTest() throws InterruptedException {
        //test
    }

    @Test(retryAnalyzer = Retry.class)
    public int retryTest1() throws InterruptedException {
        System.err.printf("B%s\n", ++count);
        fail();
        return 1;
    }


}
