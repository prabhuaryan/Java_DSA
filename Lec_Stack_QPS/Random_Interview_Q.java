package Lec_Stack_QPS;

public class Random_Interview_Q {
//	https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
	 public int findMin(int[] arr) {
	        int s = 0;
	        int e = arr.length-1;
	        int ans =Integer.MAX_VALUE;;
	        while(s<=e){
	            int mid = (s+e)/2;

	            if(arr[s]>arr[e]){
	                // region !! array rotatte!!!!

	                if(arr[s]<arr[mid]){
	                    s= mid+1;
	                }else if(arr[s]>arr[mid]){
	                    e = mid-1;
	                    ans = arr[mid];
	                }else{
	                    s = mid+1;
	                }
	            }else{
	                ans = Math.min(ans,arr[s]);
	                return ans;
	            }
	        }
	        return ans;
	    }

}
