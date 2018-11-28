package demo.hw.server;

import javax.xml.ws.Endpoint;



public class Server {


protected Server() throws Exception {
        System.out.println("Starting Server");
        HelloWorldImpl2 implementor = new HelloWorldImpl2();
        String address = "http://localhost:8080/EpointFrame/services/hello_world2";
        Endpoint.publish(address, implementor);
    }

   public static void main(String args[]) throws Exception {
        new Server();
        System.out.println("Server ready...");

        /*Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
       System.exit(0);*/
    }
}