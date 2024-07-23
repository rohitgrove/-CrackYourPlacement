import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        
        List<int[]> list = new ArrayList<>();
        for(int num : nums){
            if(!list.isEmpty() && list.get(list.size()-1)[0] == num){
                list.get(list.size()-1)[1]++;
            }
            else{
                list.add(new int[]{num, 1});
            }
        }
        int n = list.size(); 
        int ans = dp(list, 0, new int[n], n);
        return ans;
    }
    
    private int dp(List<int[]> list, int idx, int[] memo, int n){
        if(idx >= n)
            return 0;
        
        if(memo[idx] != 0)
            return memo[idx];
        
        int curr = list.get(idx)[0] * list.get(idx)[1]; 
        int nextToAdj = dp(list, idx+2, memo, n) + curr;
        
        int adj = dp(list, idx+1, memo, n);
        if(idx<n-1 && list.get(idx+1)[0] != list.get(idx)[0]+1){
            adj += curr;
        }
        memo[idx] = Math.max(adj, nextToAdj);
        return memo[idx];
    }

    public int deleteAndEarnBottomDown(int[] nums) {
        Arrays.sort(nums);
        
        List<int[]> list = new ArrayList<>();
        for(int num : nums){
            if(!list.isEmpty() && list.get(list.size()-1)[0] == num){
                list.get(list.size()-1)[1]++;
            }
            else{
                list.add(new int[]{num, 1});
            }
        }
        int n = list.size(); 
        int[] memo = new int[n];
        
        for(int i=n-1; i>=0; i--){
            int curr = list.get(i)[0] * list.get(i)[1];
            
            int nextToAdj = (i+2 < n ? memo[i+2] : 0) + curr;
            
            int adj = i+1 < n ? memo[i+1] : 0;
            
            if(i<n-1 && list.get(i+1)[0] != list.get(i)[0]+1){
                adj += curr;
            }
            memo[i] = Math.max(adj, nextToAdj);
        }
    
        return memo[0];
    }
}