import server.Server;

import java.io.IOException;
import java.util.InputMismatchException;

/**
 * @author robert schroeder
 * @date 25. Nov 2016
 */
public class Main {

    public static final Integer PORT = 444;

    /**
     * starts program and lets it keep always on,
     * for ending it you have to press Ctrl+C or call System.exit() from somewher in the app
     *
     * @param args - may be a set of command line parameter, but we won't need them
     */
    public static void main( String[] args ) {

        try {
            switch ( args.length ) {

                case 0:
                    //start program with default params
                    startServer( PORT );
                    break;
                case 1:
                    validateAndStart( args );
                    break;
                default:
                    throw new InputMismatchException( "wrong amount of params, only 0 or 1 are allowed" );

            }
        }
        catch (IOException ioe){

            System.out.print( "could not connect to port" );
            System.exit( 1 );
        }
    }

    private static void validateAndStart( String[] args ) throws IOException{

        try {
            Integer port = Integer.valueOf( args[1] );
            startServer( port );

        } catch ( NumberFormatException nfe ) {
            System.out.print( "argument must be of type integer!" );
            System.exit( 1 );
        }
    }

    private static void startServer(Integer port) throws IOException{
        new Server( port );
    }
}
