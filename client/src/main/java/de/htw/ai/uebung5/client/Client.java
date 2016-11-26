package de.htw.ai.uebung5.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;

/**
 * @author robert schroeder
 * @date 25. Nov 2016
 */
public class Client {

    final Logger log = LoggerFactory.getLogger( Client.class);

    /**
     * Constructor
     * create a client which starting to connect to set Properties
     */
    public Client(String host, Integer port){

        try {

            Socket sock;
            sock = new Socket( host, port );
            SendThread sendThread = new SendThread( sock );
            Thread thread = new Thread( sendThread );
            thread.start();
            ReceiveThread recieveThread = new ReceiveThread( sock );
            Thread thread2 = new Thread( recieveThread );
            thread2.start();

        } catch ( IOException e ) {

            log.error( e.getMessage() );
            System.exit( 1 );
        }

    }
}