class myEfficientSort {
    static int comparisons = 0;
    static int swaps = 0;

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static int[] myEfficientSort(int[] a) {
        myEfficientSort(a, 0, a.length - 1);
        System.out.println("Number of comparisons: " + comparisons);
        System.out.println("Number of swaps: " + swaps);
        return a;
    }

    static void myEfficientSort(int[] a, int left, int right) {
        int i = left;
        int j = right;
        int pivot = a[(i + j) / 2];
        while (i <= j) {
            while (a[i] < pivot) {
                i++;
                comparisons++;
            }
            while (a[j] > pivot) {
                j--;
                comparisons++;
            }
            if (i <= j) {
                swap(a, i, j);
                swaps++;
                i++;
                j--;
            }
        }
        if (left < j)
            myEfficientSort(a, left, j);
        if (i < right)
            myEfficientSort(a, i, right);
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 1, 3, 2, 7, 6, 5, 8 };
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }
        // myEfficientSort(arr);

        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(myEfficientSort(arr)[i] + " ");
        // }
        System.out.println(myEfficientSort(arr));
    }
}