package demo.hw.server;

import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;





public class Server {


protected Server() throws Exception {
        System.out.println("Starting Server");
        HelloWorldImpl2 implementor = new HelloWorldImpl2();
        String address = "http://localhost:8080/EpointFrame/services/hello_world2";
        Endpoint publish = Endpoint.publish(address, implementor);
        EndpointImpl endpointImpl = (EndpointImpl)publish;
        endpointImpl.getInInterceptors().add(new LoginIntercept());
        endpointImpl.getInInterceptors().add(new LoggingInInterceptor());
        System.out.println("发布成功");
    }

   public static void main(String args[]) throws Exception {
        new Server();

       
    }
}