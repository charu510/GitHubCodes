package Arrays;

public class DivisibleSubarrays {
    public static void main(String[] args) {
        //getting the number of good subarrays that can be formed
        int[] ar = {1,2,3,4,6};
        System.out.println(divisibleSubarrays(ar));
    }

    public static long divisibleSubarrays(int[] ar){
        int n = ar.length;
        long[] hole = new long[n];

        hole[0] = 1;
        int sum = 0;
        //putting the frequency of the whole as 1 if there are no elements in the hole array
        for (int i = 0; i < hole.length; i++) {
            sum += ar[i];

            //if the sum is negative
            if (sum<0){
                sum = sum%n;
                sum += n;
            }

            //if the array is of size 1 and is not good subarray then
           if (ar.length==1 && ar[0]%n!=0){
               return 0;
           }
            sum%=n;
            hole[sum]++; //increasing the frequency at that index
        }

        long ans = 0;
        for (int i = 0; i < hole.length; i++) {
            if (hole[i]>=2){
                //calculate the selection
                long p = hole[i];
                ans = ans + (p*(p-1))/2;
            }
        }
        return ans;

    }
}
