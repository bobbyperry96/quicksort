package sort;

import java.util.Random;

public class QuickSort {

    static QuickSort a;


    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[4096000];

        a = new QuickSort();

        int average=0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[j] = rand.nextInt(100);
            }
            long start = System.currentTimeMillis();
            a.sort(arr, 0, arr.length - 1);
            long end = System.currentTimeMillis();
            average += (end-start);
        }
        System.out.println(average/100+" ms");

    }


    public void print(int[] a) {
        boolean ordered = true;
        for (int i = 1; i < a.length; i++) {
            if(a[i-1]>a[i]) {
                ordered = false;
                break;
            }
        }
            
            System.out.println(ordered);
    }


    public QuickSort() {
    }


    public void sort(int[] a, int left, int right) {
        int pivotIndex = (left + right) / 2;

        swap(a, pivotIndex, right);

        int k = part(a, left, right, a[right]);

        swap(a, k, right);
        if (k - left < right - k) {
            if (k - left > 1)
                sort(a, left, k - 1);
           // else
          //      insertSort(a, left, k - 1);
            if (right - k > 1)
                sort(a, k + 1, right);
           // else
             //   insertSort(a, k + 1, right);
        }
        else {
            if (right - k > 1)
                sort(a, k + 1, right);
            //else
           //     insertSort(a, k + 1, right);
            if (k - left > 1)
                sort(a, left, k - 1);
           // else
             //   insertSort(a, left, k - 1);
        }
    }


    private int part(int[] a, int left, int right, int pivot) {
        while (left < right) {
            while (a[left] < pivot)
                left++;
            while (left < right && a[right] >= pivot)
                right--;
            if (left < right)
                swap(a, left, right);
        }
        return left;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    private void insertSort(int[] a, int left, int right) {
        for(int i=left+1;i<right;i++) {
            int j=i-1;
            int key = a[i];
            
            while(j>=0 && key < a[j]) {
                a[j+1]= a[j];
                j--;
            }
            a[j+1] = key;
        }
    }

}
