package temp;

import org.testng.annotations.Test;

/**
 * Created by Yonggao.Dong on 16/5/16.
 */
public class TestBase {

    @Test
    public void first(){
        System.out.println("first");
    }

    @Test(dependsOnMethods = "first")
    public void second(){
        System.out.println("second");
    }

//
//    @Test(dependsOnMethods = "second")
//    public void third(){
//        System.out.println("third");
//    }
}
