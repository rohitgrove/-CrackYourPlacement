public class MaximumLengthOfReapeatedSubArray {
    public int findLength(int[] nums1, int[] nums2) {
        //start from all i, j
        int ans=0;
        dp=new Pair[nums1.length][nums2.length];
        for(int i=0;i<nums1.length;i++) {
            for(int j=0;j<nums2.length;j++) {
               ans=Math.max(ans, util(nums1, nums2, i, j).ans); 
            }
        }
        return ans;
    }
    
    private class Pair {
        int ret;//what is returned
        boolean isConnected; //is subarray is going on
        int ans; //max subarray length
        Pair(int x, boolean y) {
            ret=x;
            isConnected=y;
            ans=0;
        }
    }
    
    private Pair dp[][];
    
    private Pair util(int nums1[], int nums2[], int i, int j) {
        if(i==nums1.length || j==nums2.length) {
            return new Pair(0, true);
        }
        
        if(dp[i][j]!=null) return dp[i][j];
        
        if(nums1[i]==nums2[j]) {
            Pair p=util(nums1, nums2, i+1, j+1);
            if(p.isConnected) {
                //subarray continues;
                p.ret=p.ret+1;
                p.ans=Math.max(p.ans, p.ret);
                return dp[i][j]=p;
            }else {
                //new subarray can start from here
                p.ret=1;
                p.isConnected=true;
                p.ans=Math.max(p.ans, p.ret);
                return dp[i][j]=p;
            }
        }else {
            //subarray broken 
            Pair p1=util(nums1, nums2, i, j+1);
            Pair p2=util(nums1, nums2, i+1, j);
            Pair retP=new Pair(0, false);
            retP.ans=Math.max(p1.ans, p2.ans);
            return dp[i][j]=retP;
        }
    }
}