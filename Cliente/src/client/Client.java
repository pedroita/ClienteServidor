package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.System.Logger;
import java.net.Socket;
import java.net.UnknownHostException;

import util.Mensagem;
import util.Status;




public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("Estabelecendo conexão...");
		Socket socket = new Socket("localhost", 5555);
		System.out.println("Conexão estabelecida.");
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		System.out.println("Enviando mensagem");
		Mensagem m = new Mensagem ("HELLO");
		m.setStatus(Status.SOLICITACAO);
		m.setParam(null, m);
		input.close();
		output.close();
		socket.close();
	}

}
