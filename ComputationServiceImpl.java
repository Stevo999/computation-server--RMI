import java.rmi.RemoteException;
import java.util.Arrays;

public class ComputationServiceImpl implements ComputationService {
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public void addAsync(int a, int b, Callback<Integer> callback) throws RemoteException {
        int result = add(a, b);
        callback.onResult(result);
        callback.onAck();
    }

    @Override
    public int[] sort(int[] array) throws RemoteException {
        Arrays.sort(array);
        return array;
    }

    @Override
    public void sortAsync(int[] array, Callback<int[]> callback) throws RemoteException {
        int[] sortedArray = sort(array);
        callback.onResult(sortedArray);
        callback.onAck();
    }
}
