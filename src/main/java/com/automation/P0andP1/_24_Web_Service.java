package com.automation.P0andP1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class _24_Web_Service {

    // --- Utility: Fetch node IP using GraphQL from Selenium Grid 4/5 ---
    public static String getNodeIp(RemoteWebDriver driver, String hubHost) {
        try {
            SessionId session = driver.getSessionId();
            if (session == null) return "No active session.";

            String graphqlUrl = "http://" + hubHost + ":4444/graphql";

            // GraphQL query payload
            String query = "{ session(id: \"" + session + "\") { nodeUri } }";
            String payload = "{ \"query\": \"" + query.replace("\"", "\\\"") + "\" }";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(graphqlUrl))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(payload))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();

            if (body == null || body.isEmpty()) {
                return "Empty response from Grid.";
            }

            // Debug log to verify raw GraphQL response
            System.out.println("GraphQL Response: " + body);

            // Expected response format: {"data":{"session":{"nodeUri":"http://172.18.0.3:5555"}}}
            if (body.contains("nodeUri")) {
                int start = body.indexOf("nodeUri") + 10;
                int end = body.indexOf("\"", start);
                String nodeUri = body.substring(start, end);
                String nodeIp = nodeUri.replace("http://", "").split(":")[0]; // clean IP only
                return nodeIp;
            } else {
                return "Node URI not found in GraphQL response: " + body;
            }

        } catch (Exception e) {
            return "Error fetching node IP: " + e.getMessage();
        }
    }

    // --- Main Execution ---
    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            // Change this to your actual Selenium Hub URL
            String device_farm_hub_url = "https://fireflinkcloudtest.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=2XpX0pCCa5sZ4t42o2SQX7vVo3eapYfPDT-9I23oKiqp_DvSuFM7Wm54CZ8w07m4S0Q5hrpgNjeLO-gLBOyum4dn2ZczCYUFb25CzoAaTITZGr6fdL_AAriC4iMwJOBx3Ym9GXYg0kNy7ijkRDtqUF12GB_gjeElLM6ilD7Wbc98mhpUJgnemzbel-dPbkDYUxvZ5HMvQhKG4VuQogRYrOPrd_NXXKGypsEY0Fj3B8Fhmr4yBFKBn3-ig1ia9gtwwW8iUXrHr4QXHWJJ5CF94ozXB3nDOnOiE00V8iiC7pH9gzqOk1GS&licenseId=LIC4047&projectName=Test+termination/";
        	
            String hubHost = "10.10.42.225"; // Hub machine IP or DNS

            FirefoxOptions browserOptions = new FirefoxOptions();
            browserOptions.setCapability("devicefarm:networkLogEnable", false);
            browserOptions.setPlatformName("Windows 10");
            browserOptions.setBrowserVersion("137");
            driver = new RemoteWebDriver(new URL(device_farm_hub_url), browserOptions);
            driver.manage().window().setSize(new Dimension(1024, 768));


            // Print session and node info
            System.out.println("Session ID: " + ((RemoteWebDriver) driver).getSessionId());
            System.out.println("Node IP Address: " + getNodeIp((RemoteWebDriver) driver, hubHost));

            // Print local machine info
            try {
                InetAddress ip = InetAddress.getLocalHost();
                System.out.println("Host Name: " + ip.getHostName());
                System.out.println("Local IP Address: " + ip.getHostAddress());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            System.err.println("Invalid Selenium Hub URL: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
