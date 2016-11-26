package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author robert schroeder
 * @date 25. Nov 2016
 */
class SendToClientThread implements Runnable {
    private PrintWriter pwPrintWriter;
    private final Socket clientSock;

    SendToClientThread( Socket clientSock ) {
        this.clientSock = clientSock;
    }

    public void run() {
        try {
            pwPrintWriter = new PrintWriter( new OutputStreamWriter( this.clientSock.getOutputStream() ) );//get outputstream

            while ( true ) {
                String msgToClientString;
                BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );//get userinput

                msgToClientString = input.readLine();//get message to send to client

                pwPrintWriter.println( msgToClientString );//send message to client with PrintWriter
                pwPrintWriter.flush();//flush the PrintWriter
                System.out.println( "Please enter something to send back to client.." );
            }
        } catch ( Exception ex ) {
            System.out.println( ex.getMessage() );
        }
    }
}

