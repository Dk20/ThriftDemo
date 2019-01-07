package org.ThriftDemoo.Server;


import org.ThriftDemoo.Tservice;
import org.ThriftDemoo.TserviceHandler;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class Server implements Runnable{
    private static TserviceHandler handler;
    private static Tservice.Processor processor;

    static{
        handler = new TserviceHandler();
        processor = new Tservice.Processor(handler);
    }

    public void run(){
        simple(processor);

    }
    public void simple(Tservice.Processor processor){
        try{
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
            System.out.println("Server Starting!");
            server.serve();
        }catch(Exception ex){
            System.out.println("The server blew up!");
            ex.printStackTrace();

        }
    }
}
