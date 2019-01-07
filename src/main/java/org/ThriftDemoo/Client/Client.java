package org.ThriftDemoo.Client;

import org.ThriftDemoo.Tservice;
import org.apache.thrift.TException;


public class Client {

    public static void perform(Tservice.Client client) throws TException {
        System.out.println(client.ping());
        System.out.println(client.square(15));
    }
}
