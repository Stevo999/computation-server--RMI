import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Arrays;

public class ComputationClient {
    public static void main(String[] args) {
        try {
            ComputationService computationService = new ComputationServiceImpl();

            // Synchronous add operation
            int resultSync = computationService.add(10, 8);
            System.out.println("Addition Result (Synchronous): " + resultSync);

            // Asynchronous add operation
            computationService.addAsync(10, 8, new Callback<Integer>() {
                @Override
                public void onResult(Integer result) {
                    System.out.println("Callback Result: " + result);
                }

                @Override
                public void onAck() {
                    System.out.println("Callback Acknowledged");
                }

                private static final long serialVersionUID = 1L;
            });

            // Synchronous sort operation
            int[] array = {4, 2, 9, 1, 7};
            int[] sortedArraySync = computationService.sort(array);
            System.out.println("Sorted Array (Synchronous): " + Arrays.toString(sortedArraySync));

            // Asynchronous sort operation
            computationService.sortAsync(array, new Callback<int[]>() {
                @Override
                public void onResult(int[] result) {
                    System.out.println("Callback Result: " + Arrays.toString(result));
                }

                @Override
                public void onAck() {
                    System.out.println("Callback Acknowledged");
                }

                private static final long serialVersionUID = 1L;
            });
        } catch (Exception e) {
            System.err.println("Computation client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
