package org.yasmani.io;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    static Logger logger = Logger.getLogger(App.class.getName());

    private BookClient bookClient = new BookClient();
    public void main(String[] args) throws IOException {
        logger.info( "App thread !" );
        this.executeClient();
    }

    private void executeClient() throws IOException {
        this.bookClient.createRequest();
    }
}
