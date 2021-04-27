package testRmi;

import java.rmi.Remote;
import java.util.Map;

public interface MapRemote extends Remote {
    Map<String,String> mapObjects(Map<String,String> input) throws Exception;
}
