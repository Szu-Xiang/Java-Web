package HomeWork.HomeWork5;

import org.junit.Test;

import java.util.Map;

public class Test05 {
    public static void main(String[] args) {

    }
    public int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }

    @Test
    public void testGetMax() {
        int[] arr = {4,6,8,9,1,3,2,4,6};
        int max = getMax(arr);
        System.out.println("max = " + max);
    }
}