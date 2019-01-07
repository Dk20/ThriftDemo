package org.ThriftDemoo;


import org.ThriftDemoo.Client.Client;
import org.ThriftDemoo.Server.Server;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class DemoApp {
    public static void main(String[] args) {
        TTransport transport = new TSocket("localhost",9090);;
        Server server = new Server();
        Thread t = new Thread(server);
        t.start();

        try{

            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            Tservice.Client client = new Tservice.Client(protocol);
            Client.perform(client);
        }catch(Exception ex){
            System.out.println("Client's problem");
            ex.printStackTrace();
        }finally{
            transport.close();
        }
    }
}
