import java.util.*;
public class gnome {
    private static void gnomeSort(int[] ar) {
        int i = 1;
        int n = ar.length;
        while (i < n) {
            if (i == 0 || ar[i - 1] <= ar[i]) {
                i++;
            } else {
                int tmp = ar[i];
                ar[i] = ar[i - 1];
                ar[--i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] ar= {5, 4, 3, 2, 1};
        System.out.println("Original:  " + Arrays.toString(ar));
        gnomeSort(ar);
        System.out.println("Ordenado:  " + Arrays.toString(ar));
    }
}