import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AcknowledgmentCallback extends Remote {
    void onAck() throws RemoteException;
}

public interface Callback<T> extends AcknowledgmentCallback {
    void onResult(T result) throws RemoteException;
}
