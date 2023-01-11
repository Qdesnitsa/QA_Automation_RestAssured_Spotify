package api.automation.spotify.oauth2;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class ParallelRunCheckTest {
    @BeforeMethod
    public void proveMethodsRunInParallelThreads(Method method) {
        System.out.println("Start test " + method.getName());
        System.out.println("Thread ID " + Thread.currentThread().getId());
    }
}
