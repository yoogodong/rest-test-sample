package temp.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by Yonggao.Dong on 16/5/17.
 */
public class Retry implements IRetryAnalyzer {
    int i = 0;
    int max = 4;

    @Override
    public synchronized boolean  retry(ITestResult result) {
        return i++<max;
    }
}
