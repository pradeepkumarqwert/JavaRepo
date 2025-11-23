package com.scripts.resource;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.scripts.basefolder.BaseDataCloud;
import com.scripts.basefolder.BaseMethodsCloud;
import com.scripts.basefolder.BaseObjectsCloud;
import com.scripts.repository.PantaloonsLandingPage;

import java.net.MalformedURLException;
import java.net.URL;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;


public class WebServiceScript
{
	
	BaseMethodsCloud baseMethod;
	BaseObjectsCloud baseObject;
	BaseDataCloud baseData;
	PantaloonsLandingPage pantaloonsLandingPage;
	WebServiceScript PHpage;



	// inside your test method, after some Selenium steps
	public void callGetAPI() {
	    try {
	        String apiUrl = "https://reqres.in/api/users";
	        URL url = new URL(apiUrl);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        con.setRequestMethod("GET");
	        con.setRequestProperty("Accept", "application/json");

	        int responseCode = con.getResponseCode();
	        System.out.println("API Response Code: " + responseCode);
	        
	        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        String inputLine;
	        StringBuilder response = new StringBuilder();
	        while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
	        }
	        in.close();

	        System.out.println("API Response: " + response.toString());

	    } catch (Exception e) {
	        System.out.println("API call failed: " + e.getMessage());
	    }
	}


		@BeforeClass
		public void driverinitiation() throws InterruptedException, MalformedURLException
		{
			String seleniumHubUrl = "https://cloud.fireflink.com/backend/fireflinkcloud/wd/hub?accessKey=a31168ce-bf67-4a7a-bfa1-997fca75f65a&licenseId=LIC1026534&projectName=Time+Zone/";
			




			
			
			
		}
		
		@Test(invocationCount = 1)
		public void VerifyPantaloonsLandingPageMethod() throws InterruptedException
		{
			
			callGetAPI();
		}
		
		@AfterClass
		public void QuitBrowser()
		{
			
		}
		
		

}
