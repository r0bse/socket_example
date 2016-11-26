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
        LOGGER.debug( "Server waiting for connection on port %d", port );

        ServerSocket server_socket = new ServerSocket( port );
        Socket client_socket = server_socket.accept();
        LOGGER.debug( String.format( "Received connection from %s on port %d", client_socket.getInetAddress(), client_socket.getPort() ));
        //create two threads to send and receive from client
        ReceiveFromClientThread receive = new ReceiveFromClientThread( client_socket );

        Thread thread = new Thread( receive );
        thread.start();
        SendToClientThread send = new SendToClientThread( client_socket );
        Thread thread2 = new Thread( send );
        thread2.start();
    }
}
