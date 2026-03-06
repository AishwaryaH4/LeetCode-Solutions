class Solution {
    public int mySqrt(int x) {

        int low=0;
        int high=x;
        
        while(low<=high){
            int mid=low+(high-low)/2;

            if((long)mid*mid == x){
                return mid;
            }
            if((long)mid*mid > x){
                high = mid-1;
            }else{
                low= mid+1;
            }
        }
        return high;






        // if(x<=0) return 0;

        // int i=1;
        // while((long)i*i<=x){
        //     i++;
        // }
        // return i-1;
       
        
    }
}