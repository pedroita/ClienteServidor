package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import util.Mensagem;
import util.Status;

public class Server {
	private ServerSocket serverSocket;
	private void criarSeverSocket(int porta) throws IOException {
		serverSocket = new ServerSocket(porta);
	}
	private Socket esperaConexao() throws IOException {
		Socket socket = serverSocket.accept();
		return socket;
	}
	
	private void trataConexao(Socket socket) throws IOException, ClassNotFoundException  {
		try {
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		
		
		String msg = input.readUTF();
		System.out.println("Trando...");
		Mensagem m =(Mensagem) input.readObject();
		String operacao = m.getOperacao();
		Mensagem reply = null;
		if (operacao.equals("HELLO")){
			String nome = (String) m.getParam("nome");
			String sobrenome =(String) m.getParam("sobrenome");
			 reply = new Mensagem("HELLOREPLY");
			if (nome == null || sobrenome == null)
				reply.setStatus(Status.PARAMERROR);
			else {
			reply.setStatus(Status.OK);
			reply.setParam("mensagem", "hello World"  + nome + "" + sobrenome);
			}
			}
		
		output.writeObject(reply);
		output.flush();
		
		input.close();
		output.close();
		}catch (IOException e) {
			System.out.println("Problema no tratamento de conexão com o cliente: " + socket.getInetAddress());
			System.out.println("Erro: " + e.getMessage());
		}finally {
		
			fecharSocket(socket);
		} 
	}
	 
	private void  fecharSocket(Socket s) throws IOException {
		s.close();
	}
	
	public static void main(String[] args) {
		
		try {
			
			Server server = new Server();
			System.out.println("Aguardando conexão...");
			server.criarSeverSocket(5555);
			while(true) {
			Socket socket = server.esperaConexao();
			System.out.println("Cliente Conectado.");
			server.trataConexao(socket);
			System.out.println("Cliente finalizado...");
			}
		} catch (IOException e) {
			
			System.out.println("erro servidor:" + e.getMessage());
		}catch (ClassNotFoundException e) {
			System.out.println("Erro no  cast: " + e.getMessage());
		}
		
	}

}
