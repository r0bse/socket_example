package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * @author robert schroeder
 * @date 25. Nov 2016
 */
public class ReceiveFromClientThread implements Runnable {

    private PrintWriter print ;

    public static Logger LOGGER = Logger.getLogger( ReceiveFromClientThread.class.getName() );
    Socket client_socket = null;

    /**
     * constructor
     *
     * @param client_socket
     */
    public ReceiveFromClientThread( Socket client_socket )
    {
        LOGGER.info( "Logger Name: " + LOGGER.getName() );
        this.client_socket = client_socket;
    }

    public void run() {
        try {

            while ( true ) {
                this.print = new PrintWriter( client_socket.getOutputStream(), true );
                this.print.println( "Mir ist langweilig ..." );
                this.print.flush();
            }
            this.client_socket.close();
            System.exit( 0 );
        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }
}
