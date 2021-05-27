/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequencial;
import java.lang.InterruptedException;
import java.lang.Comparable;
/**
 *
 * @author xxblu
 */
public class ThreadedMergeSort<T extends Comparable<T>> {
    
        
    public void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        Thread t1 = new Thread(){
           public void run(){
                mergeSort(l, mid);
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                mergeSort(r, n - mid);
            }    
        };
        t1.start();
        t2.start();
        try{
            t1.join();
        }catch(InterruptedException e){}
        try{
            t2.join();
        }catch(InterruptedException e){}

        merge(a, l, r, mid, n - mid);
    }
    public void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
