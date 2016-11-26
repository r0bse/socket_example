import de.htw.ai.uebung5.client.Client;

import java.util.InputMismatchException;

/**
 * @author robert schroeder
 * @date 25. Nov 2016
 */
public class Main {

    static final String HOST = "localhost";
    static final Integer PORT = 444;

    /**
     * starts program and lets it keep always on,
     * for ending it you have to press Ctrl+C or call System.exit() from somewher in the app
     *
     * @param args - may be a set of command line parameter, but we won't need them
     */
    public static void main(String[] args) {

        switch(args.length){

            case 0:
                //start program with default params
                new Client(HOST, PORT);
                break;
            case 2:
                validateAndStart(args);
                break;
            default:
                throw new InputMismatchException( "wrong amount of params, only 0 or 2 are allowed" );

        }
    }

    private static void validateAndStart( String[] args ) {

            String host = args[0];
            try{
                Integer port = Integer.valueOf(  args[1] );
                new Client( host, port );
            }
            catch ( NumberFormatException nfe ){
                System.out.print( "second argument must be of type integer!" );
                System.exit(1);
            }
    }
}
