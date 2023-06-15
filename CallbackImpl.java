import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.function.Consumer;

public class CallbackImpl<T> implements Callback<T>, Serializable {
    private static final long serialVersionUID = 1L;
    private final transient Consumer<T> callback;

    public CallbackImpl(Consumer<T> callback) {
        this.callback = callback;
    }

    @Override
    public void onResult(T result) throws RemoteException {
        callback.accept(result);
    }
}

