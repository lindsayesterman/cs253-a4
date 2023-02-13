class myEfficientSort {
    static int comparisons = 0;
    static int swaps = 0;

    static int[] myEfficientSort(int[] a) {
        int[] h = new int[a.length];
        myEfficientSort(a, 0, a.length - 1, h);
        System.out.println("Number of comparisons " + comparisons);
        return a;
    }

    static void myEfficientSort(int[] a, int l, int r, int[] h) {
        if (l < r) {
            int q = (l + r) / 2;
            myEfficientSort(a, l, q, h);
            myEfficientSort(a, q + 1, r, h);
            merge(a, l, q, r, h);
        }
    }

    static void merge(int[] a, int l, int q, int r, int[] h) {
        int i, j;
        for (i = l; i <= q; i++)
            h[i] = a[i];
        for (j = q + 1; j <= r; j++)
            h[r + q + 1 - j] = a[j];
        i = l;
        j = r;
        for (int k = l; k <= r; k++) {
            if (h[i] <= h[j]) {
                a[k] = h[i];
                i++;
            } else {
                a[k] = h[j];
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 5, 7, 2, 4, 6, 8 };
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