PROBLEM LINK:
https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/submissions/1454043502/?envType=daily-question&envId=2024-11-16


SOLUTION:
class Solution {
    public int[] resultsArray(int[] nums, int k) {
            if (nums == null || nums.length < k) {
            return new int[0];
        }

        int arr[]=new int[nums.length-k+1];
        int i=0;
        int j=k-1;
        int a=0;
        while(j<nums.length){
            if(solved(nums,i,j)){
                arr[a]=nums[j];
            }
            else{
                arr[a]=-1;
            }
            i++;
            j++;
            a++;
        }
        return arr;
        
    }

    private boolean solved(int nums[],int start,int end){
        for(int i=start;i<end;i++){
            if(nums[i]+1!=nums[i+1]){
                return false;
            }
        }
        return true;
    }
}
