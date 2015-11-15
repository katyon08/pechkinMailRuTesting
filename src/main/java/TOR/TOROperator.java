package TOR;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.*;

public class TOROperator {

    public static FirefoxDriver startTor() {
        File torProfileDir = new File("C:\\onion\\Tor Browser\\Browser\\TorBrowser\\Data\\Browser\\profile.default.meek-http-helper");
        FirefoxBinary binary = new FirefoxBinary(new File("C:\\onion\\Tor Browser\\Start.exe"));
        FirefoxProfile torProfile = new FirefoxProfile(torProfileDir);
        torProfile.setPreference("webdriver.load.strategy", "unstable");
        try {
            binary.startProfile(torProfile, torProfileDir, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.socks", "127.0.0.1");
        profile.setPreference("network.proxy.socks_port", 9150);
        return new FirefoxDriver(profile);
    }

    public static void killFirefox() {
        Runtime rt = Runtime.getRuntime();

        try {
            rt.exec("taskkill /F /IM firefox.exe");

            while (processIsRunning("firefox.exe")) {
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean processIsRunning(String process) {
        boolean firefoxIsRunning = false;
        String line;
        try {
            Process proc = Runtime.getRuntime().exec("wmic.exe");
            BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            OutputStreamWriter oStream = new OutputStreamWriter(proc.getOutputStream());
            oStream.write("process where name='" + process + "'");
            oStream.flush();
            oStream.close();
            while ((line = input.readLine()) != null) {
                if (line.toLowerCase().contains("caption")) {
                    firefoxIsRunning = true;
                    break;
                }
            }
            input.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return firefoxIsRunning;
    }
}
