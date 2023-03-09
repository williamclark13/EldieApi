package com.wclark7.EldieApi;

import java.io.IOException;
import java.net.ServerSocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EldieApiApplication {

	/**
	 * Main entry point of the EldieApiApp.
	 *
	 * @param args command-line arguments.
	 * @throws IOException if there is an error while killing the process.
	 */
	public static void main(String[] args) throws IOException {
		int port = 8008;
		if (isPortInUse(port)) {
			System.out.println("Port " + port + " is already in use.");
			killProcessOnPort(port);
			SpringApplication.run(EldieApiApplication.class, args);
		}
		SpringApplication.run(EldieApiApplication.class, args);
	}

	/**
	 * Checks whether the given port is already in use or not.
	 *
	 * @param port the port number to check.
	 * @return true if the port is already in use, false otherwise.
	 */
	private static boolean isPortInUse(int port) {
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			serverSocket.setReuseAddress(true);
			return false;
		} catch (IOException e) {
			return true;
		}
	}

	/**
	 * Kills the process that is using the given port number.
	 *
	 * @param port the port number of the process to be killed.
	 * @throws IOException if there is an error while killing the process.
	 */
	private static void killProcessOnPort(int port) throws IOException {
		String command = "lsof -i :" + port + " | awk 'NR!=1 {print $2}' | xargs kill";
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("bash", "-c", command);
		Process process = processBuilder.start();
		try {
			process.waitFor();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new RuntimeException("Interrupted while waiting for process to finish", e);
		}
	}
}