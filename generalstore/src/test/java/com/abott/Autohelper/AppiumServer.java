package com.abott.Autohelper;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServer {

	private AppiumDriverLocalService service;
	private AppiumServiceBuilder builder;
	private DesiredCapabilities cap;
	private String ipAddress;
	private int ipPort;

	// New Changes
	private AppiumDriverLocalService appiumDriverService;
	private AppiumServiceBuilder appiumServiceBuilder;

	public AppiumServer(String ipAdd, int portNumber) {
		ipAddress = ipAdd;
		ipPort = portNumber;
	}

	public AppiumServer() {

	}

	public void startServer() {
		// Set Capabilities
		cap = new DesiredCapabilities();
		cap.setCapability("noReset", "false");

		// Build the Appium service
		builder = new AppiumServiceBuilder();
		builder.withIPAddress(ipAddress);
		builder.usingPort(ipPort);
		builder.withCapabilities(cap);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

		HashMap<String, String> environment = new HashMap<String, String>();
		environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
		builder.withEnvironment(environment);
		System.out.println("The current path variable ================ >>>>>" + System.getenv("PATH"));

		// Start the server with the builder
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
	}

	public void stopServer() {
		service.stop();
	}

	public boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	/*
	 * public static void main(String[] args) { AppiumServerJava appiumServer = new
	 * AppiumServerJava();
	 * 
	 * int port = 4723; if(!appiumServer.checkIfServerIsRunnning(port)) {
	 * appiumServer.startServer(); appiumServer.stopServer(); } else {
	 * System.out.println("Appium Server already running on Port - " + port); } }
	 */

	public void configureServer(String requestType, String driverIpAddr, String driverPort,
			DesiredCapabilities desiredCapsNeeded) {

		try {
			// Build the Appium service
			appiumServiceBuilder = new AppiumServiceBuilder();
			appiumServiceBuilder.withIPAddress(driverIpAddr);
			appiumServiceBuilder.usingPort(Integer.parseInt(driverPort));

			appiumServiceBuilder.withCapabilities(desiredCapsNeeded);
			appiumServiceBuilder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
			appiumServiceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
			appiumServiceBuilder.withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER,
					"" + Integer.parseInt(driverPort + 1));

			HashMap<String, String> environment = new HashMap<String, String>();
			environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
			appiumServiceBuilder.withEnvironment(environment);
			System.out.println("The current path variable ================ >>>>>" + System.getenv("PATH"));
			// Start the server with the builder
			appiumDriverService = AppiumDriverLocalService.buildService(appiumServiceBuilder);

			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void startTheServer() {
		try {
			appiumDriverService.start();
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Server Started");
	}

	public void stopTheServer() {
		appiumDriverService.stop();
		System.out.println("Server Stopped");
	}
}
