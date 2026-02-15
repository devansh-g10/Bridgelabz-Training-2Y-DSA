class SubsetSum {
    static boolean subset(int[] arr, int target, int index) {
        if (target == 0) return true;
        if (index >= arr.length || target < 0) return false;

        // Include
        if (subset(arr, target - arr[index], index + 1))
            return true;

        // Exclude
        return subset(arr, target, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5};
        System.out.println(subset(arr, 9, 0)); // true
    }
}
