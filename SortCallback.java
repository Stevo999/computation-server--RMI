import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.function.Consumer;

public class SortCallback<T> extends UnicastRemoteObject implements Callback<T> {
    private static final long serialVersionUID = 1L;
    private Consumer<T> callback;

    public SortCallback(Consumer<T> callback) throws RemoteException {
        super();
        this.callback = callback;
    }

    @Override
    public void onResult(T result) throws RemoteException {
        callback.accept(result);
    }
}

