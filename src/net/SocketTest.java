package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket socket = new ServerSocket(54312);
		socket.accept();
	}

}
