package main.servers;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MultiThreadedServer implements Runnable {

    protected int          serverPort   = 8080;
    protected ServerSocket serverSocket = null;
    protected boolean      isStopped    = false;
    protected Thread       runningThread= null;

    public static void main(String[] args) {
    	
    	//When the server is running you can access it using an ordinary web browser.
    	//Use the address http://localhost:9000/
    	MultiThreadedServer server = new MultiThreadedServer(9000);
    	new Thread(server).start();

    	try {
    	    Thread.sleep(20 * 1000);
    	} catch (InterruptedException e) {
    	    e.printStackTrace();
    	}
    	System.out.println("Server Stopped");
    	server.stop();
	}
    
    public MultiThreadedServer(int port){
        this.serverPort = port;
    }

    public void run(){
    	System.out.println("Server Start");
        synchronized(this){
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();
        while(! isStopped()){
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if(isStopped()) {
                    System.out.println("Server Stopped.") ;
                    return;
                }
                throw new RuntimeException("Error accepting client connection", e);
            }
            
            new Thread(new WorkerRunnable(clientSocket, "Multithreaded Server")).start();
        }
        System.out.println("Server Stopped.") ;
    }


    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port 8080", e);
        }
    }

    private class WorkerRunnable implements Runnable {

        protected Socket clientSocket = null;
        protected String serverText   = null;

        public WorkerRunnable(Socket clientSocket, String serverText) {
            this.clientSocket = clientSocket;
            this.serverText   = serverText;
        }

        public void run() {
            try {
                InputStream input  = clientSocket.getInputStream();
                OutputStream output = clientSocket.getOutputStream();
                long time = System.currentTimeMillis();
                output.write(("HTTP/1.1 200 OK\n\nWorkerRunnable: " +this.serverText + " - " +time +"").getBytes());
                output.close();
                input.close();
                System.out.println("Request processed: " + time);
            } catch (IOException e) {
                //report exception somewhere.
                e.printStackTrace();
            }
        }
    }
}