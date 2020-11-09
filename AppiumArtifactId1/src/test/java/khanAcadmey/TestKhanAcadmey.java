package khanAcadmey;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class TestKhanAcadmey {
	public AndroidDriver driver;
  @Test
  public void searchPraxisCore() throws InterruptedException {
      driver.findElementByAccessibilityId("Search tab").click();
      Thread.sleep(5000);
      driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Test prep\")")).click();
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Praxis Core Writing\")")).click();
  	}
  
  
  @BeforeClass
  public void openkhanAcagmey() throws MalformedURLException, InterruptedException {
	  DesiredCapabilities capability= new DesiredCapabilities();
	    capability.setCapability("deviceName", "Dksingh");
	    capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	    //capability.setCapability(MobileCapabilityType.NO_RESET, true);
	    capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
	    capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
	    driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
	    //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    Thread.sleep(15000);
	    driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
}

  @AfterClass
  public void appClose() throws InterruptedException {
      Thread.sleep(10000);
      driver.pressKey(new KeyEvent(AndroidKey.HOME));
  }

}
