import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability("newCommandTimeout", 300); // 5 phút
        //chưa chạy 2 dòng này
        //caps.setCapability("avd", "Pixel_3");
        //caps.setCapability("avdLaunchTimeout", 180000); // 3 phút
        String andAppUrl = System.getProperty("user.dir") + File.separator + "src"+File.separator + "main"
                + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
        //open app
        //caps.setCapability("appPackage", "io.appium.android.apis");
        //caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
        // không cần cài app nữa, mình muốn mở nó lên trên điện thoại có sẵn
        caps.setCapability(MobileCapabilityType.APP, andAppUrl);

        URL url = new URL("http://0.0.0.0:4723/wd/hub");

        AppiumDriver driver = new AndroidDriver(url, caps);
        System.out.println("Session id "+driver.getSessionId());

        /*DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"IOS");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iphone 11");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        caps.setCapability(MobileCapabilityType.UDID, "9527463259a2c083dfc8062535b699a52b9b3cf9");
        //cái này cho paid account
        //caps.setCapability("xcodeOrgId", "L8T9J4R323");
        //caps.setCapability("xcodeSigningId", "iPhone Developer");

        String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "UIKitCatalog-iphonesimulator.app";
        //caps.setCapability(MobileCapabilityType.APP, iOSAppUrl);
        caps.setCapability("simulatorStartupTimeout", 180000);
        caps.setCapability("bundleId", "com.example.apple-samplecode.UICatelog");
        URL url = new URL("http://0.0.0.0:4723/wd/hub");

        AppiumDriver driver = new IOSDriver(url, caps);*/




    }
}
