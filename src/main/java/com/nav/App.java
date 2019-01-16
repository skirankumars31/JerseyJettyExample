package com.nav;

import com.nav.res.MyMessage;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler(server, "/*");
        handler.setContextPath("/");

        server.setHandler(handler);

        ServletHolder jerseyServlet = handler.addServlet(org.glassfish.jersey.servlet.ServletContainer.class,"/*");
        jerseyServlet.setInitOrder(0);

        jerseyServlet.setInitParameter("jersey.config.server.provider.classnames", MyMessage.class.getCanonicalName());

        server.start();
        server.join();

    }
}
