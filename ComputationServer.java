import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class ComputationServer implements ComputationService {
    public ComputationServer() {
        super();
    }

    @Override
    public int add(int i, int j) {
        return i + j;
    }

    @Override
    public void addAsync(int i, int j, Callback<Integer> callback) {
        new Thread(() -> {
            try {
                int result = add(i, j);
                callback.onResult(result);
            } catch (RemoteException e) {
                System.err.println("Exception in addAsync: " + e.toString());
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public int[] sort(int[] array) {
        Arrays.sort(array);
        return array;
    }

    @Override
    public void sortAsync(int[] array, Callback<int[]> callback) {
        new Thread(() -> {
            try {
                int[] result = sort(array);
                callback.onResult(result);
            } catch (RemoteException e) {
                System.err.println("Exception in sortAsync: " + e.toString());
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        try {
            ComputationServer server = new ComputationServer();
            ComputationService stub = (ComputationService) UnicastRemoteObject.exportObject(server, 0);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ComputationService", stub);

            System.out.println("Computation server is running......");
        } catch (Exception e) {
            System.err.println("Computation server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

