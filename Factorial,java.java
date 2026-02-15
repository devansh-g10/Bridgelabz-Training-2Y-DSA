class Factorial {
    static int factorial(int n) {
        if (n <= 1) return 1;   // Base case
        return n * factorial(n - 1);  // Recursive case
    }

    public static void main(String[] args) {
        System.out.println(factorial(5)); // 120
    }
}
