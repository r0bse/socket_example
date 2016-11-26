package server;

/**
 * @author robert schroeder
 * @date 25. Nov 2016
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final Logger LOGGER = LoggerFactory.getLogger( Server.class );

    public Server(Integer port) throws IOException {

        LOGGER.info( "Logger Name: " + LOGGER.getName() );
        System.out.println( "Server waiting for connection on port " + port );
        ServerSocket server_socket = new ServerSocket( port );
        Socket client_socket = server_socket.accept();
        System.out.println( "Received connection from " + client_socket.getInetAddress() + " on port " + client_socket.getPort() );

        //create two threads to send and receive from client
        ReceiveFromClientThread receive = new ReceiveFromClientThread( client_socket );
        Thread thread = new Thread( receive );
        thread.start();
        SendToClientThread send = new SendToClientThread( client_socket );
        Thread thread2 = new Thread( send );
        thread2.start();
    }
}
