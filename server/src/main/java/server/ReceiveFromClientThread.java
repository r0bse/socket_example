package server;

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

    private static final Logger LOGGER = Logger.getLogger( ReceiveFromClientThread.class.getName() );
    private final Socket clientSocket;

    /**
     * constructor
     *
     * @param clientSocket
     */
    public ReceiveFromClientThread( Socket clientSocket )
    {
        LOGGER.info( "Logger Name: " + LOGGER.getName() );
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {

            this.print = new PrintWriter( clientSocket.getOutputStream(), true );
            this.print.println( "Mir ist langweilig ..." );
            this.print.flush();
            this.clientSocket.close();
            System.exit( 0 );

        }
        catch ( IOException e ) {
            e.printStackTrace();
            System.exit( 1 );
        }

    }
}
