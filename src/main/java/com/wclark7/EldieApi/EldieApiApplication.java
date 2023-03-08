package com.wclark7.EldieApi;

import java.io.IOException;
import java.net.ServerSocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EldieApiApplication {

	public static void main(String[] args) throws IOException {
		int port = 8008;
		if (isPortInUse(port)) {
			System.out.println("Port " + port + " is already in use.");
			killProcessOnPort(port);
		}
		SpringApplication.run(EldieApiApplication.class, args);
	}

	private static boolean isPortInUse(int port) {
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			serverSocket.close();
			return false;
		} catch (IOException e) {
			return true;
		}
	}

	private static void killProcessOnPort(int port) throws IOException {
		String command = "lsof -i :" + port + " | awk 'NR!=1 {print $2}' | xargs kill";
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("bash", "-c", command);
		Process process = processBuilder.start();
		try {
			process.waitFor();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}