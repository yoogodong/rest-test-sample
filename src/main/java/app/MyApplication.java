package app;

import monitor.ExceptionListener;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by Yonggao.Dong on 15/10/3.
 */
@ApplicationPath("/")
public class MyApplication extends ResourceConfig {
    public MyApplication(){
        packages("service");
        property("com.sun.jersey.api.json.POJOMappingFeature", "true");
//        register(LoggingFilter.class);
        register(ExceptionListener.class);
    }
}
