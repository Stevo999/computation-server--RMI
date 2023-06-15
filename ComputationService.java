import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ComputationService extends Remote {
    int add(int i, int j) throws RemoteException;
    void addAsync(int i, int j, Callback<Integer> callback) throws RemoteException;
    int[] sort(int[] array) throws RemoteException;
    void sortAsync(int[] array, Callback<int[]> callback) throws RemoteException;
}
