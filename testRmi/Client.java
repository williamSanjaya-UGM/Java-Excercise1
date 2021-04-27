package testRmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) throws Exception {
        String key = args[0];
        String value=args[1];
        Map<String,String> maps = new HashMap<>();
        maps.put(key,value);

        MapRemote mapRemote= (MapRemote) Naming.lookup("MAP");
        Map<String, String> mapObjects = mapRemote.mapObjects(maps);
        System.out.println("your Map is: "+mapObjects);
    }
}
