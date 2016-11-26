package de.htw.ai.uebung5.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author robert schroeder
 * @date 25. Nov 2016
 */
class ReceiveThread implements Runnable
{
    Socket sock;
    BufferedReader recieve;

    public ReceiveThread(Socket sock) {
        this.sock = sock;
    }
    public void run() {
        try{
            recieve = new BufferedReader(new InputStreamReader( this.sock.getInputStream()));
            String msgRecieved;

            while((msgRecieved = recieve.readLine())!= null)
            {
                System.out.println("From Server: " + msgRecieved);
                System.out.println("Please enter something to send to server..");
            }
        }catch(Exception e){System.out.println(e.getMessage());}
    }//end run
}