class Sum_of_Array {
    static int sum(int[] arr, int n) {
        if (n == 0) return 0;
        return arr[n - 1] + sum(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};
        System.out.println(sum(arr, arr.length)); // 30
    }
}
