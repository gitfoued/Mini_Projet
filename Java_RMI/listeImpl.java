package Java_RMI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class listeImpl extends UnicastRemoteObject implements liste{
        public List<String> tasks;

    public listeImpl() throws RemoteException {
        tasks = new ArrayList<>();
    }

    
    public void addTask(String task) throws RemoteException {
        tasks.add(task);
    }

    
    public void removeTask(String task) throws RemoteException {
        tasks.remove(task);
    }

  
    public List<String> getTaskList() throws RemoteException {
        return tasks;
    }
}

