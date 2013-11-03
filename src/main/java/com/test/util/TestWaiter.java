package com.test.util;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This helper class duplicates the functionality of the Wait class in the support classes. This
 * class is not thread-safe.
 */
public class TestWaiter {

  private static final long DEFAULT_TIME_OUT = 10;
  private static final TimeUnit DEFAULT_UNIT = SECONDS;

  /**
   * Wait for the callable to return either "not null" or "true". Exceptions are caught and only
   * rethrown if we time out.
   * 
   * @param until Condition that we're waiting for.
   * @return Whatever the condition returns.
   */
  public static <X> X waitFor(Callable<X> until) {
    return waitFor(until, DEFAULT_TIME_OUT, DEFAULT_UNIT);
  }

  /**
   * Wait for the callable to return either "not null" or "true". Exceptions are caught and only
   * rethrown if we time out.
   * 
   * @param until Condition that we're waiting for.
   * @param duration How long to wait.
   * @param in Unit in which duration is measured.
   * @return Whatever the condition returns.
   */
  public static <X> X waitFor(Callable<X> until, long duration, TimeUnit in) {
    long end = System.currentTimeMillis() + in.toMillis(duration);

    X value = null;
    Exception lastException = null;

    while (System.currentTimeMillis() < end) {
      try {
        value = until.call();

        if (value instanceof Boolean) {
          if ((Boolean) value) {
            return value;
          }
        } else if (value != null) {
          return value;
        }

        sleep(100);
      } catch (Exception e) {
        // Swallow for later re-throwing
        lastException = e;
      }
    }

    if (lastException != null) {
      throw propagate(lastException);
    }

    throw new RuntimeException("Condition timed out: " + until);
  }

  private static RuntimeException propagate(Exception lastException) {
    if (lastException instanceof RuntimeException) {
      throw (RuntimeException) lastException;
    }

    throw new RuntimeException(lastException);
  }


  private static void sleep(long duration) {
    try {
      Thread.sleep(duration);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public static WebElement waitForElement(By by, int timeout, WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

    return element;
  }
}