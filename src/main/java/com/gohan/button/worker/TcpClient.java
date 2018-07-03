package com.gohan.button.worker;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TcpClient {
	
	@Value("${safetyNet.socket.address}")
	private String address;
	
	@Value("${safetyNet.socket.port}")
	private Long port;
	
	public void sendMessage() throws UnknownHostException, IOException{
		  String sentence;
		  BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		  Socket clientSocket = new Socket(address, 6789);
		  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		  sentence = inFromUser.readLine();
		  outToServer.writeBytes(sentence + '\n');
		  clientSocket.close();
	}
}
