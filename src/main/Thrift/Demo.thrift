//namespace java org.ThriftDemoo

typedef i32 int

service org.ThriftDemoo.Tservice{
    int square(1:int n),
    bool ping(),
}