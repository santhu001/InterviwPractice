/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewpractice;

/**
 *
 * @author santhosh
 */
public class SortingExamples {
        private double [] array;
    private double [] tempMergArr;

    public void sort(double[] a) {
        quickSort(a, 0, a.length-1);
    }
    private double[] quickSort(double[] a ,int lowerIndex, int higherIndex){
        int left=lowerIndex;
        int right=higherIndex;
       double pivot= a[left+(right-left)/2]; 
       while(left<=right){
           while (a[left]<pivot) {               
               left++;
           }
          while (a[right]>pivot) {               
              right--;
           }
          if(left<=right){
              double tm=a[left];
              a[left]=a[right];
              a[right]=tm;
              left++;
              right--;
          }
          
       }
       if (lowerIndex < right)
            quickSort(a,lowerIndex, right);
        if (left < higherIndex)
            quickSort(a,left, higherIndex);
return a;
    }
    
     private void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
     private void mergeParts(int lowerIndex, int middle, int higherIndex) {
         System.arraycopy(array, 0, tempMergArr, 0, array.length);

        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }

public void mergeSort(double[] a ){
    this.array=a;
    this.tempMergArr=new double[a.length];
    doMergeSort(0, a.length-1);
}
public void naturalSort(int[] arry){
    int maxInex=0;
    for (int i = 1; i < arry.length; i++) {
        if(arry[i]>arry[maxInex]){
            int val=arry[i];
            arry[i]=arry[maxInex];
            arry[maxInex]=val;
            maxInex=i;
            
        }
        
    }
}
    public  int[] doSelectionSort(int[] arr){
         
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;
      
            int smallerNumber = arr[index]; 
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }
    
     public  int[] doInsertionSort(int[] input){
         
        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }
    public static void main(String[] args) {
        int[] array={3,5,0,0,1};
        SortingExamples examples=new SortingExamples();
        examples.doSelectionSort(array);
        
    }
}
