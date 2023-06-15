import java.rmi.RemoteException;

public interface Callback<T> {
    void onResult(T result) throws RemoteException;
    void onAck() throws RemoteException;
}

