package util;

import net.jodah.failsafe.RetryPolicy;
import org.openqa.selenium.ElementNotInteractableException;

import java.time.Duration;

public class RetryPolicyConfig {

    public static RetryPolicy<Object> retryPolicy = new RetryPolicy<>()
            .handle(ElementNotInteractableException.class)
            .withDelay(Duration.ofSeconds(5))
            .onFailedAttempt(e -> System.out.println("An error was thrown, but retrying: " + e.getLastFailure()))
            .withMaxRetries(4);
}
