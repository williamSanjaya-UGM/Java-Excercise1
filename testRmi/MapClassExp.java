package testRmi;

import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

public class MapClassExp extends UnicastRemoteObject implements MapRemote{

    public MapClassExp() throws Exception{
        super();
    }

    @Override
    public Map<String, String> mapObjects(Map<String,String> input) throws Exception {
        return input;
    }
}
