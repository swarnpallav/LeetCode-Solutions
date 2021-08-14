// https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int repeat = -1;
        for(int i = 0; i < n; i++)
        {
            if(arr[Math.abs(arr[i]%n)] < 0)
            {
                repeat = Math.abs(arr[i]%n) == 0 ? n : Math.abs(arr[i]%n);
            }
            else
                arr[Math.abs(arr[i]%n)] *= -1;
        }
        int missing = -1;
        for(int i = 0; i < n; i++)
            if(arr[i] > 0)
                missing = (i == 0) ? n : i;
        return (new int[]{repeat, missing});
    }
}
