package org.ThriftDemoo;

import org.apache.thrift.TException;

public class TserviceHandler implements Tservice.Iface {
    @Override
    public int square(int n) throws TException {
        return n*n;
    }

    @Override
    public boolean ping() throws TException {
        return true;
    }
}
